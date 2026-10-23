
public class DeadlockDemo {

    static final Object lockA = new Object();
    static final Object lockB = new Object();

    static void unsafeTask1() {
        synchronized (lockA) {
            System.out.println("Thread 1 locked A");

            synchronized (lockB) {
                System.out.println("Thread 1 locked B");
            }
        }
    }

    static void unsafeTask2() {
        synchronized (lockB) {
            System.out.println("Thread 2 locked B");

            synchronized (lockA) {
                System.out.println("Thread 2 locked A");
            }
        }
    }

    static void safeTask(String name) {
        synchronized (lockA) {
            System.out.println(name + " locked A");

            synchronized (lockB) {
                System.out.println(name + " locked B");
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("Demonstrating deadlock:");

        Thread t1 = new Thread(() -> {
            unsafeTask1();
        });

        Thread t2 = new Thread(() -> {
            unsafeTask2();
        });

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        t1.join(500);

        if (t1.isAlive() && t2.isAlive()) {
            System.out.println(
                    "Possible deadlock detected (timeout).");
        } else {
            System.out.println(
                    "Deadlock was not confirmed in this run.");
        }

        System.out.println();
        System.out.println("Using consistent lock order:");

        Thread t3 = new Thread(() -> safeTask("Thread 3"));
        Thread t4 = new Thread(() -> safeTask("Thread 4"));

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Safe tasks completed.");
        System.out.println("25CE077 - Dwij");
    }
}
