package Week1;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        int number;
        Scanner scan = new Scanner(System.in);

        System.out.print("Type a number: ");
        number = scan.nextInt();

        if (number > 0) {
            System.out.println("The number is positive.");
        } else {
            System.out.println("The number is not positive.");
        }
    }
}
