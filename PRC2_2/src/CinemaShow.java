public class CinemaShow {

    private String Title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;


    CinemaShow(String Title, int capacity) {
        this.Title = Title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }


    CinemaShow(String Title) {
        this(Title, 100);
    }


    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }


    void Cancel(int n) {
        seatsAvailable += n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }


    int getSeatsAvailable() {
        return seatsAvailable;
    }


    static int getTotalBooked() {
        return totalBooked;
    }


    public static void main(String[] args) {

    }
}