package first_block.lab1;

import java.lang.StringBuilder;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }

    public static boolean isPalindrome(String ss) {
        return reverseString(ss).equals(ss);
    }

    public static String reverseString(String ss) {
        return new StringBuilder(ss).reverse().toString();
    }
}
