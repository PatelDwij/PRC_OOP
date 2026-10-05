import java.util.Scanner;

public class CinemaShow {

    private int seatsAvailable;
    private int totalSeats;
    private static int totalBooked = 0;

    
    public CinemaShow(int seats) {
        totalSeats = seats;
        seatsAvailable = seats;
    }

    
    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    
    void cancel(int n) {
        seatsAvailable += n;

        
        if (seatsAvailable > totalSeats) {
            seatsAvailable = totalSeats;
        }
    }


    void getSeatsAvailable() {
        System.out.println("Seats Available: " + seatsAvailable);
    }

    
    static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total seats: ");
        int seats = sc.nextInt();

        CinemaShow movie = new CinemaShow(seats);

        System.out.println("\nCinema Show: " + seats);

        
        System.out.print("Enter seats to book: ");
        int n = sc.nextInt();

        System.out.println("Book " + n + ": " + movie.book(n));
        movie.getSeatsAvailable();


        System.out.print("Enter seats to book: ");
        n = sc.nextInt();

        System.out.println("Book " + n + ": " + movie.book(n));
        movie.getSeatsAvailable();

        
        System.out.print("Enter seats to book: ");
        n = sc.nextInt();

        System.out.println("Book " + n + ": " + movie.book(n));
        movie.getSeatsAvailable();

        
        System.out.print("Enter seats to cancel: ");
        n = sc.nextInt();

        movie.cancel(n);
        System.out.println("Cancel " + n);
        movie.getSeatsAvailable();

        
        System.out.print("Enter seats to book: ");
        n = sc.nextInt();

        System.out.println("Book " + n + ": " + movie.book(n));
        movie.getSeatsAvailable();

        
        System.out.print("Enter seats to cancel: ");
        n = sc.nextInt();

        movie.cancel(n);
        System.out.println("Cancel " + n);
        movie.getSeatsAvailable();

        System.out.println("Total Booked: " + CinemaShow.getTotalBooked());

        

        sc.close();
    }
}