abstract class Media {

    protected String title;
    protected int lateDays;

    Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    abstract double lateFee();
}


class Book extends Media {

    Book(String title, int lateDays) {
        super(title, lateDays);
    }

    double lateFee() {
        return lateDays * 2;
    }
}


class DVD extends Media {

    DVD(String title, int lateDays) {
        super(title, lateDays);
    }

    double lateFee() {
        return lateDays * 5;
    }
}


class Magazine extends Media {

    Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    double lateFee() {
        return lateDays * 3;
    }
}


public class Driver {

    public static void main(String[] args) {

        Media[] items = {
            new Book("Java Basics", 4),
            new DVD("Avengers", 3),
            new Magazine("Tech Today", 5)
        };

        double total = 0;

        for (Media m : items) {

            double fee = m.lateFee();

            System.out.println(m.title + ": " + fee);

            total += fee;
        }

        System.out.println("Total Late Fee: " + total);

        
    }
}