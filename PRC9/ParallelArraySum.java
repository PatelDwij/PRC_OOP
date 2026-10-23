
public class ParallelArraySum {

    static int[] numbers = new int[500000];
    static long total = 0;

    static synchronized void addSafe(long value) {
        total += value;
    }

    static void runThreads(int mode)
            throws InterruptedException {

        int threadCount = 4;
        Thread[] threads = new Thread[threadCount];
        long[] partial = new long[threadCount];

        total = 0;

        long startTime = System.nanoTime();

        for (int t = 0; t < threadCount; t++) {
            final int id = t;

            threads[t] = new Thread(() -> {
                int start = id * numbers.length / threadCount;
                int end = (id + 1) * numbers.length / threadCount;

                if (mode == 2) {
                    // Thread-local sum
                    long sum = 0;

                    for (int i = start; i < end; i++) {
                        sum += numbers[i];
                    }

                    partial[id] = sum;

                } else {
                    for (int i = start; i < end; i++) {
                        if (mode == 0) {
                            // Unsafe shared total
                            total += numbers[i];
                        } else {
                            // Synchronized shared total
                            addSafe(numbers[i]);
                        }
                    }
                }
            });

            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        if (mode == 2) {
            for (long sum : partial) {
                total += sum;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Total: " + total);
        System.out.println("Time: "
                + (endTime - startTime) / 1_000_000.0
                + " ms");
    }

    public static void main(String[] args)
            throws InterruptedException {

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 1;
        }

        System.out.println("Expected total: " + numbers.length);

        System.out.println("\n1. Without synchronization:");
        runThreads(0);

        System.out.println("\n2. With synchronized method:");
        runThreads(1);

        System.out.println("\n3. With thread-local sums:");
        runThreads(2);

        System.out.println("\n25CE077 - Dwij");
    }
}
