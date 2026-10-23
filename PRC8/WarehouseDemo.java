
import java.util.*;

class OutOfStockException extends Exception {
    private int shortfall;

    OutOfStockException(String item, int shortfall) {
        super("Not enough stock for " + item);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    private Map<String, Integer> stock = new HashMap<>();

    Warehouse() {
        stock.put("Pen", 10);
        stock.put("Book", 5);
        stock.put("Pencil", 8);
    }

    public void issue(String item, int qty)
            throws OutOfStockException,
                   InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero.");
        }

        int available = stock.getOrDefault(item, 0);

        if (available < qty) {
            throw new OutOfStockException(
                    item, qty - available);
        }

        stock.put(item, available - qty);

        System.out.println(
                "Issued " + qty + " " + item
                + "(s) successfully.");
    }
}

public class WarehouseDemo {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        String[] items = {
            "Pen", "Book", "Pencil", "Pen", "Book"
        };

        int[] quantities = {3, 8, 0, 4, -2};

        for (int i = 0; i < items.length; i++) {
            System.out.println(
                    "Request: " + items[i]
                    + ", Quantity: " + quantities[i]);

            try {
                warehouse.issue(items[i], quantities[i]);

            } catch (OutOfStockException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println(
                        "Shortfall: " + e.getShortfall());

            } catch (InvalidQuantityException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        System.out.println("All requests processed.");
        System.out.println("25CE077 - Dwij");
    }
}
