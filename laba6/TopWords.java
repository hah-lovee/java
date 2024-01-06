package first_block.laba6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:\\java\\first_block\\laba6\\me.txt";

        File file = new File(filePath);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        HashMap<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("\\p{Punct}+");

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            word = pattern.matcher(word).replaceAll("");
            
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        if (scanner != null) {
            scanner.close(); 
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());

        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (count < 10) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            } else {
                break;
            }
        }
    }
}
