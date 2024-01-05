package first_block.src;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

public class Task4{

    public static void main(String[] args) {
        // 1
        // System.out.println(nonRepeatable("abracadabra"));
        // System.out.println(nonRepeatable("paparazzi"));

        // 2
        // System.out.println(generateBrackets(2));
        // System.out.println(generateBrackets(3));

        // 3
        // System.out.println(binarySystem(4));

        // 4
        // System.out.println(alphabeticRow("abcdjuwx"));
        // System.out.println(alphabeticRow("klmabzyxw"));

        // 5
        System.out.println(five("aaabbcddeedddm"));
        System.out.println(five("vvvvaajaaaaa"));

        // 6
        // System.out.println(convertToNum("eight"));
        // System.out.println(convertToNum("five hundred sixty seven"));
        // System.out.println(convertToNum("thirty one"));

        // 7 
        // System.out.println(uniqueSubstring("123412324"));
        // System.out.println(uniqueSubstring("111111"));
        // System.out.println(uniqueSubstring("77897898"));
        // System.out.println(uniqueSubstring("12312345"));

        // 8
        // System.out.println(shortestWay(new int[][] {{1,3,1}, {1,5,1}, {4,2,1}} ));

        // 9
        // System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));

        // 10
        // System.out.println(switchNums(519, 723));





    }


    //1
    public static String nonRepeatable(String s) {
        if (s.length() == 1) {
            return s;  
        }
        char[] chars = s.toCharArray();
        char[] without_first = Arrays.copyOfRange(chars, 1, chars.length);
        char first = chars[0];
        String new_s = "";
        for (int i = 0; i != without_first.length; i++) {
            if (without_first[i] == first) {

            } else {
                new_s += without_first[i];
            }
        }
        return first + nonRepeatable(new_s);
    }  
    
    //2
    private static void generBr(int open, int close, String pref, List<String> ans) {
        if (open == close && close == 0) {
            ans.add(pref);
            return;
        }

        if (open > 0) {
            generBr(open - 1, close, pref + "(", ans);
        }
        if (open < close) {
            generBr(open, close - 1, pref + ")", ans);
        }

    }
    public static ArrayList<String> generateBrackets(int n) {
        ArrayList<String> ans = new ArrayList<>();
        generBr(n, n, "", ans);
        return ans;
    }

    //3
    public static ArrayList<String> binarySystem(int n) {
        ArrayList<String> ans = new ArrayList<>();
        hh(n, "0", "", ans);
        hh(n, "1", "", ans);

        return ans;
    }

    private static void hh(int n, String last, String pref, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(pref);
            return;
        }

        if (last == "0") {
            hh(n-1, "1", pref+last, ans);
        }

        if (last == "1" ) {
            if (n-1 == 0){
                hh(n-1, "1", pref+last, ans);           

            } else {
                hh(n-1, "1", pref+last, ans);           
                hh(n-1, "0", pref+last, ans);
            }
        }
    }

    // 4
    public static String alphabeticRow(String s) {
        ArrayList<String> ans = new ArrayList<>();
    
        for (int i = 0; i != s.length(); i++){
            increasing(i, s, "", "", ans);
            decreasing(i, s, "", "", ans);
        }
        
        String res = new String();
        for (int i = 0; i != ans.size(); i++) {
            if (ans.get(i).length() > res.length()) {
                res = ans.get(i);
            }
        }
        return res;
    }

    private static void increasing(int ind_first, String s, String pref, String ans, ArrayList<String> ans_ar) {
        if (ind_first+1 == s.length()) {    
                    if (pref.length()+1 > ans.length()) {
                    ans = pref+s.charAt(ind_first);
                    ans_ar.add(ans);
            }
            return;
        }

        if ((int) s.charAt(ind_first + 1) - (int) s.charAt(ind_first) == 1) {
            increasing(ind_first+1, s, pref+s.charAt(ind_first), ans, ans_ar);
        } else {
                    if (pref.length()+1 > ans.length()) {
                    ans = pref+ s.charAt(ind_first);
                    ans_ar.add(ans);
            }
            return;
        }
    }

    private static void decreasing(int ind_first, String s, String pref, String ans, ArrayList<String> ans_ar) {
            if (ind_first+1 == s.length()) {    
                    if (pref.length()+1 > ans.length()) {
                    ans = pref+s.charAt(ind_first);
                    ans_ar.add(ans);
            }
            return;
        }
        if ((int) s.charAt(ind_first) - (int) s.charAt(ind_first+1) == 1) {
            decreasing(ind_first+1, s, pref+s.charAt(ind_first), ans, ans_ar);
        } else {
                    if (pref.length()+1 > ans.length()) {
                    ans = pref+ s.charAt(ind_first);
                    ans_ar.add(ans);
            }
            return;
        }
    }

    // 5 
    public static StringBuilder five(String str) {
        ArrayList<String> array = new ArrayList<>();
        StringBuilder solution = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            char current = str.charAt(i);
            char next = str.charAt(i + 1);
            if (current == next) {
                counter += 1;
                if (i == str.length() - 2) {
                    array.add(counter + String.valueOf(current));
                
                }
            } else  if (i == str.length() - 2) {
                array.add(1 + String.valueOf(next));
            }else {
                array.add(counter + String.valueOf(current));
                counter = 1;
            }
        }
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {
            StringBuilder temp = new StringBuilder(array.get(i));
            temp.reverse();
            solution.append(temp);
        }
        return solution;
    }

    //6
    private static int convertToNum(String str) {
        int solution = 0;
        String[] array = str.split(" ");
        for (String current : array) {
            switch (current) {
                case("one") -> solution += 1;
                case("two") -> solution += 2;
                case("three") -> solution += 3;
                case("four") -> solution += 4;
                case("five") -> solution += 5;
                case("six") -> solution += 6;
                case("seven") -> solution += 7;
                case("eight") -> solution += 8;
                case("nine") -> solution += 9;
                case("ten") -> solution += 10;
                case("eleven") -> solution += 11;
                case("twelve") -> solution += 12;
                case("thirteen") -> solution += 13;
                case("fourteen") -> solution += 14;
                case("fifteen") -> solution += 15;
                case("sixteen") -> solution += 16;
                case("seventeen") -> solution += 17;
                case("eighteen") -> solution += 18;
                case("nineteen") -> solution += 19;
                case("twenty") -> solution += 20;
                case("thirty") -> solution += 30;
                case("forty") -> solution += 40;
                case("fifty") -> solution += 50;
                case("sixty") -> solution += 60;
                case("seventy") -> solution += 70;
                case("eighty") -> solution += 80;
                case("ninety") -> solution += 90;
                case("hundred") -> solution *= 100;
            }
        }
        return solution;
    }

    // 7
     private static String uniqueSubstring(String str) {
        char[] chars = str.toCharArray();
        String res = "";
        String s = "";

        for (int i = 0; i != chars.length-1; i++) {
            if (s.length() == 0){
                s += chars[i];
            }
            if (!s.contains(String.valueOf(chars[i+1]))) {
                    s += chars[i+1];

            } else if (res.length() < s.length()) {
                    res = s;
                    s = "";
            } else if (res.length() == s.length()) {
                s = "";
                } 
        }
            if (s.length()> res.length()) {
                return s;
            } 
        return res;
    }

    // 8
    private static int shortestWay(int[][] matrix) {
            ArrayList<Integer> solutions = new ArrayList<>();
            shortestWayRecursion(matrix, solutions, 0, 0, 0);
            Collections.sort(solutions);
            return solutions.get(0);
        }
    
    private static void shortestWayRecursion(int[][] matrix, ArrayList<Integer> solutions, int sum, int firstIndex, int secondIndex) {
        if (firstIndex + secondIndex == matrix.length + matrix[0].length - 1 - 1) {
            solutions.add(sum + matrix[matrix.length - 1][matrix[0].length - 1]);
        }
        else {
            if (firstIndex < matrix.length - 1)
                shortestWayRecursion(matrix, solutions, sum + matrix[firstIndex][secondIndex], firstIndex + 1, secondIndex);
            if (secondIndex < matrix[0].length - 1)
                shortestWayRecursion(matrix, solutions, sum + matrix[firstIndex][secondIndex], firstIndex, secondIndex + 1);
        }
    }

    // 9
    public static String numericOrder(String input) {
        String[] words = input.split(" ");
        Map<Integer, String> wordMap = new HashMap<>();

        // Извлекаем числа из слов
        for (String word : words) {
            StringBuilder wordWithoutNumbers = new StringBuilder();
            StringBuilder numbers = new StringBuilder();

            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    numbers.append(c);
                } else {
                    wordWithoutNumbers.append(c);
                }
            }
            
            if (numbers.length() > 0) {
                int position = Integer.parseInt(numbers.toString());
                wordMap.put(position, wordWithoutNumbers.toString());
            }
        }

        // Сортируем слова в соответствии с числами
        List<String> sortedWords = new ArrayList<>();
        for (int i = 1; i <= wordMap.size(); i++) {
            sortedWords.add(wordMap.get(i));
        }

        // Собираем упорядоченные слова в новую строку
        return String.join(" ", sortedWords);
    }

    // 10
    public static int switchNums(int num1, int num2) {
        // Преобразовываем числа в массивы цифр
        int[] digits1 = getDigits(num1);
        int[] digits2 = getDigits(num2);

        // Создаем копию массива digits1 для поиска максимальной неповторяющейся цифры
        int[] availableDigits = Arrays.copyOf(digits1, digits1.length);

        // Проходим по цифрам второго числа
        for (int i = 0; i < digits2.length; i++) {
            int max = -1;
            int maxIndex = -1;

            // Ищем максимальную неповторяющуюся цифру из доступных
            for (int j = 0; j < availableDigits.length; j++) {
                if (availableDigits[j] >= max) {
                    max = availableDigits[j];
                    maxIndex = j;
                }
            }

            // Если нашли подходящую цифру, заменяем текущую цифру во втором числе
            if (max >= digits2[i]) {
                digits2[i] = max;
                availableDigits[maxIndex] = -1; // Помечаем использованную цифру
            }
        }

        // Собираем цифры обратно в число
        int result = 0;
        for (int j : digits2) {
            result = result * 10 + j;
        }

        return result;
    }

 
    public static int[] getDigits(int num) {
        String numStr = String.valueOf(num);
        int[] digits = new int[numStr.length()];

        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }

        return digits;
    }
}
