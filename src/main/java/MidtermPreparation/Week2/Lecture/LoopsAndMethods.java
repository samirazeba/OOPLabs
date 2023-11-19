package MidtermPreparation.Week2.Lecture;

public class LoopsAndMethods {
    public static String sayMyName(String name) {
        return "Your name is: " + name;
    }
    public static void printHalfPyramidShapeOfNRows(int rows) {
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void printNumbersInRange(int start, int end){
        for(int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(sayMyName("Samira"));
        printHalfPyramidShapeOfNRows(5);
        printNumbersInRange(5,8);
    }
}
