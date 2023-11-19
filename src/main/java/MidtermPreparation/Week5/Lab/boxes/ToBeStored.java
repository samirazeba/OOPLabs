package MidtermPreparation.Week5.Lab.boxes;

import java.util.ArrayList;
import java.util.List;

interface ToBeStored {
    double weight();
}
class Book implements ToBeStored {
    private String writer;
    private String name;
    private double weight;

    public Book (String writer, String name, double weight) {
        this.writer = writer;
        this.name = name;
        this.weight = weight;
    }

    public String getWriter() {
        return writer;
    }
    public String getName() {
        return name;
    }

    @Override
    public double weight() {
        return weight;
    }
    public void setWriter(String w) {
        this.writer = w;
    }
    public void setName (String n) {
        this.name = n;
    }
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String toString() {
        return this.writer + ": " + this.name;
    }
}
class CD implements ToBeStored {
    private String artist;
    private String title;
    private int year;
    private double weight;

    public CD (String a, String t, int y) {
        this.artist = a;
        this.title = t;
        this.year = y;
        this.weight = 0.1;
    }

    public String getArtist() {
        return artist;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }

    @Override
    public double weight() {
        return weight;
    }

    public void setArtist(String a) {
        this.artist = a;
    }
    public void setTitle(String t) {
        this.title = t;
    }
    public void setWeight (double w) {
        this.weight = w;
    }
    public void setYear (int y) {
        this.year = y;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.title + " (" + this.year + ")";
    }


}
class Box implements ToBeStored {
    private ArrayList<ToBeStored> things;
    private double maxWeight;

    public Box (double maxWeight) {
        this.things = new ArrayList<ToBeStored>();
        this.maxWeight = maxWeight;
    }

    public ArrayList<ToBeStored> getThings() {
        return things;
    }
    public double getMaxWeight() {
        return maxWeight;
    }
    public void setThings(ArrayList<ToBeStored> things) {
        this.things = things;
    }
    public void setMaxWeight(double maxW) {
        this.maxWeight = maxW;
    }

    @Override
    public double weight() {
        double totalWeight = 0;
        for (ToBeStored thing : things) {
            totalWeight += thing.weight();
        }
        return totalWeight;
    }

    public void add(ToBeStored item) {
        if (weight() + item.weight() <= maxWeight) {
            things.add(item);
        }
    }

    @Override
    public String toString() {
        return "Box: " + String.valueOf(things.size()) + " things, total weight " + String.valueOf(this.weight()) + " kg";
    }
}
class RunBoxes {
    public static void main(String[] args) {

        System.out.println("a)");
        Book book1 = new Book ("Fredor Dostojevski", "Crime and Punishment", 2);
        Book book2 = new Book ("Robert Martin", "Clean Code", 1);
        Book book3 = new Book ("Kent Beck", "Test Driven Development", 0.5);

        CD cd1 = new CD ("Pink Floyd", "Dark Side of the Moon", 1973);
        CD cd2 = new CD ("Wgiwam", "Nuclear Nightclub", 1975);
        CD cd3 = new CD ("Randezvous Park", "Closer to Being Here", 2012);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);

        System.out.println("\nb)");
        Box box = new Box(10);

        box.add(new Book ("Fredor Dostojevski", "Crime and Punishment", 2));
        box.add(new Book ("Robert Martin", "Clean Code", 1));
        box.add(new Book ("Kent Beck", "Test Driven Development", 0.5));
        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wgiwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Randezvous Park", "Closer to Being Here", 2012));

        System.out.println(box);

    }
}