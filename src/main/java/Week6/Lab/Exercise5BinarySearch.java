package Week6.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5BinarySearch {
    public static boolean search (int[] array, int searchedValue) {
        int left = 0;
        int right = array.length - 1;
        boolean flag = false;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == searchedValue) {
                flag = true;
            }
            if (array[middle] < searchedValue) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return flag;
    }
}
class MainBinarySearch {
    public static void main(String[] args) {
        int[] array = {-3, 2, 3, 4, 7, 8, 12};
        Scanner reader = new Scanner(System.in);

        System.out.println("Values of the array: " + Arrays.toString(array));
        System.out.println();

        System.out.print("Enter searched number: ");
        String searchedValue = reader.nextLine();
        System.out.println();

        boolean result = Exercise5BinarySearch.search(array, Integer.parseInt(searchedValue));

        if (result) {
            System.out.println("Value " + searchedValue + " is in the array");
        } else {
            System.out.println("Value " + searchedValue + " is not in the array");
        }
    }
}
