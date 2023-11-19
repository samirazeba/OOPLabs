package MidtermPreparation.Week2.Lab;

import java.util.Scanner;

public class Task5 {
    public static int baseTwo(int number) {
        //Scanner reader = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += Math.pow(2, i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type a number; ");
        int num = reader.nextInt();
        System.out.println("The result is: " + baseTwo(num));
    }

}
