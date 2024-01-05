package first_block.src;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        // 1 task
        // System.out.println(sameLetterPattern("ABAB", "CDCD"));
        // System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        // System.out.println(sameLetterPattern("FFGG", "CDCD"));
        // System.out.println(sameLetterPattern("FFFF", "ABCD"));


        // 2
        // System.out.println(spiderVsFly("H3", "E2"));
        // System.out.println(spiderVsFly("H3", "C1"));      
        // System.out.println(spiderVsFly("A4", "A4"));        
        // System.out.println(spiderVsFly("A4", "A2"));
        // System.out.println(spiderVsFly("A2", "A4"));
        // System.out.println(spiderVsFly("E4", "A3"));
        

        // System.out.println(spiderVsFly("D4", "F3"));
        // System.out.println(spiderVsFly("D4", "F2"));
        // System.out.println(spiderVsFly("D4", "B3"));

        // System.out.println(spiderVsFly("D2", "F3"));
        // System.out.println(spiderVsFly("D2", "F2"));
        // System.out.println(spiderVsFly("D2", "B3"));


        // System.out.println(spiderVsFly("B4", "H3"));
        // System.out.println(spiderVsFly("A4", "H3"));
        // System.out.println(spiderVsFly("A4", "G3"));
        // System.out.println(spiderVsFly("H4", "A3"));
        

        // System.out.println(spiderVsFly("A0", "H0"));
        // System.out.println(spiderVsFly("B1", "H3"));
        // System.out.println(spiderVsFly("A2", "H4"));
        // System.out.println(spiderVsFly("A2", "G4"));
        // System.out.println(spiderVsFly("H2", "A4"));
        
        // 3
        // System.out.println(digitsCount(4666));
        // System.out.println(digitsCount(1289390387328L));

        // 4
        // System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        // System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        // System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        // 5
        // System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 4, 5}).toArray()));
        // System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 7, 9}).toArray()));
        // System.out.println(Arrays.deepToString(sumsUp(new int[]{10, 9, 7, 2, 8}).toArray()));
        // System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}).toArray()));


        // 6 
        // System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        // System.out.println(takeDownAverage(new String[]{"10%"}));
        // System.out.println(takeDownAverage(new String[]{"53%", "79%"}));

        // 7
        // System.out.println(caesarCipher("encode", "hello world", 3));
        // System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        // System.out.println(caesarCipher("encode", "almost last task!", 4));
        // System.out.println(caesarCipher("decode", "zazfzz", 3));

        // 8
        // System.out.println(setSetup(5, 3));
        // System.out.println(setSetup(7, 3));

        // 9
        // System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        // System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        // System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        // 10
        // System.out.println(isNew(3));
        // System.out.println(isNew(30));
        // System.out.println(isNew(321));
        // System.out.println(isNew(123));
        // System.out.println(isNew(201));

    }


    // 1 task
    public static boolean sameLetterPattern(String str1, String str2)
    {
        if (str1.length() != str2.length()){
            return false;
        }

        for (int i = 0; i < str1.length(); i++){
            if (Character.isLetter(str1.charAt(i)) &&
                    Character.isLetter(str2.charAt(i))) {
                str1 = str1.replaceAll(String.valueOf(str1.charAt(i)),
                        Integer.toString(i));
                str2 = str2.replaceAll(String.valueOf(str2.charAt(i)),
                        Integer.toString(i));
            }
        }

        return str1.equals(str2);

    }

    // 2 task
    public static StringBuilder spiderVsFly(String str1, String str2){

        char spiR = str1.charAt(0);
        int spiC = Character.digit(str1.charAt(1), 10);
        char flyR = str2.charAt(0);
        int flyC =  Character.digit(str2.charAt(1), 10);

        // System.out.println(spiR - flyR);
        HashMap<Integer, Character> Radials = new HashMap<>();
        Radials.put((int) 'A' % 8, 'A'); // 65
        Radials.put((int) 'B' % 8, 'B');
        Radials.put((int) 'C' % 8, 'C');
        Radials.put((int) 'D' % 8, 'D');
        Radials.put((int) 'E' % 8, 'E');
        Radials.put((int) 'F' % 8, 'F');
        Radials.put((int) 'G' % 8, 'G');
        Radials.put((int) 'H' % 8, 'H'); // 72

        int flag = 0;

        StringBuilder solution = new StringBuilder();
        solution.append(str1);
        solution.append('-');

        if (spiR == flyR) {
            if (spiC == flyC) {
                solution.append(str2);
            } else {
                for (int i = spiC + Integer.signum(flyC- spiC); i != flyC; i = i + Integer.signum(flyC- spiC) ) {
                    solution.append(spiR);
                    solution.append(i);
                    solution.append('-');
                }
                solution.append(str2);
            }
        }

        if (Math.abs(spiR - flyR) > 2 & Math.abs(spiR - flyR) < 6) {
            for (int i = spiC+ Integer.signum(flyC- spiC); i != 0; i = i + Integer.signum(flyC- spiC)) {
                solution.append(spiR);
                solution.append(i);
                solution.append('-');
            }
            solution.append("A0-");

            for (int i = 1; i != flyC; i++) {
                solution.append(flyR);
                solution.append(i);
                solution.append('-');
            }
        solution.append(str2);
        } 

        // по радианам
        if (Math.abs(spiR - flyR) <= 2 & Math.abs(spiR - flyR) != 0 ) {
            // Radials
            if (spiC > flyC) {
                for (int i = spiC-1; i + 1 != flyC; i--) {
                    solution.append(spiR);
                    solution.append(i);
                    solution.append('-');
                }

                for (int i = (int) spiR + Integer.signum(flyR-spiR); i != (int) flyR; i = i + (Integer.signum(flyR - spiR))) {
                    solution.append(Radials.get(i));
                    solution.append(flyC);
                    solution.append('-');
                }

                solution.append(str2);

            } else {
                for (int i = (int) spiR + Integer.signum(flyR-spiR); i != (int) flyR; i = i + (Integer.signum(flyR - spiR))) {
                    solution.append(Radials.get(i));
                    solution.append(spiC);
                    solution.append('-');
                }

                for (int i = spiC; i-1 != flyC; i++) {
                    solution.append(flyR);
                    solution.append(i);
                    solution.append('-');
                }
                solution.deleteCharAt(solution.length() -1);
            }
        }

        if (Math.abs(spiR - flyR) >= 6) {

            // System.out.println(Radials.get(((int) spiR - 1) %8 ));
            
             if (spiC > flyC) {
                for (int i = spiC-1; i + 1 != flyC; i--) {
                    solution.append(spiR);
                    solution.append(i);
                    solution.append('-');
                }

                for (int i = ((int) spiR + Integer.signum(spiR - flyR) ) % 8; i != ((int) flyR) % 8; i = (i + Integer.signum(spiR - flyR)) % 8)   {
                    if (i == -1) {
                        break;
                    }
                    else {
                        solution.append(Radials.get(i));
                        solution.append(flyC);
                        solution.append('-');
                    }
                }

                solution.append(str2);

            }
            else {
                // System.out.println(((int) spiR + Integer.signum(spiR - flyR) ) % 8);
                for (int i = ((int) spiR + Integer.signum(spiR - flyR) ) % 8; i != ((int) flyR) % 8; i = (i + Integer.signum(spiR - flyR)) % 8) {
                    if (i == -1) {
                        solution.append(flyR);
                        solution.append(spiC);
                        solution.append('-');
                        flag = 1;
                        break;
                    } else {
                        solution.append(Radials.get(i));
                        solution.append(spiC);
                        solution.append('-');
                        flag = 0;
                    }
                }

                for (int i = spiC+flag; i-1 != flyC; i++) {
                    solution.append(flyR);
                    solution.append(i);
                    solution.append('-');
                }
                solution.deleteCharAt(solution.length() -1);
            }
        }
    
        return solution;
    }

    // 3
    public static int digitsCount(long i){
        return i/10 != 0 ? 1 + digitsCount(i/10) : 1;
    }

    // 4
    public static int totalPoints(String[] arr, String word){
        HashMap<Character, Integer> wordMap = toMap(word);

        int points = 0;

        for (String str : arr){
            HashMap<Character, Integer> map = toMap(str);
            boolean allGood = true;
            for (char c : map.keySet()){
                if (wordMap.containsKey(c) && wordMap.get(c) >= map.get(c)){
                    continue;
                }
                allGood = false;
                break;
            }

            if (allGood){
                points += Math.max(str.length() - 2, 0);
                if (str.length() == 6){
                    points += 50;
                }
            }
        }

        return points;
    }

    public static HashMap<Character, Integer> toMap(String word){
        HashMap<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++){
            wordMap.putIfAbsent(word.charAt(i), 0);
            wordMap.put(word.charAt(i), wordMap.get(word.charAt(i)) + 1);
        }
        return wordMap;
    }

    // 5
    public static ArrayList<int[]> sumsUp(int[] ar) {
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 1; i < ar.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[i] + ar[j] == 8) {
                    int[] temp = {ar[i], ar[j]};
                    Arrays.sort(temp);
                    result.add(temp);

                }
            }
        }
        return result;
    }

    // 6 
    public static String takeDownAverage(String[] ar){
        int curAvr = 0;

        for (String s : ar){
            curAvr += Integer.parseInt(s.replace("%" ,""));
        }

        return curAvr/ar.length - (5*(ar.length + 1)) + "%";
    }
        
    // 7
    public static String caesarCipher(String mode, String message, int step) {
            if (mode.equals("decode")){
                step = -step;
            }
    
            message = message.toUpperCase();
            StringBuilder builder = new StringBuilder();
    
            for (char i : message.toCharArray()){
                char t = i;
                if (i <= 'Z' && i >= 'A'){
                    t = encode(i, step);
                }
                builder.append(t);
            }
    
            return builder.toString();
        }
    
        public static char encode(char i, int shift){
            i = Character.toUpperCase(i);
            int prim = i+shift;
            if (prim > 'Z'){
                prim = prim - 'Z' + 'A' - 1;
            }
            if (prim < 'A'){
                prim = prim - 'A' + 'Z' + 1;
            }
            return (char) prim;
        }

    // 8
    public static int setSetup(int n, int k){
        if (n == 1){
            return 1;
        }

        double res =  ((double) n /(n-k)) * setSetup(n-1, (n-k) < 2 ? n - 2 : k);
        return (int) res;
    }

    // 9 
    public static String timeDifference(String city, String timeStr, String city2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        ZonedDateTime time = ZonedDateTime.parse(timeStr, formatter.withZone(getZoneID(city)));
    
        return time.withZoneSameInstant(getZoneID(city2))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static ZoneId getZoneID(String str){

        HashMap<String, String> map = new HashMap<>();
        map.put("Los Angeles", "America/Los_Angeles");
        map.put("New York", "America/New_York");
        map.put("Caracas", "America/Caracas");
        map.put("Buenos Aires", "America/Argentina/Buenos_Aires");
        map.put("London", "Europe/London");
        map.put("New Delhi", "Asia/Calcutta");
        map.put("Rome", "Europe/Rome");
        map.put("Moscow", "Europe/Moscow");
        map.put("Tehran", "Asia/Tehran");
        map.put("Beijing", "Asia/Shanghai");
        map.put("Canberra", "Australia/Canberra");

        return ZoneId.of(str, map);
    }

    // 10
    public static boolean isNew(int num){
        char[] arr = String.valueOf(num).toCharArray();

        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] - '0' == 0 && builder.length() == 0){
                for (; i < arr.length; i++){
                    if (arr[i] - '0' == 0){
                        builder.append(arr[i]);
                        continue;
                    }
                    break;
                }
                if (i < arr.length){
                    builder.insert(0, arr[i]);
                }
            }
            else {
                builder.append(arr[i]);
            }
        }
        return builder.toString().equals(String.valueOf(num));
    }
}
