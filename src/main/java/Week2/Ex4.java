package Week2;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        int num1, num2;
        Scanner reader = new Scanner(System.in);

        System.out.print("First: ");
        num1 = reader.nextInt();
        System.out.print("Last: ");
        num2 = reader.nextInt();

        while (true) {
            if (num1 > num2) {
                break;
            } else {
                int i = num1;
                while (i <= num2) {
                    System.out.println(i);
                    i++;
                }
                break;
            }
        }
    }
}
