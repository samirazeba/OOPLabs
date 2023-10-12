package Week2;

public class Ex8 {
    private static void drawStarsPiramid(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void drawStarsInvertedPiramid(int rows) {
        for (int i = rows; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawStarsPiramid(5);
        System.out.println();
        drawStarsInvertedPiramid(5);
    }
}
