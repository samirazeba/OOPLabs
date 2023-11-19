package MidtermPreparation.Week6;

import java.util.Random;

class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint = 0;

    public NightSky (double density) {
        this.density = density;
        this.width = 20;
        this.height = 10;
    }
    public NightSky (int width, int height) {
        this.density = 0.1;
        this.width = width;
        this.height = height;
    }
    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
    }

    public void printLine() {
        Random random = new Random();
        for (int i = 0; i < width; i++) {
            if (random.nextDouble() <= density) {
                System.out.print("*");
                starsInLastPrint++;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public void print() {
        for (int i = 0; i < this.height; i++) {
            printLine();
        }
    }
    public int starsInLastPrint() {
        int numberOfStars = starsInLastPrint;
        starsInLastPrint = 0;
        return numberOfStars;
    }
}
class RunNightSky {
    public static void main(String[] args) {
        NightSky nightSky = new NightSky(0.1, 40, 30);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
        System.out.println("");

        nightSky = new NightSky(0.2, 15, 6);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
    }
}
