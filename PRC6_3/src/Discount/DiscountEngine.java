package Discount;

import java.util.Scanner;

interface DiscountRule {

    double apply(double price);

}

public class DiscountEngine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. Rs.50 Discount");

        System.out.print("Choose rule: ");
        int choice = sc.nextInt();

        DiscountRule rule;

        if (choice == 1) {
            rule = p -> p * 0.90;
        }
        else if (choice == 2) {
            rule = p -> p * 0.80;
        }
        else {
            rule = p -> p - 50;
        }

        System.out.println("Final Price: " + rule.apply(price));

        sc.close();

    }
}