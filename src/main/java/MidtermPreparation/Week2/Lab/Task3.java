package MidtermPreparation.Week2.Lab;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int number;
        int sum = 0;
        Scanner reader = new Scanner(System.in);

        while (true){
            number = reader.nextInt();
            if (number == 0) {
                break;
            } else {
                sum += number;
            }
            System.out.println("Sum now: " + sum);
        }
        System.out.println("Sum in the end: " + sum);
    }
}
