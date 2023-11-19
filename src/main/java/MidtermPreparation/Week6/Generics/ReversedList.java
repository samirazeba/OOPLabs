package MidtermPreparation.Week6.Generics;

import java.util.ArrayList;
import java.util.List;

public class ReversedList {
    public static <T> List<T> reversedList(List<T> list) {
        List<T> newList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public static void main(String[] args) {
        List<String> stringList = List.of("Red", "Green", "Blue");
        System.out.println("Reversed list: " + reversedList(stringList));
    }
}