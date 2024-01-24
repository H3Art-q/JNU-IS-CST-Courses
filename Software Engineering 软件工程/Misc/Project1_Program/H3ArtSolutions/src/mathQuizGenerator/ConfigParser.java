package mathQuizGenerator;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConfigParser {

    // Default Setting
    private final String inputFilePath;
    private int questionsNum = 10;
    private boolean haveInteger = true;
    private boolean haveFraction = false;
    private boolean haveFixedPoint = false;
    private int minTermsNum = 2;
    private int maxTermsNum = 2;
    private int intMinimum = 0;
    private int intMaximum = 10;
    private boolean haveZeroNumerator = false;
    private int minFracDenominator = 1;
    private int maxFracDenominator = 2;
    private int fracMinimum = 0;
    private int fracMaximum = 10;
    private int minFixedPrecision = 2;
    private int maxFixedPrecision = 2;
    private int fixedMinimum = 0;
    private int fixedMaximum = 10;
    private String outputFileName = "./quiz.txt";
    private boolean questionsNumChange = false;
    private boolean haveIntegerChange = false;
    private boolean haveFractionChange = false;
    private boolean haveFixedPointChange = false;
    private boolean minTermsNumChange = false;
    private boolean maxTermsNumChange = false;
    private boolean intMinimumChange = false;
    private boolean intMaximumChange = false;
    private boolean haveZeroNumeratorChange = false;
    private boolean minFracDenominatorChange = false;
    private boolean maxFracDenominatorChange = false;
    private boolean fracMinimumChange = false;
    private boolean fracMaximumChange = false;
    private boolean minFixedPrecisionChange = false;
    private boolean maxFixedPrecisionChange = false;
    private boolean fixedMinimumChange = false;
    private boolean fixedMaximumChange = false;
    private boolean outputFileNameChange = false;

    /**
     * Init the config parser.
     *
     * @param inputFilePath Receive a file path of quiz configuration
     */
    ConfigParser(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    /**
     * Read the arguments provided by configuration and store in this class.
     */
    public void configParse() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String name = "", value = "";

                if (parts.length == 2) {
                    name = parts[0].trim();
                    value = parts[1].trim();
                }

                switch (name) {
                    case "questionsNum":
                        this.questionsNum = Integer.parseInt(value);
                        this.questionsNumChange = true;
                        break;
                    case "minTermsNum":
                        this.minTermsNum = Integer.parseInt(value);
                        this.minTermsNumChange = true;
                        break;
                    case "maxTermsNum":
                        this.maxTermsNum = Integer.parseInt(value);
                        this.maxTermsNumChange = true;
                        break;
                    case "haveInteger":
                        this.haveInteger = Boolean.parseBoolean(value);
                        this.haveIntegerChange = true;
                        break;
                    case "haveFraction":
                        this.haveFraction = Boolean.parseBoolean(value);
                        this.haveFractionChange = true;
                        break;
                    case "haveFixedPoint":
                        this.haveFixedPoint = Boolean.parseBoolean(value);
                        this.haveFixedPointChange = true;
                        break;
                    case "intMinimum":
                        this.intMinimum = Integer.parseInt(value);
                        this.intMinimumChange = true;
                        break;
                    case "intMaximum":
                        this.intMaximum = Integer.parseInt(value);
                        this.intMaximumChange = true;
                        break;
                    case "haveZeroNumerator":
                        this.haveZeroNumerator = Boolean.parseBoolean(value);
                        this.haveZeroNumeratorChange = true;
                        break;
                    case "minFracDenominator":
                        this.minFracDenominator = Integer.parseInt(value);
                        this.minFracDenominatorChange = true;
                        break;
                    case "maxFracDenominator":
                        this.maxFracDenominator = Integer.parseInt(value);
                        this.maxFracDenominatorChange = true;
                        break;
                    case "fracMinimum":
                        this.fracMinimum = Integer.parseInt(value);
                        this.fracMinimumChange = true;
                        break;
                    case "fracMaximum":
                        this.fracMaximum = Integer.parseInt(value);
                        this.fracMaximumChange = true;
                        break;
                    case "minFixedPrecision":
                        this.minFixedPrecision = Integer.parseInt(value);
                        this.minFixedPrecisionChange = true;
                        break;
                    case "maxFixedPrecision":
                        this.maxFixedPrecision = Integer.parseInt(value);
                        this.maxFixedPrecisionChange = true;
                        break;
                    case "fixedMinimum":
                        this.fixedMinimum = Integer.parseInt(value);
                        this.fixedMinimumChange = true;
                        break;
                    case "fixedMaximum":
                        this.fixedMaximum = Integer.parseInt(value);
                        this.fixedMaximumChange = true;
                        break;
                    case "outputFileName":
                        this.outputFileName = value;
                        this.outputFileNameChange = true;
                        break;
                    default:
                        // skip unknown properties
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

    /**
     * Check if the arguments are valid.
     */
    public void argumentsLegalityCheck() {
        boolean checkResult = true;
        if (questionsNum <= 0) {
            System.err.println("Config error: \"questionsNum\" must be > 0");
            checkResult = false;
        }

        if (minTermsNum < 1) {
            System.err.println("Config error: \"minTermsNum\" must be > 0");
            checkResult = false;
        }

        if (minTermsNum > maxTermsNum) {
            System.err.println("Config error: \"minTermsNum\" cannot be lower than \"maxTermsNum\"");
            checkResult = false;
        }

        if (!(haveInteger || haveFraction || haveFixedPoint)) {
            System.err.println("Config error: At least 1 type operand required");
            checkResult = false;
        }

        if (minFracDenominator > maxFracDenominator && haveFraction) {
            System.err.println("Config error: \"minFracDenominator\" cannot be lower than \"maxFracDenominator\"");
            checkResult = false;
        }

        if (minFixedPrecision < 1 || minFixedPrecision > maxFixedPrecision && haveFixedPoint) {
            System.err.println("Config error: \"minFixedPrecision\" cannot be lower than \"maxFixedPrecision\"" +
                    "/\"minFixedPrecision\" must be > 0");
            checkResult = false;
        }

        if (intMinimum > intMaximum && haveInteger) {
            System.err.println("Config error: \"intMinimum\" cannot be greater than \"intMaximum\"");
            checkResult = false;
        }

        if (fixedMinimum > fixedMaximum && haveFixedPoint) {
            System.err.println("Config error: \"fixedMinimum\" cannot be greater than \"fixedMaximum\"");
            checkResult = false;
        }

        if (fracMaximum - fracMinimum <= 1 && haveFraction) {
            System.err.println(
                    "Config error: The gap between \"fracMinimum\" and \"fracMaximum\" must be greater than 1");
            checkResult = false;
        }

        if (!checkResult) {
            System.exit(3);
        }
    }

    /**
     * Help user to check out setting they've made, list out what kinds of setting
     * this generator perform.
     */
    public void configDisplay() {
        System.out.println("Config parse successfully, details are as follow:");

        System.out.println("questionsNum:       " + questionsNum + (questionsNumChange ? "" : "(Default Value)"));
        System.out.println("minTermsNum:        " + minTermsNum + (minTermsNumChange ? "" : "(Default Value)"));
        System.out.println("maxTermsNum:        " + maxTermsNum + (maxTermsNumChange ? "" : "(Default Value)"));

        System.out.println("haveInteger:        " + haveInteger + (haveIntegerChange ? "" : "(Default Value)"));
        if (haveInteger) {
            System.out.println("intMinimum:         " + intMinimum + (intMinimumChange ? "" : "(Default Value)"));
            System.out.println("intMaximum:         " + intMaximum + (intMaximumChange ? "" : "(Default Value)"));
        }

        System.out.println("haveFixedPoint:     " + haveFixedPoint + (haveFixedPointChange ? "" : "(Default Value)"));
        if (haveFixedPoint) {
            System.out.println("minFixedPrecision:  " + minFixedPrecision +
                    (minFixedPrecisionChange ? "" : "(Default Value)"));
            System.out.println("maxFixedPrecision:  " + maxFixedPrecision +
                    (maxFixedPrecisionChange ? "" : "(Default Value)"));
            System.out.println("fixedMinimum:       " + fixedMinimum + (fixedMinimumChange ? "" : "(Default Value)"));
            System.out.println("fixedMaximum:       " + fixedMaximum + (fixedMaximumChange ? "" : "(Default Value)"));
        }

        System.out.println("haveFraction:       " + haveFraction + (haveFractionChange ? "" : "(Default Value)"));
        if (haveFraction) {
            System.out.println("haveZeroNumerator:  " + haveZeroNumerator +
                    (haveZeroNumeratorChange ? "" : "(Default Value)"));
            System.out.println("minFracDenominator: " + minFracDenominator +
                    (minFracDenominatorChange ? "" : "(Default Value)"));
            System.out.println("maxFracDenominator: " + maxFracDenominator +
                    (maxFracDenominatorChange ? "" : "(Default Value)"));
            System.out.println("fracMinimum:        " + fracMinimum + (fracMinimumChange ? "" : "(Default Value)"));
            System.out.println("fracMaximum:        " + fracMaximum + (fracMaximumChange ? "" : "(Default Value)"));
        }

        System.out.println("outputFileName:     " + outputFileName + (outputFileNameChange ? "" : "(Default Value)"));
    }

    public int getQuestionsNum() {
        return this.questionsNum;
    }

    public int getMinTermsNum() {
        return this.minTermsNum;
    }

    public int getMaxTermsNum() {
        return this.maxTermsNum;
    }

    public boolean isHaveInteger() {
        return this.haveInteger;
    }

    public int getIntMinimum() {
        return this.intMinimum;
    }

    public int getIntMaximum() {
        return this.intMaximum;
    }

    public boolean isHaveFraction() {
        return this.haveFraction;
    }

    public boolean isHaveZeroNumerator() {
        return this.haveZeroNumerator;
    }

    public int getMinFracDenominator() {
        return this.minFracDenominator;
    }

    public int getMaxFracDenominator() {
        return this.maxFracDenominator;
    }

    public int getFracMinimum() {
        return this.fracMinimum;
    }

    public int getFracMaximum() {
        return this.fracMaximum;
    }

    public boolean isHaveFixedPoint() {
        return this.haveFixedPoint;
    }

    public int getMinFixedPrecision() {
        return this.minFixedPrecision;
    }

    public int getMaxFixedPrecision() {
        return this.maxFixedPrecision;
    }

    public int getFixedMinimum() {
        return this.fixedMinimum;
    }

    public int getFixedMaximum() {
        return this.fixedMaximum;
    }

    public String getOutputFileName() {
        return this.outputFileName;
    }
}
