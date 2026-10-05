abstract class Shape
{
    abstract double area();
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    double area() {
        return 3.14 * r * r;
    }
}

class Rectangle extends Shape {
    double l, w;

    Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    double area()
     {
        return l * w;
    }
}

class Triangle extends Shape {
    double b, h;

    Triangle(double b, double h)
    {
        this.b = b;
        this.h = h;
    }

    double area()
    {
        return 0.5 * b * h;
    }
}

class Main {
    public static void main(String[] args)
    {

        Shape[] shapes =
        {
            new Circle(5),
            new Rectangle(10, 4),
            new Triangle(6, 8)
        };

        double total = 0;
        double largest = 0;

        for (Shape s : shapes)
         {
            double a = s.area();

            System.out.println("Area = " + a);

            total += a;

            if (a > largest)
                largest = a;
        }

        System.out.println("Total = " + total);
        System.out.println("Largest = " + largest);
         System.out.println("25CE071 - ANSH PATEL");


    }
}