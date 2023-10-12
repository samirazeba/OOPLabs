package Week2;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        int n;
        int sum = 0;
        Scanner reader = new Scanner(System.in);

        System.out.print("Type a number: ");
        n = reader.nextInt();

        for (int i = 0; i <= n; i++) {
            int number = (int) Math.pow(2, i);
            sum += number;
        }
        System.out.println("The result is: " + sum);
    }
}
