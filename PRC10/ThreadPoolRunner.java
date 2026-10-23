
import java.util.concurrent.*;

public class ThreadPoolRunner {

    public static void main(String[] args)
            throws InterruptedException {

        ExecutorService pool =
                Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            final int id = i;

            Runnable task = () -> {
                System.out.println(
                        "Task " + id + " executed by "
                        + Thread.currentThread().getName());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            };

            pool.submit(task);
        }

        pool.shutdown();

        if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
            pool.shutdownNow();
        }

        System.out.println("All tasks completed.");
        System.out.println("25CE077 - Dwij");
    }
}
