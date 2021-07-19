package MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03Problem {
    private static final List<String> chat = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        while (!"end".equals(command)){
            String[] tokens = command.split("\\s");
            switch (tokens[0]){
                case "Chat":
                    chat.add(tokens[1]);
                    break;
                case "Delete":
                    deleteMessage(tokens[1]);
                    break;
                case "Edit":
                    editMessage(tokens[1], tokens[2]);
                    break;
                case "Pin":
                    pinMessage(tokens[1]);
                    break;
                case "Spam":
                    spamMessage(tokens);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println(chat.toString().replaceAll("[\\[\\],]","").replaceAll("\\s","\n"));
    }

    private static void spamMessage(String[] messages) {
        for (int i = 1; i < messages.length; i++) {
            chat.add(messages[i]);
        }
    }

    private static void pinMessage(String message) {
        int index = chat.indexOf(message);
        if (index > -1){
            chat.add(message);
            chat.remove(index);
        }
    }

    private static void editMessage(String message, String editedVersion) {
        int index = chat.indexOf(message);
        if (index > -1){
            chat.set(index, editedVersion);
        }
    }

    private static void deleteMessage(String message) {
        int index = chat.indexOf(message);
        if (index > -1){
            chat.remove(index);
        }
    }
}
