package mathQuizGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class QuizGenerator {
    private final List<String> quizSet;
    private final ConfigParser parser;
    private final Random random;
    private final int operandTypeNumber;

    /**
     * Init the quiz generator.
     *
     * @param parser Use the parser to deliver the generation configuration
     */
    QuizGenerator(ConfigParser parser) {
        this.quizSet = new ArrayList<>();
        this.random = new Random();
        this.parser = parser;
        if (parser.isHaveFraction() && parser.isHaveFixedPoint() && parser.isHaveInteger()) {
            operandTypeNumber = 3;
        } else if (
                (!parser.isHaveInteger() && parser.isHaveFraction() && parser.isHaveFixedPoint()) ||
                        (!parser.isHaveFixedPoint() && parser.isHaveInteger() && parser.isHaveFraction()) ||
                        (!parser.isHaveFraction() && parser.isHaveInteger() && parser.isHaveFixedPoint())
        ) {
            operandTypeNumber = 2;
        } else {
            operandTypeNumber = 1;
        }
    }

    /**
     * Generate all quiz.
     */
    public void quizGenerate() {
        int questionNum = parser.getQuestionsNum();
        int maxTerms = parser.getMaxTermsNum();
        int minTerms = parser.getMinTermsNum();
        int termsIncrement = 0;
        int increasingGap = (int) Math.ceil(1.0 * questionNum / (maxTerms - minTerms + 1));

        for (int i = 1; i <= questionNum; i++) {
            String operand = operandGenerate();
            String operator;

            // Generate the first operand without parenthesis(no matter whether it is negative)
            StringBuilder singleQuiz = new StringBuilder(String.format("[%d] %s ", i, operand));

            // The terms of expression will increase
            for (int j = 0; j < (minTerms - 1) + termsIncrement; j++) {
                operand = operandGenerate();
                operator = operatorGenerate();

                singleQuiz.append(operator).append(" ");

                // Avoid division by 0
                while (Objects.equals(operator, "/")) {
                    try {
                        if (operand.startsWith("0|") || Double.parseDouble(operand) == 0.0) {
                            operand = operandGenerate();
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // Non-zero Fraction will cause NumberFormatException
                        break;
                    }
                }

                if (operand.startsWith("-")) {
                    // Add "()" to every negative operand except the first one
                    singleQuiz.append(String.format("(%s) ", operand));
                } else {
                    singleQuiz.append(String.format("%s ", operand));
                }
            }
            singleQuiz.append("= ");
            quizSet.add(singleQuiz.toString());

            // Increments the number of terms in quiz by the quiz number
            if (i % increasingGap == 0) {
                termsIncrement++;
            }
        }
        System.out.println("Generate " + quizSet.size() + " quiz successfully");
    }

    /**
     * Generate an operator.
     *
     * @return an operator
     */
    private String operatorGenerate() {
        int operatorType = random.nextInt(4);
        String operator = null;
        switch (operatorType) {
            // Addition
            case 0:
                operator = "+";
                break;
            // Subtraction
            case 1:
                operator = "-";
                break;
            // Multiplication
            case 2:
                operator = "*";
                break;
            // Division
            case 3:
                operator = "/";
                break;
        }
        return operator;
    }

    /**
     * Generate an operand.
     *
     * @return an operand
     */
    private String operandGenerate() {
        StringBuilder operand = new StringBuilder();

        // Total 7 conditions:
        // 1. Only integer -> 0
        // 2. Only fixed-point number -> 1
        // 3. Only fraction -> 2
        // 4. Integer and fixed-point number -> 0, 1
        // 5. Integer and fraction -> 0, 2
        // 6. fixed-point number and fraction -> 1, 2
        // 7. Among all of 3 types -> 0, 1, 2
        int operandType = random.nextInt(operandTypeNumber);

        switch (operandTypeNumber) {
            case 1:
                if (parser.isHaveFixedPoint()) {
                    operandType = 1;
                } else if (parser.isHaveFraction()) {
                    operandType = 2;
                }
                break;
            case 2:
                if (parser.isHaveInteger() && parser.isHaveFraction() && operandType == 1) {
                    operandType = 2;
                } else if (parser.isHaveFixedPoint() && parser.isHaveFraction() && operandType == 0) {
                    operandType = 2;
                }
                break;
            default:
                break;
        }

        switch (operandType) {
            // Integer
            case 0:
                operand.append(getRandomInteger());
                break;
            // Fixed-point number
            case 1:
                operand.append(getRandomFixedPointNumber());
                break;
            // Fraction
            case 2:
                operand.append(getRandomFraction());
                break;
        }
        return operand.toString();
    }

    /**
     * Generate a random integer with range given by config file.
     *
     * @return a String form random integer
     */
    private String getRandomInteger() {
        return String.valueOf(
                random.nextInt(parser.getIntMaximum() - parser.getIntMinimum() + 1) + parser.getIntMinimum()
        );
    }

    /**
     * Generate a random fixed-point number with range given by config file.
     *
     * @return a String form random fixed-point number
     */
    private String getRandomFixedPointNumber() {
        String fixedNumberFormat = "%." +
                (random.nextInt(parser.getMaxFixedPrecision() - parser.getMinFixedPrecision() + 1)
                        + parser.getMinFixedPrecision()) + "f";
        return String.format(
                fixedNumberFormat,
                (parser.getFixedMaximum() - parser.getFixedMinimum()) * random.nextDouble() + parser.getFixedMinimum());
    }

    /**
     * Generate a random fraction with range given by config file.
     *
     * @return a String form random fraction(like 12|13 or 1_1|4)
     */
    private String getRandomFraction() {
        int integerPart = random.nextInt(parser.getFracMaximum() - parser.getFracMinimum() - 1)
                + parser.getFracMinimum() + 1;
        int numerator = random.nextInt(parser.getMaxFracDenominator() - parser.getMinFracDenominator() + 1)
                + parser.getMinFracDenominator();
        int denominator = random.nextInt(parser.getMaxFracDenominator() - parser.getMinFracDenominator() + 1)
                + parser.getMinFracDenominator();

        // Denominator cannot be 0
        while (denominator == 0) {
            denominator = random.nextInt(parser.getMaxFracDenominator() - parser.getMinFracDenominator() + 1)
                    + parser.getMinFracDenominator();
        }

        // Convert to true fraction
        numerator %= denominator;

        // Non-zero numerator regenerate
        if (numerator == 0 && !parser.isHaveZeroNumerator()) {
            numerator = random.nextInt(Math.abs(denominator)) + 1;
        }

        // Form the total fraction
        if (integerPart != 0) {
            return String.format("%d_%d|%d", integerPart, numerator, denominator);
        } else {
            return String.format("%d|%d", numerator, denominator);
        }
    }

    public List<String> getQuizSet() {
        return quizSet;
    }
}
