package mathAnswerChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QuizSolver {
    private final List<String[]> expressionList;
    private final List<Integer> statusList;
    private final List<Double> answerList;
    private final int precision;
    private int solveCount = 0;

    /**
     * Init the quiz solver.
     *
     * @param expressionList Receive a parsed expressions list
     * @param statusList     Receive an equation status list to judge whether it should be solved
     * @param precision      Receive a specified precision for calculating final result
     */
    QuizSolver(List<String[]> expressionList, List<Integer> statusList, int precision) {
        this.expressionList = expressionList;
        this.statusList = statusList;
        this.precision = precision;
        this.answerList = new ArrayList<>();
    }

    /**
     * Convert real number to given precision by rounding.
     *
     * @return A double-type rounded number
     */
    public static double round(double number, int precision) {
        double zoom = Math.pow(10, precision);
        number *= zoom;
        long temp = Math.round(number);
        return 1.0 * temp / zoom;
    }

    /**
     * Calculate every quiz and store answers in this class.
     */
    public void quizSolve() {
        int totalLength = expressionList.size();
        for (int i = 0; i < totalLength; i++) {
            if (statusList.get(i) == EquationParser.CANNOT_FORM_EQUATION) {
                // For expression which can't be solved, still
                // occupy a place, keep the sequence of answerList correct
                answerList.add(0.0);
            } else {
                answerList.add(singleQuizSolve(expressionList.get(i)));
                solveCount++;
            }
        }
        System.out.println(solveCount + " quiz solve successfully");
    }

    /**
     * <p>Priority:
     * <p>+ == -;</p>
     * <p>* == /;</p>
     * <p>+ - < * /;</p>
     * <p>Rules:</p>
     * <p>1. Meet operand, push in operand stack;</p>
     * <p>2. Meet operator when the operator stack is empty or when the top
     * of operator stack's priority is lower, push it;</p>
     * <p>3. Meet operator when the top of operator stack's priority is
     * equal or greater, pop 2 operands and the top of operator stack,
     * calculate them then push back to the operand stack, finally
     * push this operator.</p>
     *
     * @param expression Receive a String[] type expression element array
     */
    private double singleQuizSolve(String[] expression) {
        Stack<Double> operand = new Stack<>();
        Stack<String> operator = new Stack<>();
        for (String element : expression) {
            switch (element) {
                case "+":
                case "-":
                    if (!operator.isEmpty()) {
                        // Operation sequence = The reversion of pop sequence
                        double activeOperand = operand.pop();
                        double passiveOperand = operand.pop();
                        operand.push(calculation(passiveOperand, activeOperand, operator.pop()));
                    }
                    operator.push(element);
                    break;
                case "*":
                case "/":
                    if (!operator.isEmpty() && "*/".contains(operator.peek())) {
                        double activeOperand = operand.pop();
                        double passiveOperand = operand.pop();
                        operand.push(calculation(passiveOperand, activeOperand, operator.pop()));
                    }
                    operator.push(element);
                    break;
                default:
                    if (element.matches("(((\\+)|(-))?(\\d+_)?\\d+\\|\\d+)|(((\\+)|(-))?(\\d+_)?\\d+@\\d+)")) {
                        element = fractionToFixedPoint(element);
                    }
                    operand.push(Double.parseDouble(element));
            }
        }
        // Do calculation until "The operand stack has only 1 element(final result)"
        while (!operator.isEmpty()) {
            double activeOperand = operand.pop();
            double passiveOperand = operand.pop();
            operand.push(calculation(passiveOperand, activeOperand, operator.pop()));
        }
        return round(operand.pop(), precision);
    }

    /**
     * Parse the fraction and convert it to a fixed-point number.
     *
     * @param fraction Receive a String type fraction
     * @return A String type fixed-point number
     */
    private String fractionToFixedPoint(String fraction) {
        // Remove the '|' and '_'(if '_' exist)
        boolean containNegative = fraction.contains("@");
        String[] fractionPart = fraction.split("(_)|(\\|)|(@)");
        double fractionValue;
        double integerPart = 0;
        double numerator;
        double denominator;

        // matches "any number | any number"
        if (fractionPart.length == 2) {
            numerator = Double.parseDouble(fractionPart[0]);
            denominator = Double.parseDouble(fractionPart[1]);
        }
        // matches "any number _ any number | any number"
        else {
            integerPart = Double.parseDouble(fractionPart[0]);
            numerator = Double.parseDouble(fractionPart[1]);
            denominator = Double.parseDouble(fractionPart[2]);
        }
        fractionValue = containNegative ?
                integerPart + -numerator / denominator :
                integerPart + numerator / denominator;
        return String.valueOf(fractionValue);
    }

    /**
     * Do the calculation with given operands and operator.
     *
     * @param passiveOperand Represent minuend or dividend
     * @param activeOperand  Represent subtrahend or divisor
     * @return A double-type result
     */
    public double calculation(double passiveOperand, double activeOperand, String operator) {
        double result;
        switch (operator) {
            case "+":
                result = passiveOperand + activeOperand;
                break;
            case "-":
                result = passiveOperand - activeOperand;
                break;
            case "*":
                result = passiveOperand * activeOperand;
                break;
            case "/":
                result = passiveOperand / activeOperand;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        return result;
    }

    public List<Double> getAnswerList() {
        return answerList;
    }
}
