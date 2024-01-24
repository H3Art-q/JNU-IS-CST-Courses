package mathQuizGenerator;

/**
 * @author H3Art
 */
public class QuizGeneratorMain {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java -jar MathQuizGenerator.jar <config_path/config_name.txt>");
            System.exit(1);
        }

        // Read the configuration
        ConfigParser configParser = new ConfigParser(args[0]);
        configParser.configParse();
        configParser.argumentsLegalityCheck();
        configParser.configDisplay();

        // Generate the quiz
        QuizGenerator quizGenerator = new QuizGenerator(configParser);
        quizGenerator.quizGenerate();

        // Write the quiz to specified file
        QuizWriter quizWriter = new QuizWriter(configParser.getOutputFileName(), quizGenerator.getQuizSet());
        quizWriter.quizWrite();

    }
}
