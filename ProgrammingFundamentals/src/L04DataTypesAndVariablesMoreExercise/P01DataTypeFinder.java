package L04DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        while (!"END".equals(command)) {
            String type = "";
            Scanner input = new Scanner(command);
            if (input.hasNextInt()) {
                type = "integer";
            } else if(input.hasNextDouble()){
                type = "floating point";
            } else if(input.hasNextBoolean()){
                type = "boolean";
            } else if (command.length() == 1){
                type = "character";
            }else if (input.hasNextLine()){
                type = "string";
            }
            System.out.printf("%s is %s type\n", command, type);
            command = scan.nextLine();
        }
    }
}
