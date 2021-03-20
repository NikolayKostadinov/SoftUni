package L07ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P03AnimalType {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String animalName = scan.nextLine();

        String animalType = "";

        switch (animalName){
            case "dog":
                animalType = "mammal";
                break;
            case "crocodile":
            case "tortoise":
            case "snake":
                animalType = "reptile";
                break;
            default:
                animalType = "unknown";
                break;
        }

        System.out.println(animalType);
    }
}
