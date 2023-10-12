package Week1;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {

        int num1, num2;
        Scanner scan = new Scanner(System.in);

        System.out.print("Type the first number: ");
        num1 = scan.nextInt();

        System.out.print("Type the second number: ");
        num2 = scan.nextInt();

        if (num1 > num2) {
            System.out.println("Greater number: " + num1);
        } else if (num2 > num1) {
            System.out.println("Greater number: " + num2);
        } else {
            System.out.println("\nThe numbers are equal!");
        }
    }
}
