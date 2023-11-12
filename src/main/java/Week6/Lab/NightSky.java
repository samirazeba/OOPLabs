package Week6.Lab;

import java.util.Random;

class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint = 0;

    //First Constructor:
    public NightSky(double density) {
        this.density = density;
        this.width = 20;
        this.height = 10;
    }
    //Secon Constructor:
    public NightSky(int width, int height) {
        this.width = width;
        this.height = height;
        this.density = 0.1;
    }
    //Third Constructor
    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
    }

    public void printLine() {
        Random random = new Random();
        for (int i = 0; i < this.width; i++){
            if(random.nextDouble() <= this.density) {
                System.out.print("*");
                starsInLastPrint++; //counts the number of stars;
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
class MainNightSky {
    public static void main(String[] args) {
        NightSky NightSky = new NightSky(0.1, 40, 10);
        System.out.println("PART 1 (Print line of stars):");
        NightSky.printLine();

        System.out.println("\nPART 2 (Print a night sky):");
        NightSky = new NightSky(8, 4);
        NightSky.print();

        System.out.println("\nPART 3:");
        System.out.println("Number of stars in the previous night sky: " + NightSky.starsInLastPrint());
        System.out.println("Final example:");
        NightSky.print();
        System.out.println("Number of stars: " + NightSky.starsInLastPrint());
    }
}
