package L04StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String sourcePath = new File("src/L04StreamsFilesAndDirectories/Resources/input.txt").getCanonicalPath();
        String destinationPath = new File("src/L04StreamsFilesAndDirectories/Resources/04.ExtractIntegersOutput.txt").getCanonicalPath();


        FileInputStream inputFileStream = new FileInputStream(sourcePath);
        FileOutputStream outputFileStream = new FileOutputStream(destinationPath);

        Scanner scan = new Scanner(inputFileStream);
        PrintStream printer = new PrintStream(outputFileStream);
        while (scan.hasNextLine()) {
            if (scan.hasNextInt()) {
                printer.println(scan.nextInt());
            }
            scan.next();
        }

        inputFileStream.close();
        outputFileStream.close();
    }
}
