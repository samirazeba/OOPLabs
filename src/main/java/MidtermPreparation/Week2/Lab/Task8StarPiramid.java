package MidtermPreparation.Week2.Lab;

public class Task8StarPiramid {
    public static void drawStarsPiramid(int rows) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void invertedPiramid(int rows) {
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawStarsPiramid(5);
        System.out.println();
        invertedPiramid(5);
    }
}
