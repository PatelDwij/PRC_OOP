import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int totalToll = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Enter vehicle number:");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter vehicle type (bike/car/truck):");
            String type = sc.next().toLowerCase();

            // Creating object of Vehicle record
            TollBoth.Vehicle v = new TollBoth.Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };

            totalToll += toll;

            switch (v.type()) {
                case "bike":
                    bike++;
                    break;
                case "car":
                    car++;
                    break;
                case "truck":
                    truck++;
                    break;
            }
        }

        String mostFrequent;

        if (bike >= car && bike >= truck) {
            mostFrequent = "bike";
        } else if (car >= bike && car >= truck) {
            mostFrequent = "car";
        } else {
            mostFrequent = "truck";
        }

        System.out.println("Total Toll = " + totalToll);
        System.out.println("Most Frequent Vehicle = " + mostFrequent);

        sc.close();
    }
}