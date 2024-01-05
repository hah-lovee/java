package first_block.src;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.lang.StringBuilder;
//import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

//        task 1
        System.out.println("task 1");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        // task 2
        System.out.println("task 2");

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        // task 3
        System.out.println("task 3");

        int[] Array = {44, 32, 86, 19};
        System.out.println(differenceEvenOdd(Array));
        int[] Array2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(Array2));

        // task 4
        System.out.println("task 4");

        int[] Array3 = {1, 2, 3, 4, 5};
        System.out.println(equalToAgr(Array3));
        int[] Array4 = {1, 2, 3, 4, 6};
        System.out.println(equalToAgr(Array4));

        // task 5 странный вывод массивов
        System.out.println("task 5");

        int[] ar6 = {1, 2, 3};
        System.out.println(Arrays.toString(indexMul(ar6)));
        int[] ar7 = {3, 3, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMul(ar7)));




        // task 6
        System.out.println("task 6");

        System.out.println(reverse("Hello world"));
        System.out.println(reverse("The quick brown fox"));

        // task 7
        System.out.println("task 7");

        System.out.println(fibonacci(7));
        System.out.println(fibonacci(11));

        // task 8
        System.out.println("task 8");

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        // task 9
        System.out.println("task 9");

        System.out.println(botHelper("Hello, I’m under the water, please helper me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        // task 10
        System.out.println("task 10");

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

//    task 1
    public static boolean duplicateChars(String word) {
        word = word.toLowerCase();

        for (int i=0; i < word.length(); i++) {
            for (int j=i+1; j < word.length(); j++) {
                char ch1 = word.charAt(i);
                char ch2 = word.charAt(j);
                if (Character.compare(ch1, ch2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // task 2
    public static String getInitials(String fio) {
        String[] parts = fio.split(" ");
        String first_name = Character.toString(parts[0].charAt(0));
        String last_name = Character.toString(parts[1].charAt(0));
        return first_name+last_name;
    }

    // task 3
    public static int differenceEvenOdd(int[] ar) {
        int result = 0;
        for (int i: ar) {
            if (i%2 == 0) {
                result += i;
            } else {result -= i;}
        }
        return Math.abs(result);
    }

    // task 4
    public static boolean equalToAgr(int[] ar) {
        double avr = Arrays.stream(ar).average().orElse(0);
        return Arrays.stream(ar).anyMatch(id -> id == avr);
    }

    // task 5
    public static int[] indexMul(int[] ar) {
        int[] result = IntStream.range(0, ar.length).map(x -> ar[x] * x).toArray();
        return result;
    }

    // task 6
    public static String reverse(String ss) {
        return new StringBuilder(ss).reverse().toString();
    }

    // task 7
    public static int fibonacci(int x) {
        if (x < 0) {
            return -1;
        } else if (x < 3) {
            return 0;
        } else if (x==3) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i=0; i != x-3; i++) {
            int c;
            c = b;
            b = a+b;
            a = c;

        }
        return b;
    }

    // task 8
    public static String pseudoHash(int len) {
        if (len < 0) {
            return "-1";
        }

        String ss = "0123456789abcdef";
        String res = "";

        for (int i=0; i != len; i++) {
            int idx = new Random().nextInt(16);
            res += ss.charAt(idx);
        }
        return res;
    }

    // task 9
    public static String botHelper(String ss) {
        String[] words = ss.split(" ");
        for (String word: words){
            if (word.equals("help")) {
                return "calling for a staff member";
            }
        }
        return "Keep waiting";
    }

    // task 10
    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}
