package Week6.Lab;

public class Exercise3 {
    public static int indexOfSmallestStartingFrom(int[] array, int index) {
        int min = array[index];
        int smallestIndex = index;

        for (int i = index; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;

    }

    public static void main(String[] args) {
        int [] values = {-1, 6, 9, 8, 12};
        System.out.println(indexOfSmallestStartingFrom(values, 1));
        System.out.println(indexOfSmallestStartingFrom(values, 2));
        System.out.println(indexOfSmallestStartingFrom(values, 4));
    }
}
