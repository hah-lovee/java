import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
 
    
    public static void main(String[] args) {
        //1
        // System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        // System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        // System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        // System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        // System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        // System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        // 2 
        // System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        // System.out.println(Arrays.toString(collect("strengths", 3)));
        // System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));

        // 3
        // System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        // System.out.println(nicoCipher("andiloveherso", "tesha"));
        // System.out.println(nicoCipher("mubashirhassan", "crazy"));
        // System.out.println(nicoCipher("edabitisamazing", "matt"));
        // System.out.println(nicoCipher("iloveher", "612345"));

        // 4
        // System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        // System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        // System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        // System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        // System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));

        // 5
        // System.out.println(Arrays.toString(isExact(6)));
        // System.out.println(Arrays.toString(isExact(24)));
        // System.out.println(Arrays.toString(isExact(125)));
        // System.out.println(Arrays.toString(isExact(720)));
        // System.out.println(Arrays.toString(isExact(1024)));
        // System.out.println(Arrays.toString(isExact(40320)));

        // 6
        // System.out.println(fractions("0.(6)"));
        // System.out.println(fractions("1.(1)"));
        // System.out.println(fractions("3.(142857)"));
        // System.out.println(fractions("0.19(2367)"));
        // System.out.println(fractions("0.1097(3)"));

        // 7
        // System.out.println(pilish_string("33314444"));
        // System.out.println(pilish_string("TOP"));
        // System.out.println(pilish_string("X"));

        // 8
        // System.out.println(generateNonconsecutive("3 + 5 * ( 2 - 6 )"));
        // System.out.println(generateNonconsecutive("6 - 18 / ( -1 + 4 )"));

        // 9
        // System.out.println(isValid("aabbcd"));
        // System.out.println(isValid("aabbccddeefghi"));
        // System.out.println(isValid("abcdefghhgfedecba"));

        // 10
        System.out.println(findLCS("abcd", "bd"));
        // System.out.println(findLCS("aggtab", "gxtxamb"));

    }

    // 1
    public static String hiddenAnagram(String message, String key) {
        message = message.toLowerCase().replaceAll("[ \\p{Punct}0-9]", "");
        key = key.toLowerCase().replaceAll("[ \\p{Punct}0-9]", "");

        int correctness = 0;
        HashMap<Character, int[]> map = new HashMap<>();

        // заполняю map частотой встречания каждого символа
        for (char c : key.toCharArray()) {
            map.putIfAbsent(c, new int[]{0, 0});
            map.get(c)[0]++;
        }

        for (int i = 0; i < key.length(); i++) {
            if (map.containsKey(message.charAt(i))) {
                int[] arr = map.get(message.charAt(i));
                correctness += arr[0] == arr[1] ? -1 : 0;
                arr[1]++;
                correctness += arr[0] == arr[1] ? 1 : 0;
            }
        }

        if (correctness == map.size()) {
            return message.substring(0, key.length());
        }

        for (int i = key.length(); i < message.length(); i++) {
            if (map.containsKey(message.charAt(i - key.length()))) {
                // убераем элементы предыдущего цикла
                int[] arr = map.get(message.charAt(i - key.length()));
                correctness += arr[0] == arr[1] ? -1 : 0;
                arr[1]--;
                correctness += arr[0] == arr[1] ? 1 : 0;
            }
            // добавляем новые
            if (map.containsKey(message.charAt(i))) {
                int[] arr = map.get(message.charAt(i));
                correctness += arr[0] == arr[1] ? -1 : 0;
                arr[1]++;
                correctness += arr[0] == arr[1] ? 1 : 0;
            }
            if (correctness == map.size()) {
                return message.substring(i - key.length() + 1, i + 1);
            }
        }
        return "notfound";
    }

    // 2
    public static String[] collect(String str, int count) {
        String[] arr = new String[str.length() / count];
        collectAll(str, count, arr, 0);
        Arrays.sort(arr);
        return arr;
    }

    public static void collectAll(String str, int count, String[] arr, int curIdx) {
        arr[curIdx] = str.substring(curIdx * count, (curIdx + 1) * count);
        if (curIdx == arr.length - 1) {
            return;
        }

        collectAll(str, count, arr, curIdx + 1);
    }

    // 3
    public static String nicoCipher(String message, String key) {
        int[] order = new int[key.length()];

        HashMap<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < key.length(); i++) {
            map.put(key.charAt(i), i);
        }


        Character[] keyArr = map.keySet().toArray(new Character[0]);
        Arrays.sort(keyArr);

        for (int i = 0; i < keyArr.length; i++) {
            order[i] = map.get(keyArr[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int line = 0; line < Math.ceil((double) message.length() / key.length()); line++) {
            for (int column : order) {
                int idx = line * key.length() + column;
                if (idx >= message.length()) {
                    result.append(" ");
                    continue;
                }
                result.append(message.charAt(line * key.length() + column));
            }
        }

        return result.toString();
    }

    // 4
    public static int[] twoProduct(int[] arr, int product) {
        int[] result = new int[0];

        int gap = arr.length;
        // ([1, 2, 3, 9, 4, 5, 15], 45) ➞ [9, 5]
        for (int i = 0; i < arr.length; i++) {
            if (product % arr[i] != 0) {
                continue;
            }
            for (int j = i - 1; j > -1; j--) {
                if (arr[i] * arr[j] == product && gap > i - j) {
                    result = new int[]{arr[j], arr[i]};
                    gap = i - j;
                }
            }
        }

        return result;
    }

    // 5
    public static int[] isExact(int num) {
        return isExact2(num, 2, 1);
    }

    public static int[] isExact2(int num, int factor, int cur) {
        cur *= factor;
        if (num == cur) {
            return new int[]{num, factor};
        }
        if (num < cur) {
            return new int[0];
        }

        return isExact2(num, factor + 1, cur);
    }

    // 6
    public static String fractions(String str) {
        Pattern pattern = Pattern.compile("(\\d+).(\\d*)\\((\\d+)\\)");
        Matcher matcher = pattern.matcher(str);

        if (!matcher.find()) return null;
        // целая
        int ceil = Integer.parseInt(matcher.group(1));
        // десятичная
        int fract = Integer.parseInt(matcher.group(2).isEmpty() ?
                "0" : matcher.group(2));
        // период
        int top = Integer.parseInt(matcher.group(3));


        int bottom = (int) ((Math.pow(10, matcher.group(3).length()) - 1) *
                Math.pow(10, matcher.group(2).length()));

        top += ceil * bottom;
        top = (int) (top * Math.pow(10, matcher.group(2).length()) +
                fract * bottom);

        bottom *= (int) Math.pow(10, matcher.group(2).length());

        int g = gcd(top, bottom);
        while (g != 1) {
            bottom /= g;
            top /= g;
            g = gcd(top, bottom);
        }

        return top + "/" + bottom;
    }
    // наибольший общий делитель
    public static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    // 7
    public static String pilish_string(String str) {
        char[] arr = "314159265358979".toCharArray();
        int curIdx = 0;

        StringBuilder builder = new StringBuilder();

        for (char i : arr) {

            int c = i - 48;
            if (curIdx >= str.length()) {
                break;
            }
            if (curIdx + c >= str.length()) {
                builder.append(str.substring(curIdx))
                        .append(String.valueOf(str.charAt(str.length() - 1))
                                .repeat(c - str.length() + curIdx));
            } else {
                builder.append(str, curIdx, curIdx + c);
            }
            builder.append(' ');
            curIdx += c;
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    // 8
    public static double generateNonconsecutive(String s) {
        try {
            String[] tokens = s.split(" ");
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operations = new Stack<>();

            for (String token : tokens) {
                if (token.matches("-?\\d+(\\.\\d+)?")) {
                    numbers.push(Double.parseDouble(token));

                } else if (token.equals("(")) {
                    operations.push(token.charAt(0));

                } else if (token.equals(")")) {
                    while (operations.peek() != '(') {
                        numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
                    }
                    operations.pop();

                } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    while (!operations.isEmpty() && hasPrecedence(token.charAt(0), operations.peek())) {
                        numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
                    }
                    operations.push(token.charAt(0));
                }
            }

            while(!operations.isEmpty()) {
                numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
            }

            return numbers.pop();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }

    public static double applyOperation(char operation, double b, double a) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                return a / b;
        }
        return 0;
    }

    // 9
    public static String isValid(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()){
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        int bs = 0;
        int norm = -1;

        for (int i : map.values()){
            if (norm == -1){
                norm = i;
                continue;
            }
            if (Math.abs(i - norm) > 1){
                return "NO";
            }
            if (i != norm){
                bs++;
                if (bs > 1){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    // 10
    public static String findLCS(String str1, String str2){
        int[][] arr = getLCS(str1, str2);
        return traceback(arr, str1, str2);
    }

    public static int[][] getLCS(String str1, String str2)
    {
        int[][] arr = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        return arr;
    }

    public static String traceback(int[][] arr, String str1, String str2){
        StringBuilder builder = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                builder.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (arr[i - 1][j] > arr[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return builder.toString();
    }

}
