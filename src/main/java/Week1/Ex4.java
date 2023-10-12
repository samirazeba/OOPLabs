package Week1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        int num1, num2;
        Scanner scan = new Scanner(System.in);

        System.out.print("Type a number: ");
        num1 = scan.nextInt();
        System.out.print("Type another number: ");
        num2 = scan.nextInt();

        int sum = num1 + num2;

        System.out.println("Sum of the numbers is: " + sum);
    }
}
