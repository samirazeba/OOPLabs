package MidtermPreparation.Week2.Lab;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int first, last;
        Scanner reader = new Scanner(System.in);
        System.out.print("First: ");
        first = reader.nextInt();
        System.out.print("Second: ");
        last = reader.nextInt();

        if (first > last) {
            System.out.println();
        } else {
            while (first <= last) {
                int i = first;
                System.out.println(i);
                first++;
            }
        }


    }
}
