
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class SeatBookingRace {

    static class Booking {
        int seatsLeft = 5;
        AtomicInteger successful = new AtomicInteger(0);
        boolean safe;

        Booking(boolean safe) {
            this.safe = safe;
        }

        void book() {
            if (safe) {
                bookSafe();
            } else {
                bookUnsafe();
            }
        }

        void bookUnsafe() {
            if (seatsLeft > 0) {
                try {
                    // Increase the chance of a race
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                seatsLeft--;
                successful.incrementAndGet();
                System.out.println("Seat booked!");
            } else {
                System.out.println("Booking failed!");
            }
        }

        synchronized void bookSafe() {
            if (seatsLeft > 0) {
                seatsLeft--;
                successful.incrementAndGet();
                System.out.println("Seat booked!");
            } else {
                System.out.println("Booking failed!");
            }
        }
    }

    static void runBooking(boolean safe)
            throws InterruptedException {

        Booking booking = new Booking(safe);
        Thread[] threads = new Thread[10];
        CountDownLatch start = new CountDownLatch(1);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    start.await();
                    booking.book();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads[i].start();
        }

        start.countDown();

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Successful bookings: "
                + booking.successful.get());
        System.out.println("Seats left: " + booking.seatsLeft);
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("Without synchronization:");
        runBooking(false);

        System.out.println();

        System.out.println("With synchronization:");
        runBooking(true);

        System.out.println();
        System.out.println("25CE077 - Dwij");
    }
}
