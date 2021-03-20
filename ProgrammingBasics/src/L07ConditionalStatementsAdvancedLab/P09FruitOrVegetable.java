package L07ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P09FruitOrVegetable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String plant = scan.nextLine();

        String type = "";
        switch (plant){
            case "banana":
            case "apple":
            case "kiwi":
            case "cherry":
            case "lemon":
            case "grapes":
                plant = "fruit";
            break;
            case "tomato":
            case "cucumber":
            case "pepper":
            case "carrot":
                plant = "vegetable";
                break;
            default:
                plant = "unknown";
        }

        System.out.println(plant);
    }
}
