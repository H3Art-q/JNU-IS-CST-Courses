package lab8.chapter12;
// 12.11

import java.io.*;

public class Exercise12_11 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java RemoveText <Remove_String> <File_path/File_name.txt>");
            System.exit(1);
        }

        String removeString = args[0];

        for (int i = 1; i < args.length; i++) {
            File targetFile = new File(args[i]);
            try {
                FileReader fileReader = new FileReader(targetFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Read all the file, and store data in stringBuilder
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    line = line.replaceAll(removeString, "");
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
