package first_block.laba5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quest2 {
    public static void main(String[] args) {
        System.out.println(check(""));
        System.out.println(check("asdfghjk"));
        System.out.println(check("Asdfghjk"));
        System.out.println(check("A1sdfghjk"));
        System.out.println(check("A1qwert"));
        
        
    }
    private static boolean check(String password){

        Pattern pattern = Pattern.compile("\\b[A-Za-z0-9]{8,16}\\b");
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {
            pattern = Pattern.compile("\\d");
            matcher = pattern.matcher(password);
            if (matcher.find()) {
                pattern = Pattern.compile("[A-Z]");
                matcher = pattern.matcher(password);
                if (matcher.find()) {
                    return true;
                }
            }
        }
        return false;
    }    
}
