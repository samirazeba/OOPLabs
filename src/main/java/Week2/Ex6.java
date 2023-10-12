package Week2;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        int numberOfTimes;
        Scanner reader = new Scanner(System.in);

        System.out.println("How many times the text should be printed?");
        numberOfTimes = reader.nextInt();

        for (int i = 1; i <= numberOfTimes; i++) {
            System.out.print(i + ". ");
            printText();
        }

    }

    public static void printText() {
        System.out.println("In the beginning there were the swamp, the hoe and Java.");
    }
}
