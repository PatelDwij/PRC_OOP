import java.util.Objects;

public class point {

    private int x;
    private int y;

    // Constructor
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Convert point to string
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Compare two points
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof point)) {
            return false;
        }

        point p = (point) obj;

        return this.x == p.x && this.y == p.y;
    }

    // Generate hash code
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}


// Main class
class Main {

    public static void main(String[] args) {

        point[] points = {
            new point(1, 2),
            new point(3, 4),
            new point(1, 2),
            new point(5, 6),
            new point(3, 4)
        };

        int distinct = 0;

        for (int i = 0; i < points.length; i++) {

            boolean alreadyExists = false;

            for (int j = 0; j < i; j++) {

                if (points[i].equals(points[j])) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                distinct++;
            }
        }

        System.out.println("Distinct: " + distinct);
        
    }
}