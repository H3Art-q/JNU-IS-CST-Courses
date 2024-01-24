package mathAnswerChecker;

import java.util.ArrayList;
import java.util.List;

public class AnswerChecker {
    private final List<String> originalAnswerList;
    private final List<Double> answerList;
    private final List<Boolean> checkResultList;
    private final int precision;
    private int correctNumber = 0;

    /**
     * Init the answer checker.
     *
     * @param originalAnswerList Receive an original answer list provided by answer file(parsed by equation parser)
     * @param answerList         Receive an answer list calculated by quiz solver
     * @param precision          Receive a specified precision for calculating and judging
     */
    AnswerChecker(List<String> originalAnswerList, List<Double> answerList, int precision) {
        this.originalAnswerList = originalAnswerList;
        this.answerList = answerList;
        this.precision = precision;
        this.checkResultList = new ArrayList<>();
    }

    /**
     * Check the answers provided by answer file and this program's own answer, by using three ways:
     * 1. Double parse exception checking
     * 2. String type precision checking
     * 3. Double type rounded value comparison
     */
    public void answerCheck() {
        int maxCheckCount = originalAnswerList.size();
        for (int i = 0; i < maxCheckCount; i++) {
            double originalAnswer;
            boolean checkResult = false;

            // Double parse exception checking
            try {
                originalAnswer = Double.parseDouble(originalAnswerList.get(i));
            } catch (NumberFormatException e) {
                checkResultList.add(checkResult);
                continue;
            }

            // String type precision checking & Double type rounded value comparison
            Double beChecked = QuizSolver.round(originalAnswer, precision);
            checkResult = stringPrecisionCheck(originalAnswerList.get(i)) && beChecked.equals(answerList.get(i));
            if (checkResult) {
                correctNumber++;
            }
            checkResultList.add(checkResult);
        }
        System.out.println(maxCheckCount + " quiz check successfully, "
                + correctNumber + " correct"
        );
    }

    /**
     * String type precision checking.
     *
     * @param singleAnswer Receive a String type answer in answer file
     * @return A boolean type value that indicates whether the answer is correct
     */
    public boolean stringPrecisionCheck(String singleAnswer) {
        int answerPrecision = 0;
        for (int i = singleAnswer.length() - 1; i >= 0 && singleAnswer.charAt(i) != '.'; i--) {
            answerPrecision++;
        }
        return answerPrecision == precision;
    }

    public List<Boolean> getCheckResultList() {
        return checkResultList;
    }
}
