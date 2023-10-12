package Week2;

public class Ex9 {
    private static void drawNumbersPiramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void drawNumbersPiramidByRows(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawNumbersPiramid(5);
        System.out.println();
        drawNumbersPiramidByRows(10);
    }
}
