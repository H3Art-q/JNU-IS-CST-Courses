package mathQuizSolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SolutionWriter {
    private final List<Double> answerList;
    private final List<Boolean> solvableList;
    private final String inputFilePath;
    private final String outputFilePath;
    private final int precision;
    private int answerWriteCount = 0;

    /**
     * Init the solution writer.
     *
     * @param answerList     Receive an answer list calculated by quiz solver
     * @param inputFilePath  Receive a file path of the quiz file,
     *                       it is a template for generating the final quiz-answer file
     * @param outputFilePath Receive a file path of the output quiz-answer file
     * @param precision      Receive a specified precision for formatting each answer's digit
     */
    SolutionWriter(List<Double> answerList,
                   List<Boolean> solvableList,
                   String inputFilePath,
                   String outputFilePath,
                   int precision) {
        this.answerList = answerList;
        this.solvableList = solvableList;
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.precision = precision;
    }

    /**
     * Open the target output file and write the quiz and corresponding answer(given precision) in it.
     */
    public void solutionWrite() {
        FileWriter writer;
        try {
            writer = new FileWriter(outputFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String outputFormat;
                    if (solvableList.get(answerWriteCount)) {
                        // May I found a bug/feature here?

                        // If the quiz modified by user, the space behind equal sign will be automatically removed,
                        // but if the quiz is generated by generator, it won't, I guess there are some hidden
                        // characters that block this operation.

                        // Because of the removal, the answer will directly be attached with the equal sign
                        // And this is why I want to rewrite the parser part, the old version parser cannot deal with
                        // conditions such like "=123", "12-3"
                        outputFormat =
                                // Finally I modified the output format to ensure the answer will be separated
                                (line.charAt(line.length() - 1) == ' ' ? "%s%." : "%s %.")
                                        + precision + "f\n";
                        writer.write(String.format(outputFormat, line, answerList.get(answerWriteCount)));
                        writer.flush();
                    } else {
                        outputFormat = (line.charAt(line.length() - 1) == ' ' ? "UNSOLVABLE\n" : " UNSOLVABLE\n");
                        writer.write(line + outputFormat);
                    }
                    answerWriteCount++;
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }

        System.out.printf("Write %d result(s) successfully in %s\n", this.answerWriteCount, this.outputFilePath);
    }
}
