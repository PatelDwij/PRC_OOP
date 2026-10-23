
import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {

        String paragraph =
                "java is easy java is powerful java is popular";

        String[] words = paragraph.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        // Count word frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Sort by frequency, highest first
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort(
                Comparator.comparing(
                        (Map.Entry<String, Integer> e) -> e.getValue())
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
        );

        System.out.println("Word Frequency:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                    entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("25CE077 - Dwij");
    }
}
