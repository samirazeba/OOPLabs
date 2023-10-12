package Week2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int sum = 0;
        int read;

       /* for (int i = 1; i <= 3; i++) {
            System.out.print("Please enter " + i + ". number: ");
            read = reader.nextInt();

            sum += read;
        } */

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.print("Type the first number: ");
                read = reader.nextInt();
            } else if (i == 1) {
                System.out.print("Type the second numer: ");
                read = reader.nextInt();
            } else {
                System.out.print("Type the third number: ");
                read = reader.nextInt();
            }
            sum += read;
        }

        System.out.println("\nSum: " + sum);
    }
}
