
import java.util.*;

class SharedBuffer {

    private Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;

    synchronized void produce(int value)
            throws InterruptedException {

        while (buffer.size() == capacity) {
            wait();
        }

        buffer.add(value);
        System.out.println("Produced: " + value);

        notifyAll();
    }

    synchronized int consume()
            throws InterruptedException {

        while (buffer.isEmpty()) {
            wait();
        }

        int value = buffer.remove();
        System.out.println("Consumed: " + value);

        notifyAll();

        return value;
    }
}

public class ProducerConsumer {

    public static void main(String[] args)
            throws InterruptedException {

        SharedBuffer buffer = new SharedBuffer();
        int items = 10;

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= items; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= items; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("All items processed.");
        System.out.println("25CE077 - Dwij");
    }
}
