package Week2;

import java.util.Random;
import java.util.Scanner;

public class Ex10 {
    public static int drawNumber() {
        return new Random().nextInt(100);
    }

    public static void main(String[] args) {
        int guess = 1;
        int number;
        int correctNumber = (int) drawNumber();
        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.print("Guess a number: ");
            number = reader.nextInt();
            if (number > correctNumber) {
                System.out.println("The number is greater, guesses made: " + guess);
                //continue;
            } else if (number < correctNumber) {
                System.out.println("The number is lesser, guesses made: " + guess);
                //continue;
            } else {
                System.out.println("Congratulations, your guess is correct!");
                break;
            }
            guess++;
        }
    }
}

