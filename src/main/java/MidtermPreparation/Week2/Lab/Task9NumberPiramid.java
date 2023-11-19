package MidtermPreparation.Week2.Lab;

public class Task9NumberPiramid {
    public static void columnPiramid(int rows){
        for (int i = 1; i <= rows; i++) {
            for( int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void rowPiramid(int rows) {
        for(int i = 1; i <= rows; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void quizPiramid(int rows) {
        int counter = 0;
        for (int i = 1; i <= rows; i++) {
            for(int j = 1; j <= i; j++) {
                counter++;
                System.out.print(counter + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rowPiramid(5);
        columnPiramid(5);
        quizPiramid(5);
    }
}
