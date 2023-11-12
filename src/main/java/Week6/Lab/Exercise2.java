package Week6.Lab;

public class Exercise2 {
    public static int indexOfSmallest(int [] array) {
        int index = 0;
        int min = array [0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] values = {6, 5, 8, 7, 11};
        System.out.println("Index of the smallest: " + indexOfSmallest(values));
    }
}
