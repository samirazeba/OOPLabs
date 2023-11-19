package MidtermPreparation.Week2.Lab;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String correctPassword = "Samira";
        String inputPassword;
        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.print("Type the password: ");
            inputPassword = reader.nextLine();

            if (inputPassword.equals(correctPassword)) {
                System.out.println("The secret is: jryy qbar");
                break;
            }
        }
    }
}
