package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v2;

import java.util.Locale;
import java.util.Scanner;

public class P06TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        int maxPower = 0;
        String thePowerfulWord = "";

        while (!"End of words".equals(word)){
            int power = 0;
            for (int i = 0; i < word.length(); i++) {
                power += word.charAt(i);
            }
            if ("aeiouy".contains(String.valueOf(word.toLowerCase(Locale.ROOT).charAt(0)))){
                power = power * word.length();
            } else {
                power = (int)Math.round(power / (double)word.length());
            }

            if (power >= maxPower)
            {
                maxPower = power;
                thePowerfulWord = word;
            }

            word = scan.nextLine();
        }

        System.out.printf("The most powerful word is %s - %d", thePowerfulWord, maxPower);
    }
}
