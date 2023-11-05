package Week5.ToBeStored;

import java.util.ArrayList;

interface ToBeStored {
    double weight();
}

class Book implements ToBeStored {
    private String writer;
    private String name;
    private double weight;

    public Book(String writer, String name, double weight) {
        this.writer = writer;
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return this.writer + ": " + this.name;
    }

    @Override
    public double weight() {
        return this.weight;
    }
}

class CD implements ToBeStored {
    private String artist;
    private String title;
    private int year;
    private double weight;

    public CD(String artist, String title, int year) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.weight = 0.1;
    }

    public String toString() {
        return this.artist + ": " + this.title + " (" + String.valueOf(year) + ")";
    }

    @Override
    public double weight() {
        return weight;
    }
}

class Box implements ToBeStored {
    private ArrayList<ToBeStored> things;
    private double maxWeight;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();
    }

    public ArrayList<ToBeStored> getThings() {
        return things;
    }

    public void setThings(ArrayList<ToBeStored> things) {
        this.things = things;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public double weight() {
        double totalWeight = 0;
        for (ToBeStored thing : things) {
            totalWeight += thing.weight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Box: " + things.size() + " things, total weight " + String.valueOf(weight()) + " kg";
    }

    public void add(ToBeStored item) {
        if (weight() + item.weight() <= maxWeight) {
            things.add(item);
        }
    }

}

class MainTask2 {
    public static void main(String[] args) {

        System.out.println("a)");
        Book book1 = new Book("Fedor Dostojevski", "Crime and Punishment", 2);
        Book book2 = new Book("Robert Martin", "Clean Code", 1);
        Book book3 = new Book("Kent Beck", "Test Driven Development", 0.5);

        CD cd1 = new CD("Pink Floyd", "Dark Side of the Moon", 1937);
        CD cd2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD cd3 = new CD("Randezvous Park", "Closer to Being Here", 2012);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);

        System.out.println("\nb)");
        Box box = new Box(10);

        box.add(new Book("Fredor Dostojevski", "Crime and Punishment", 2));
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Randezvous Park", "Closer to Being Here", 2012));

        System.out.println(box);
    }
}

