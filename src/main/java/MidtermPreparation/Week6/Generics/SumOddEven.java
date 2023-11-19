package MidtermPreparation.Week6.Generics;

import java.util.ArrayList;
import java.util.List;

public class SumOddEven {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        double sumEven = 0, sumOdd = 0;
        for (T num : numbers) {
            if (num.doubleValue() % 2 == 0) {
                sumEven += num.doubleValue();
            } else {
                sumOdd += num.doubleValue();
            }
        }
        System.out.println("Sum of even numbers: " + sumEven);
        System.out.println("Sum of odd numbers: " + sumOdd);
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3,4,5,6);
        sumEvenOdd(integerList);
    }
}