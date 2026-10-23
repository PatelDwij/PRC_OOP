
public class CounterRace {

    static int counter = 0;
    static final int THREADS = 5;
    static final int INCREMENTS = 100000;

    static class UnsafeTask extends Thread {
        public void run() {
            for (int i = 0; i < INCREMENTS; i++) {
                counter++;
            }
        }
    }

    static class SafeTask extends Thread {
        public void run() {
            for (int i = 0; i < INCREMENTS; i++) {
                increment();
            }
        }
    }

    static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args)
            throws InterruptedException {

        Thread[] threads = new Thread[THREADS];

        // Without synchronization
        counter = 0;

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new UnsafeTask();
            threads[i].start();
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].join();
        }

        System.out.println("Without synchronization: " + counter);
        System.out.println("Expected result: "
                + (THREADS * INCREMENTS));

        // With synchronization
        counter = 0;

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new SafeTask();
            threads[i].start();
        }

        for (int i = 0; i < THREADS; i++) {
            threads[i].join();
        }

        System.out.println("With synchronization: " + counter);
        System.out.println("25CE077 - Dwij");
    }
}
