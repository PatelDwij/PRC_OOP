
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class GenericDemo {

    // Generic method to return the first array element
    public static <T> T firstElement(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        return array[0];
    }

    public static void main(String[] args) {

        // Box with String
        Box<String> nameBox = new Box<>();
        nameBox.set("Dwij");
        System.out.println("Box String: " + nameBox.get());

        // Box with Integer
        Box<Integer> numberBox = new Box<>();
        numberBox.set(100);
        System.out.println("Box Integer: " + numberBox.get());

        // Pair with different types
        Pair<String, Integer> student = new Pair<>("Dwij", 25);
        System.out.println("Pair Name: " + student.getFirst());
        System.out.println("Pair Number: " + student.getSecond());

        // Generic method with String array
        String[] names = {"Dwij", "Patel", "CHARUSAT"};
        System.out.println("First Name: " + firstElement(names));

        // Generic method with Integer array
        Integer[] numbers = {10, 20, 30};
        System.out.println("First Number: " + firstElement(numbers));

        System.out.println("25CE077 - Dwij");
    }
}
