public class Driver {
    public static void main(String[] args) {

        Shape[] shapes = {
                new Circle(5),
                new Rectangle(5, 8),
                new Triangle(6, 8)
        };

        double total = 0;
        double largest = 0;

        for (Shape s : shapes) {
            double a = s.area();

            System.out.printf("Area = %.1f%n", a);

            total += a;

            if (a > largest) {
                largest = a;
            }
        }

        System.out.printf("Total = %.1f%n", total);
        System.out.printf("Largest = %.1f%n", largest);

    
    }
}
