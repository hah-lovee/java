package first_block.laba5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quest1 {

    public static void main(String[] args) {
        String str = "The price of the product is $1995.99 89.4 8 00 001";
        Pattern pattern = Pattern.compile("(\\d*\\.\\d+|\\d+)");

        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            try {
                System.out.println(Integer.parseInt(matcher.group()));
            }
            catch (Exception ex){
                System.out.println(Double.parseDouble(matcher.group()));
            }
        }

    }
}
