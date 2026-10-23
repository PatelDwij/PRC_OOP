
import java.util.*;

public class Leaderboard {

    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Rahul", 90);
        scores.put("Dwij", 98);
        scores.put("Amit", 90);
        scores.put("Neha", 95);
        scores.put("Priya", 85);

        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        // Sort by score descending, then name ascending
        players.sort(
                Comparator.comparing(
                        (Map.Entry<String, Integer> e) -> e.getValue())
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
        );

        int topN = 3;

        System.out.println("Top " + topN + " Players:");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                    player.getKey() + " - " + player.getValue());
        }

        System.out.println("25CE077 - Dwij");
    }
}
