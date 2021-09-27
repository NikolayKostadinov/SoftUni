package L04StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        String sourcePath = new File("src/L04StreamsFilesAndDirectories/Resources/input.txt").getCanonicalPath();
        String destinationPath = new File("src/L04StreamsFilesAndDirectories/Resources/06.SortLinesOutput.txt").getCanonicalPath();

        FileReader fileReader = new FileReader(sourcePath);
        BufferedReader reader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(destinationPath);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        List<String> lines = new ArrayList<>();

        String line = reader.readLine();

        while (line != null){
            lines.add(line);
            line = reader.readLine();
        }

        reader.close();

        Collections.sort(lines);

        writer.write(String.join(System.lineSeparator(), lines));
        writer.flush();

        writer.close();
    }
}
