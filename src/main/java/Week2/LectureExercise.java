package Week2;

import java.util.Scanner;

public class LectureExercise {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter your age: ");
        int age = reader.nextInt();

        while (true) {
            if (age < 5 || age > 85) {
                System.out.println("You are a little liar.");
                if (age < 5) {
                    System.out.println("You are too young.");
                } else {
                    System.out.println("You are too old.");
                }
                System.out.println("Please enter your age. This time without lying!");
                age = reader.nextInt();
                continue;
            }
            break;
        }
        System.out.println("You are " + age + " years old.");
    }
}
