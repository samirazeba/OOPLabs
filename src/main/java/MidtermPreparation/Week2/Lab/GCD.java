package MidtermPreparation.Week2.Lab;

public class GCD {
    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(gcd(6,3));
    }
}
