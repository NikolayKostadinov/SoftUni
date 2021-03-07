package P03FirstStepsInCoding;

import java.util.Scanner;

public class P07ProjectCreation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String architectName = sc.nextLine();
        int projectsCount = Integer.parseInt(sc.nextLine());
        int neededTime = projectsCount * 3;
        String message = "The architect " + architectName + " will need " + neededTime + " hours to complete " + projectsCount + " project/s.";
        System.out.println(message);
    }
}
