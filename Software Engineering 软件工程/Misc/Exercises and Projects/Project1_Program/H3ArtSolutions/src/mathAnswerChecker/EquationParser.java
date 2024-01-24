package mathAnswerChecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationParser {
    private final List<String[]> expressionList;
    private final List<String> originalAnswerList;
    private final List<Integer> statusList;
    private final String inputFilePath;
    public static final int COMPLETE_EQUATION = 1;
    public static final int WITHOUT_ANSWER = 2;
    public static final int CANNOT_FORM_EQUATION = 3;
    private int completeEquationNumber = 0;
    private int withoutAnswerNumber = 0;

    /**
     * Init the equation parser.
     *
     * @param inputFilePath Receive a file path of the quiz file
     */
    EquationParser(String inputFilePath) {
        this.expressionList = new ArrayList<>();
        this.originalAnswerList = new ArrayList<>();
        this.statusList = new ArrayList<>();
        this.inputFilePath = inputFilePath;
    }

    /**
     * read and process every line from the answer text.
     */
    public void equationParse() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    equationProcess(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(3);
        }
        System.out.println(expressionList.size() + " equation parse successfully, "
                + completeEquationNumber + " complete, "
                + withoutAnswerNumber + " without answer, "
                + (statusList.size() - completeEquationNumber - withoutAnswerNumber) + " illegal"
        );
    }

    /**
     * The process procedure can be divided into four part:
     * 1. Remove the parenthesis, space and quiz number;
     * 2. Part the equation into operands and operators;
     * 3. Check whether the partitions can form a legal expression and have answer;
     * 4. Parse the fraction of total expression and store the answer(if exist)
     * in expressionList and answerList respectively.
     *
     * @param line Receive a String type line
     */
    private void equationProcess(String line) {
        // Remove the parenthesis, space and quiz number
        line = line.replaceAll("(\\()|(\\))|( )", "");
        line = line.replaceFirst("\\[\\d+]", "");
        line = fractionProcess(line);

        // Part the equation into operands and operators
        String[] partitions = completelySplit(line);

        // Check whether the partitions can form a legal expression and have answer
        int status = equationClassify(partitions);
        statusList.add(status);

        // Parse the fraction and store the answer(if exist) in expressionList and answerList
        int length = partitions.length;
        String[] expression;
        switch (status) {
            case COMPLETE_EQUATION:
                expression = new String[length - 2];
                System.arraycopy(partitions, 0, expression, 0, length - 2);
                expressionList.add(expression);
                originalAnswerList.add(partitions[length - 1]);
                completeEquationNumber++;
                break;
            case WITHOUT_ANSWER:
                expression = new String[partitions.length - 1];
                System.arraycopy(partitions, 0, expression, 0, partitions.length - 1);
                expressionList.add(expression);
                originalAnswerList.add("Unsolved");
                withoutAnswerNumber++;
                break;
            case CANNOT_FORM_EQUATION:
                expression = new String[0];
                expressionList.add(expression);
                originalAnswerList.add("Can't solve");
                break;
            default:
                throw new RuntimeException("Invalid status");
        }
    }

    /**
     * The new feature——negative numerator or negative denominator can not be split correctly,
     * therefore, this method is used for modifying the fraction format, it read a line and
     * use regular expression to match fraction, then modify them, make them able to be split.
     *
     * @param line Receive a String type expression,
     * @return A fractions processed String
     */
    private String fractionProcess(String line) {
        // Prefix "+" for processing the fraction which is the first element of expression(if exist)
        line = "+" + line;
        Matcher matcher = Pattern
                .compile("((\\+)|(-)|(\\*)|(/)|(_))(((\\+)|(-))?\\d+\\|((\\+)|(-))?\\d+)")
                .matcher(line);
        // Every time find a fraction
        while (matcher.find()) {
            // Remove the connected operand, record this part for replacement
            String replaceTemplate = matcher.group(0).substring(1);
            String replaceResult = replaceTemplate;
            replaceResult = replaceResult.replaceAll("\\+", "");

            Matcher negativeMatcher = Pattern.compile("-").matcher(replaceResult);
            int negativeSignCount = 0;
            while (negativeMatcher.find()) {
                negativeSignCount++;
            }

            replaceResult = replaceResult.replaceAll("-", "");
            // '!' is symbol for identified numerator or denominator is negative
            if (negativeSignCount == 1) {
                replaceResult = replaceResult.replaceAll("\\|", "@");
            }

            replaceTemplate = replaceTemplate.split("\\|")[0] + "\\|" + replaceTemplate.split("\\|")[1];
            line = line.replaceFirst(replaceTemplate, replaceResult);
        }
        return line.substring(1);
    }

    /**
     * Part the equation into parts of operator and operand and store them in a String array.
     *
     * @param line Receive a String type equation, it must have been removed quiz number, parenthesis and space
     */
    private String[] completelySplit(String line) {
        List<String> partitions = new ArrayList<>();
        Matcher matcher = Pattern.compile("(\\+)|(-)|(\\*)|(/)|(=)").matcher(line);
        String addString, lastString = "+";
        boolean reservedSymbol = false;
        int startFindIndex = 0;

        // Find an operator
        while (matcher.find()) {
            // Store the part which is before the found operator
            addString = line.substring(startFindIndex, matcher.start());
            if (!addString.isEmpty()) {
                partitions.add(reservedSymbol ? lastString + addString : addString);
            }
            reservedSymbol = false;

            // Do not update the lastString in this situation, it only happens in
            // 1. The first element is an operand
            // 2. The continuous elements are both operands
            lastString = !addString.isEmpty() ? addString : lastString;

            // Store the operator
            // If it is an "-" or "+", check whether the last one added element is an operator
            // If the last one is an operator, reserve this now "-" or "+" until next find()
            addString = line.substring(matcher.start(), matcher.end());
            if (addString.matches("(\\+)|(-)") && lastString.matches("(\\+)|(-)|(\\*)|(/)|(=)")) {
                reservedSymbol = true;
            } else {
                partitions.add(addString);
            }

            lastString = addString;
            startFindIndex = matcher.end();
        }

        // Store all the part after the final operator
        addString = line.substring(startFindIndex);
        if (!addString.isEmpty()) {
            partitions.add(reservedSymbol ? lastString + addString : addString);
        }

        return partitions.toArray(new String[0]);
    }

    /**
     * Classify the equation into three status by checking every element in it:
     * COMPLETE_EQUATION -> {@value COMPLETE_EQUATION};
     * WITHOUT_ANSWER -> {@value WITHOUT_ANSWER};
     * CANNOT_FORM_EQUATION -> {@value CANNOT_FORM_EQUATION}.
     *
     * @param equationCompletePartitions Receive a String[] type equation parted element array
     * @return An int type number represented the status of checked equation
     */
    private int equationClassify(String[] equationCompletePartitions) {
        int length = equationCompletePartitions.length, status = COMPLETE_EQUATION;

        // The lower bound of an equation, eg: 2 = without answer, it has 2 elements
        if (length < 2) {
            return CANNOT_FORM_EQUATION;
        }

        // Check equal sign
        if (equationCompletePartitions[length - 1].matches("^=$")) {
            status = WITHOUT_ANSWER;
        } else if (!equationCompletePartitions[length - 2].matches("^=$")) {
            // Without equal sign, it is defined an illegal expression
            return CANNOT_FORM_EQUATION;
        }

        // Check expression(exclude equal sign and answer part)
        int finalCheckIndex = status == WITHOUT_ANSWER ? length - 2 : length - 3;
        if (!expressionCheck(equationCompletePartitions, finalCheckIndex)) {
            return CANNOT_FORM_EQUATION;
        }

        return status;
    }

    /**
     * Check expression(exclude equal sign and answer part) by alternately checking
     * the legality of its operand and operator.
     *
     * @param expression      Receive a String[] type equation parted element array
     * @param finalCheckIndex Receive an int type index pointing at the position of final operand
     * @return A boolean type result represents whether the expression is legal
     */
    private boolean expressionCheck(String[] expression, int finalCheckIndex) {
        // An expression should end with an operand
        if (finalCheckIndex % 2 == 1) {
            return false;
        }
        boolean checkOperand = true;
        // Check operand and operator alternately
        for (int i = 0; i <= finalCheckIndex; i++) {
            if (checkOperand) {
                if (!expression[i].matches(
                        // Integer
                        "(^((\\+)|(-))?\\d+$)|" +
                                // |fixed-point number| ≥ ±1
                                "(^((\\+)|(-))?[1-9]+\\d*\\.\\d+$)|" +
                                // |fixed-point number| < ±1
                                "(^((\\+)|(-))?0\\.\\d+$)|" +
                                // fraction with positive numerator and denominator
                                "(^((\\+)|(-))?(\\d+_)?\\d+\\|\\d+$)|" +
                                // fraction with negative numerator or denominator
                                "(^((\\+)|(-))?(\\d+_)?\\d+@\\d+$)"
                )) {
                    return false;
                }
            } else {
                if (!expression[i].matches("^[+\\-*/]$")) {
                    return false;
                }
            }
            checkOperand = !checkOperand;
        }
        return true;
    }

    public List<String> getOriginalAnswerList() {
        return originalAnswerList;
    }

    public List<String[]> getExpressionList() {
        return expressionList;
    }

    public List<Integer> getStatusList() {
        return statusList;
    }
}
