package L16TextProcessingExercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        int extensionDelimiteIndex = path.lastIndexOf(".");
        int fileNameStartIndex = path.lastIndexOf("\\") + 1;

        String fileName = path.substring(fileNameStartIndex, extensionDelimiteIndex);
        String extension = path.substring(extensionDelimiteIndex+1);

        System.out.printf("File name: %s\n",fileName);
        System.out.printf("File extension: %s\n",extension);
    }
}
