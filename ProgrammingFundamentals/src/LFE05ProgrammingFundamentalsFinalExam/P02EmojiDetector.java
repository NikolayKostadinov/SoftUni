package LFE05ProgrammingFundamentalsFinalExam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    private static final String COOLNESS_PATTERN = "\\d";
    private static final String EMOJI_PATTERN = "(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile(COOLNESS_PATTERN);
        Matcher matcher = pattern.matcher(input);
        BigInteger coolnessFactor = BigInteger.valueOf(1);

        while (matcher.find()) {
            coolnessFactor = coolnessFactor.multiply(new BigInteger(matcher.group()));
        }

        Pattern emoji_pattern = Pattern.compile(EMOJI_PATTERN);
        Matcher emoji_matcher = emoji_pattern.matcher(input);

        List<EmojiParams> emojis = new ArrayList<>();

        while (emoji_matcher.find()) {
            String emoji = emoji_matcher.group();
            String emoji_text = emoji_matcher.group("emoji");
            BigInteger emojiCoolness = BigInteger.valueOf(1);

            for (int c : emoji_text.toCharArray()) {
                emojiCoolness = emojiCoolness.add(BigInteger.valueOf(c));
            }

            emojis.add(new EmojiParams(emojiCoolness, emoji));
        }

        System.out.printf("Cool threshold: %s \n", coolnessFactor);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", emojis.size());
        BigInteger finalCoolnessFactor = coolnessFactor;
        emojis
                .stream()
                .filter(e->e.emoji_coolness.compareTo(finalCoolnessFactor) >= 0)
                .forEach(e-> System.out.println(e.emoji));
    }

    private static class EmojiParams{
        private BigInteger emoji_coolness;
        private String emoji;

        public EmojiParams(BigInteger emoji_coolness, String emoji) {
            this.emoji_coolness = emoji_coolness;
            this.emoji = emoji;
        }

        public String getEmoji() {
            return emoji;
        }

        public BigInteger getEmoji_coolness() {
            return emoji_coolness;
        }
    }
}
