package mathAnswerChecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultWriter {
    private final String inputFilePath;
    private final String outputFilePath;
    private final List<Boolean> checkResultList;
    private final List<Double> expectedAnswerList;
    private final List<Integer> statusList;
    private final int precision;
    private int maxLineLength = 0;
    private int checkCount = 0;


    /**
     * Init the result writer.
     *
     * @param inputFilePath      Receive a file path of the answer file,
     *                           it is a template for generating the final check result file
     * @param outputFilePath     Receive a file path of the output check result file
     * @param checkResultList    Receive a check result list for generating output format
     * @param expectedAnswerList Receive an expected answer list for pointing out the wrong and expected result
     * @param statusList         Receive a status list for generating output format
     * @param precision          Receive a specified precision for formatting
     */
    ResultWriter(
            String inputFilePath,
            String outputFilePath,
            List<Boolean> checkResultList,
            List<Double> expectedAnswerList,
            List<Integer> statusList,
            int precision
    ) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.checkResultList = checkResultList;
        this.expectedAnswerList = expectedAnswerList;
        this.statusList = statusList;
        this.precision = precision;
    }

    /**
     * Find the longest line of the original answer file then record its length.
     * Getting the maxLineLength can uniform the position of judgement label.
     */
    public void findMaxLineLength() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    if (line.length() > maxLineLength) {
                        maxLineLength = line.length();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }
    }

    /**
     * Read the original answer file and make a copy, append the judgement label in the duplication.
     */
    public void resultWrite() {
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
                    writer.write(resultFormat(line, checkCount++));
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(5);
        }

        System.out.printf("Write %d check result(s) successfully in %s\n", this.checkCount, this.outputFilePath);
    }

    /**
     * @param line            Receive a String type line of original equation
     * @param answerListIndex Receive an int type index for getting corresponding info of an equation
     * @return A line appended with corresponding judgement label
     */
    private String resultFormat(String line, int answerListIndex) {
        if (checkResultList.get(answerListIndex)) {
            return String.format("%-" + (maxLineLength + 1) + "s[CORRECT]\n", line);
        } else if (statusList.get(answerListIndex) == EquationParser.CANNOT_FORM_EQUATION) {
            return String.format("%-" + (maxLineLength + 1) + "s[ILLEGAL EXPRESSION]\n", line);
        } else if (statusList.get(answerListIndex) == EquationParser.WITHOUT_ANSWER) {
            String formatter = "%-" + (maxLineLength + 1) + "s[UNSOLVED(expected: %." + precision + "f)]\n";
            return String.format(formatter, line, expectedAnswerList.get(answerListIndex));
        } else {
            String formatter = "%-" + (maxLineLength + 1) + "s[WRONG(expected: %." + precision + "f)]\n";
            return String.format(formatter, line, expectedAnswerList.get(answerListIndex));
        }
    }
}
