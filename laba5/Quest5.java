package first_block.laba5;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Quest5 {
    public static void main(String[] args) {
    
        showRightWords("Search or enter an address", 'e');
    }

    private static void showRightWords(String message, char symbol) {
        try {

            Pattern pattern = Pattern.compile("\\b" + symbol + "\\w+\\b");
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.err.println(e);

        }
    }
}
