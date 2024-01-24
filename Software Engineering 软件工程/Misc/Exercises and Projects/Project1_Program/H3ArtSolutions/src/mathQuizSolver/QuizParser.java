package mathQuizSolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuizParser {
    private final List<String[]> expressionList;
    private final List<Boolean> solvableList;
    private final String inputFilePath;
    private int solvableQuizNumber = 0;

    /**
     * Init the quiz parser.
     *
     * @param inputFilePath Receive a file path of the quiz file
     */
    QuizParser(String inputFilePath) {
        this.expressionList = new ArrayList<>();
        this.solvableList = new ArrayList<>();
        this.inputFilePath = inputFilePath;
    }

    /**
     * Parse every quiz and store them in this class.
     */
    public void quizParse() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!(line.isEmpty())) {
                    expressionProcess(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(3);
        }
        System.out.println(expressionList.size() + " quiz parse successfully, " + solvableQuizNumber + " solvable, "
                + (expressionList.size() - solvableQuizNumber) + " illegal");
    }

    /**
     * The process procedure can be divided into four part:
     * 1. Remove the parenthesis, space and quiz number;
     * 2. Part the equation into operands and operators;
     * 3. Check whether the partitions can form a legal expression;
     * 4. Parse the fraction and store the expression in expressionList.
     *
     * @param line Receive a String type line
     */
    private void expressionProcess(String line) {
        // Remove the parenthesis, space and quiz number
        line = line.replaceAll("(\\()|(\\))|( )", "");
        line = line.replaceFirst("\\[\\d+]", "");
        line = fractionProcess(line);

        String[] expressionPartitions = completelySplit(line);

        boolean isLegal = expressionLegalityJudge(expressionPartitions);
        solvableList.add(isLegal);

        if (isLegal) {
            String[] expression = new String[expressionPartitions.length - 1];
            System.arraycopy(expressionPartitions, 0, expression, 0, expressionPartitions.length - 1);
            expressionList.add(expression);
            solvableQuizNumber++;
        } else {
            expressionList.add(new String[0]);
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
     * Part the expression into parts of operator and operand and store them in a String array.
     *
     * @param line Receive a String type expression, quiz number, parenthesis and space must have been removed
     * @return A String[] type array storing every operand and operator
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

            // Do not update the last addString in this situation, it only happens in
            // 1. The first element is an operand
            // 2. The continuous elements are operands
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
     * Judge whether the total quiz is legal.
     *
     * @param equationCompletePartitions Receive a String[] type quiz parted element array
     * @return A boolean type value represented the legality of checked quiz
     */
    private Boolean expressionLegalityJudge(String[] equationCompletePartitions) {
        int length = equationCompletePartitions.length;
        // The lower bound of an equation, eg: 2 = has 2 elements
        if (length < 2) {
            return false;
        }
        // Check equal sign
        if (!equationCompletePartitions[length - 1].matches("^=$")) {
            return false;
        }
        // Check expression(exclude equal sign)
        return expressionCheck(equationCompletePartitions);
    }

    /**
     * Check expression(exclude equal sign) by alternately checking the legality of its operand and operator.
     *
     * @param expression Receive a String[] type quiz parted element array
     * @return A boolean type result represents whether the expression is legal
     */
    private boolean expressionCheck(String[] expression) {
        int finalCheckIndex = expression.length - 2;
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

    public List<String[]> getExpressionList() {
        return expressionList;
    }

    public List<Boolean> getSolvableList() {
        return solvableList;
    }
}
