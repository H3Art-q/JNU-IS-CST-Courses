package mathQuizGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class QuizWriter {
    private final String outputFilePath;
    private final List<String> questions;
    private int quizWriteCount = 0;

    /**
     * Init the quiz writer.
     *
     * @param outputFilePath Receive a file path of writing the quiz
     * @param questions      Receive all the quiz as a list
     */
    QuizWriter(String outputFilePath, List<String> questions) {
        this.outputFilePath = outputFilePath;
        this.questions = questions;
    }

    /**
     * Open the target output file and write all quiz in it.
     */
    public void quizWrite() {
        FileWriter writer;
        try {
            writer = new FileWriter(outputFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            for (String question : questions) {
                writer.write(question + "\n");
                // flush() promises every single can be written
                writer.flush();
                quizWriteCount++;
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Writing output file error: " + e.getMessage());
            System.exit(4);
        }

        System.out.printf("Write %d quiz successfully in %s\n", this.quizWriteCount, this.outputFilePath);
    }
}