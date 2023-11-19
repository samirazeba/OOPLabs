package MidtermPreparation.Week1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Introduction {
    // Simple calculator simulator

    public static void simpleCalculator () {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to simple calculator");
        List<String> options = Arrays.asList("sum", "difference", "quit");

        while (true) {
            System.out.println("Please enter your selection: sum, difference, or quit");
            String command = reader.nextLine();

            if (options.contains(command)) {
                if (command.equals("quit")) {
                    break;
                }
                System.out.println("Enter the first number: ");
                int firstNumber = reader.nextInt();

                System.out.println("Enter the seconf number: ");
                int secondNumber = reader.nextInt();

                if (command.equals("sum")){
                    System.out.println("Sum: " + (firstNumber + secondNumber));
                    break;
                }

                System.out.println("Difference: " + (firstNumber - secondNumber));
                break;
            }
        }
    }

    public static void main(String[] args) {
        simpleCalculator();
    }
}
