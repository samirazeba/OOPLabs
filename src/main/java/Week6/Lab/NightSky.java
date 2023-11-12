package Week6.Lab;

import java.util.Random;

class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInTheLastPrint=0;

    public NightSky(double density) {
        this.density = density;
        this.width = 20;
        this.height = 10;
    }
    public NightSky(int width, int height) {
        this.width = width;
        this.height = height;
        this.density = 0.1;
    }
    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
    }

    public void printLine() {
        Random random = new Random();
        for (int i = 0; i < this.width; i++){
            double randomValue = random.nextDouble();
            if (randomValue < this.density) {
                System.out.print("*");
                starsInTheLastPrint++;
            } else {
                System.out.print(" ");
            }
        }
    }
    public void print() {
        for (int i = 0; i < width; i++){
            printLine();
            System.out.println();
        }
    }
    public int starsInLastPrint() {
        int sitlp = starsInTheLastPrint;
        starsInTheLastPrint=0;
        return sitlp;

    }
}
class NightSkyMain {
    public static void main(String[] args) {
        /*NightSky nightSky = new NightSky(0.1, 40, 10);
        nightSky.printLine();
        System.out.println("Number of start: "+ nightSky.starsInLastPrint());

        NightSky nightSky1 = new NightSky(8,4);
        nightSky1.print();
        System.out.println("Number of stars: " + nightSky1.starsInLastPrint());
        System.out.println();

        nightSky1.print();
        System.out.println("Number of stars: " + nightSky1.starsInLastPrint());*/

        NightSky nightsky = new NightSky(0.125, 5, 7);
        nightsky.print();
        System.out.println();

        System.out.println("Number of stars: "+ nightsky.starsInLastPrint());
        nightsky.print();
        System.out.println("Number of stars: "+ nightsky.starsInLastPrint());
    }
}

