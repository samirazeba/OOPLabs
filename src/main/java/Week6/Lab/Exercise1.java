package Week6.Lab;

public class Exercise1 {
    public static int smallest(int[] array) {
        int min = array[0];

        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int [] values = {6, 5, 8, 7, 11};
        System.out.println("smallest: " + smallest(values));
    }
}
