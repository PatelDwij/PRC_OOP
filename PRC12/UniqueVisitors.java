
import java.util.*;

public class UniqueVisitors {

    public static void main(String[] args) {

        List<String> logins = Arrays.asList(
                "Dwij", "Rahul", "Amit", "Dwij",
                "Neha", "Rahul", "Priya", "Amit"
        );

        // Count unique visitors
        HashSet<String> uniqueUsers =
                new HashSet<>(logins);

        System.out.println(
                "Unique visitor count: " + uniqueUsers.size());

        // Preserve first-seen order
        LinkedHashSet<String> orderedUsers =
                new LinkedHashSet<>(logins);

        System.out.println("First three unique visitors:");

        int count = 0;

        for (String user : orderedUsers) {
            if (count == 3) {
                break;
            }

            System.out.println(user);
            count++;
        }

        System.out.println("25CE077 - Dwij");
    }
}
