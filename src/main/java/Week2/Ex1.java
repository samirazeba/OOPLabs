package Week2;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        String correctPassword = "carrot";
        String inputPassword;

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.print("Type the password: ");
            inputPassword = scan.next();

            if (inputPassword.equals(correctPassword)){
                System.out.println("Right!\n\nThe secret is: jryy qbar!");
                break;
            } else {
                System.out.println("Wrong!");
            }
        }
    }
}
