package lab8.chapter12;
// 12.27

import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Exercise12_27 {
    public static String replaceWord(String line) {
        String matchedPattern = "(Exercise\\d+_\\d+)";

        Pattern regularExpression = Pattern.compile(matchedPattern);

        Matcher matcher = regularExpression.matcher(line);

        while (matcher.find()) {
            String matched = matcher.group(0);

            StringBuilder modified = new StringBuilder(matched);

            // Priorly add 0 to the last one single digit
            if (matched.length() - matched.indexOf('_') == 2) {
                modified.insert(matched.indexOf('_') + 1, '0');
            }

            if (matched.indexOf('_') == 9) {
                modified.insert(8, '0');
            }

            line = line.replaceAll(matched, modified.toString());
        }

        return line;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java Exercise12_27 <file_path/file_name.txt>");
            System.exit(1);
        }

        for (String arg : args) {
            File targetFile = new File(arg);
            try {
                FileReader fileReader = new FileReader(targetFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Read all the file, and store data in stringBuilder
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    line = replaceWord(line);
                    stringBuilder.append(line).append("\n");
                }

                bufferedReader.close();
                fileReader.close();

                // Create a fileWriter to write all the data from stringBuilder to file
                FileWriter fileWriter = new FileWriter(targetFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(stringBuilder.toString());

                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
