package mathQuizSolver;

/**
 * @author H3Art
 */
public class QuizSolverMain {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java -jar MathQuizSolver.jar <quiz_path/quiz_name.txt> " +
                    "<precision> <ans_path/ans_name.txt>(optional)");
            System.exit(1);
        }

        if (Integer.parseInt(args[1]) < 0) {
            System.err.println("Error: <precision> cannot be negative");
            System.exit(2);
        }

        String inputFile = args[0];
        String outputFile = "./answer.txt";
        int precision = Integer.parseInt(args[1]);

        if (args.length > 2) {
            outputFile = args[2];
        }

        // Parse and separate quiz to [operand, operator, operand, ...]
        QuizParser quizParser = new QuizParser(inputFile);
        quizParser.quizParse();

        // Calculate the solution and store them in an answer array
        QuizSolver quizSolver = new QuizSolver(
                quizParser.getExpressionList(),
                quizParser.getSolvableList(),
                precision);
        quizSolver.quizSolve();

        // Copy the quiz file and append the solution to every quiz's end
        SolutionWriter solutionWriter = new SolutionWriter(
                quizSolver.getAnswerList(),
                quizParser.getSolvableList(),
                inputFile,
                outputFile,
                precision);
        solutionWriter.solutionWrite();
    }
}
