package L04StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {
        String sourcePath = new File("src/L04StreamsFilesAndDirectories/Resources/input.txt").getCanonicalPath();
        String destinationPath = new File("src/L04StreamsFilesAndDirectories/Resources/02.WriteToFileOutput.txt").getCanonicalPath();

        FileInputStream inputFileStream = new FileInputStream(sourcePath);
        FileOutputStream outputFileStream = new FileOutputStream(destinationPath);

        Scanner scan = new Scanner(inputFileStream);
        PrintStream printer = new PrintStream(outputFileStream);
        while (scan.hasNextLine()){
            printer.println(scan.nextLine().replaceAll("[,\\.!?]", ""));
        }

        inputFileStream.close();
        outputFileStream.close();
    }
}
