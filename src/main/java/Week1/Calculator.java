package Week1;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        System.out.println("Welcome to the calculator");

        Scanner scan = new Scanner(System.in);

       /* while (true) {
            System.out.print("Enter a command (sum, difference, quit): ");
            String command = scan.nextLine();

            if (command.equals("quit")) {
                System.out.println("See you soon!");
                break;
            }

            System.out.print("Enter the numbers: ");
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();

            if (command.equals("sum")) {
                int sum = num1 + num2;
                System.out.println("The sum of the numbers is: " + sum);
                break;
            } else if (command.equals("difference")) {
                int difference = num1 - num2;
                System.out.println("The difference of the numbers is: " + difference);
                break;
            } else {
                System.out.println("Unknown command!");
                break;
            }
        }*/

        List<String> commands = Arrays.asList("sum", "difference", "quit");
        String choice;

        System.out.print("Please choose the command (sum, difference, quit): ");
        choice = scan.nextLine();

        while (true) {
            if (commands.contains(choice)) {
                if (choice.equals("quit")) {
                    break;
                }
                System.out.print("Enter the numbers: ");
                int num1 = scan.nextInt();
                int num2 = scan.nextInt();

                if (choice.equals("sum")) {
                    int sum = num1 + num2;
                    System.out.println("The sum of the numbers is: " + sum);
                    break;
                }
                if (choice.equals("difference")) {
                    int difference = num1 - num2;
                    System.out.println("The difference of the numbers is: " + difference);
                    break;
                }
            } else {
                System.out.println("Unknown command!");
                break;
            }
        }
        System.out.println("Thanks, bye!");
    }
}
