package first_block.src;


import java.lang.StringBuilder;
import java.util.Arrays;
import static java.lang.Math.*;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Task3 {
    public static void main(String[] args) {

        // task 1
    //        System.out.println(replaceVovels("apple"));
    //        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code"));

        // task 2
//        System.out.println(stringTransform("hello"));
//        System.out.println(stringTransform("bookkeeper"));
//        System.out.println(stringTransform("reeest"));

        // task 3
//        int[] ar1 = {1,3,5,4,5};
//        int[] ar2 = {1,8,1,1,1};
//        int[] ar3 = {1,2,2,1,1};
//        System.out.println(doesBlockkFit(ar1));
//        System.out.println(doesBlockkFit(ar2));
//        System.out.println(doesBlockkFit(ar3));

        // task 4
//        System.out.println(flipEndChars("Cat, dog, and mouse."));
//        System.out.println(flipEndChars("ada"));
//        System.out.println(flipEndChars("Ada"));
//        System.out.println(flipEndChars("z"));

        // task 5
//        System.out.println(isValidHexCode("#CD5C5C"));
//        System.out.println(isValidHexCode("#EAECEE"));
//        System.out.println(isValidHexCode("#eaecee"));
//        System.out.println(isValidHexCode("#CD5C58C"));
//        System.out.println(isValidHexCode("#CD5C5Z"));
//        System.out.println(isValidHexCode("#CD5C&C"));
//        System.out.println(isValidHexCode("CD5C5C"));

        // task 6
//        int[] ar4 = {1, 3, 4, 4, 4};
//        int[] ar5 = {2, 5, 7};
//        int[] ar6 = {9, 8, 7, 6};
//        int[] ar7 = {4, 4, 3, 1};
//        int[] ar8 = {2};
//        int[] ar9 = {3, 3, 3, 3, 3};
//
//        System.out.println(same(ar4, ar5));
//        System.out.println(same(ar6, ar7));
//        System.out.println(same(ar8, ar9));

        // task 7
//        System.out.println(isKaprekar(3));
//        System.out.println(isKaprekar(5));
//        System.out.println(isKaprekar(297));

        // task 8
//        System.out.println(longestZero("01100001011000"));
//        System.out.println(longestZero("100100100"));
//        System.out.println(longestZero("11111"));

        // task 9
//        System.out.println(nextPrime(12));
//        System.out.println(nextPrime(24));
//        System.out.println(nextPrime(11));

        // task 10
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));






    }


    // task 1
    public static String replaceVovels(String s) {
        String symbols = "aeiouy";
        char[] s_ar = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char i: s_ar) {
            if (symbols.contains(Character.toString(i))) {
                i = '*';
            }
            result.append(i);
        }
        return result.toString();
    }

    //task 2
    public static String stringTransform(String s) {
        String arg = "Double";
        StringBuilder result = new StringBuilder();

        for (int i=0; i < s.length()-1; i++) {
            if (s.charAt(i)==s.charAt(i+1)) {
                result.append(arg.concat(Character.toString(s.charAt(i)).toUpperCase()));
                i+=1;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.append(s.charAt(s.length()-1)).toString();
    }

    // task 3
    public static boolean doesBlockkFit(int[] ar) {
        int[] params_fig = Arrays.copyOfRange(ar, 0, 3);
        int[] params_hole = Arrays.copyOfRange(ar, 3, 5);

        if (min(ar[0], min(ar[1], ar[2])) <= min(ar[3], ar[4]) &&
                max(min(ar[0], ar[1]), min(max(ar[0],ar[1]),ar[2])) <= max(ar[3], ar[4])) {
            return true;
        }

        return false;
    }

    // task 4
    public static String flipEndChars(String str) {
        if (str.length() < 2) {
            return "Incompatible";
        }

        char[] ch = str.toCharArray();

        char temp = ch[0];
        if (temp == ch[ch.length - 1]) {
            return "Two's a pair";
        }
        ch[0] = ch[ch.length - 1];
        ch[ch.length - 1] = temp;

        return String.valueOf(ch);

    }

    // task 5
    public static boolean isValidHexCode(String str) {
    if (str.length() != 7) {
        return false;
    }
    char[] ch = str.toCharArray();
    if (ch[0] != '#') {
        return false;
    }
    for (int i=1; i!=ch.length; i++) {
        if (!"0123456789abcdefABCDEF".contains(String.valueOf(ch[i]))) {
            return false;
        }
    }
    return true;
    }

    // task 6
    public static boolean same(int[] ar1, int[]ar2) {

        Set<Integer> uniquear1 = new HashSet<>();
        Set<Integer> uniquear2 = new HashSet<>();


        for (int number : ar1) {
            if (!uniquear1.contains(number)) {
                uniquear1.add(number);
            }
        }


        for (int number : ar2) {
            if (!uniquear2.contains(number)) {
                uniquear2.add(number);
            }
        }

        if (uniquear1.size() == uniquear2.size()) {
            return true;
        } else {
            return false;
        }

    }

    // task 7
    public static boolean isKaprekar(int n) {
        int n2 = n*n;

        String number_str = Integer.toString(n2);
        int len = number_str.length();

        if (len % 2 != 0) {
            len += 1;
            number_str = "0" + number_str;
        }

        int index = len / 2;

        String leftPart = number_str.substring(0, index);
        String rightPart = number_str.substring(index);

        int left = Integer.parseInt(leftPart);
        int right = Integer.parseInt(rightPart);
        if (left + right == n) {
            return true;
        } else {
            return false;
        }
    }

    // task 8
    public static String longestZero(String str) {
        String[] substrings = str.split("1"); // Разделяем строку по единицам

        String maxZeroSubstring = "";
        int maxZeroLength = 0;

        for (String substring : substrings) {
            if (substring.length() > maxZeroLength) {
                maxZeroLength = substring.length();
                maxZeroSubstring = substring;
            }
        }
        return maxZeroSubstring;
    }

    // task 9
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nextPrime(int startNumber) {
        int nextNumber = startNumber;
        while (true) {
            if (isPrime(nextNumber)) {
                return nextNumber;
            }
            nextNumber++;
        }
    }

    // task 10
    public static boolean rightTriangle(int x, int y, int z) {
        if (pow(max(x, max(y, z)), 2) == pow(min(x, min(y, z)), 2) + pow(max(min(x, y), min(max(x, y), z)), 2)) {
            return true;
        } else {
            return false;
        }
    }

}

