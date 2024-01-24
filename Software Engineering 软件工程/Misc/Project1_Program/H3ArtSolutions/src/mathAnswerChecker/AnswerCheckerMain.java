package mathAnswerChecker;

/**
 * @author H3Art
 */
public class AnswerCheckerMain {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java -jar MathQuizSolver.jar <ans_path/ans_name.txt> " +
                    "<precision> <checkedAns_path/checkAns_name.txt>(optional)");
            System.exit(1);
        }

        if (Integer.parseInt(args[1]) < 0) {
            System.err.println("Error: <precision> cannot be negative");
            System.exit(2);
        }

        String inputFile = args[0];
        String outputFile = "./checked_answer.txt";
        int precision = Integer.parseInt(args[1]);

        if (args.length > 2) {
            outputFile = args[2];
        }

        // Parse and separate quiz to [operand, operator, operand, ...] and double-type
        // original answer
        EquationParser equationParser = new EquationParser(inputFile);
        equationParser.equationParse();

        // Calculate the solution of [operand, operator, operand, ...] and store them in
        // an answer array
        QuizSolver quizSolver = new QuizSolver(
                equationParser.getExpressionList(),
                equationParser.getStatusList(),
                precision);
        quizSolver.quizSolve();

        // Check the answer in digital precision(strictly) and mathematical equality
        AnswerChecker answerChecker = new AnswerChecker(
                equationParser.getOriginalAnswerList(),
                quizSolver.getAnswerList(),
                precision);
        answerChecker.answerCheck();

        // Copy the answer file and append the judgement to every end of line
        ResultWriter resultWriter = new ResultWriter(
                inputFile,
                outputFile,
                answerChecker.getCheckResultList(),
                quizSolver.getAnswerList(),
                equationParser.getStatusList(),
                precision);
        resultWriter.findMaxLineLength();
        resultWriter.resultWrite();
    }
}
