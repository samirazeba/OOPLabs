package Week5.boxes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

class Thing {
    private double weight;
    private String name;

    public Thing(String name, double weight) {
        this.name = name;
        if(weight >= 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
    }

    public Thing(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Thing thing = (Thing) o;
        return Objects.equals(name, thing.name);
    }
}
abstract class Box {
    public abstract void add(Thing thing);

    public void add (Collection<Thing> things) {
        for (Thing thing : things) {
            add(thing);
        }
    }

    public abstract boolean isInTheBox (Thing thing);
}
class MaxWeightBox extends Box {
    private List<Thing> things = new ArrayList<>();
    private int weightInBox;
    private int maxWeight;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.weightInBox = 0;
    }

    @Override
    public void add (Thing thing) {
        if (this.weightInBox < this.maxWeight) {
            this.weightInBox += (int) thing.getWeight();
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing t : things) {
            if (t.getName().equals(thing.getName())) {
                return true;
            }
        }
        return false;
    }
}
class OneThingBox extends Box {
    private ArrayList<Thing> things = new ArrayList<>();

    public OneThingBox () {

    }

    @Override
    public void add(Thing thing) {
        if(this.things.size() == 0) {
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing t : things) {
            if(t.getName().equals(thing.getName())) {
                return true;
            }
        }
        return false;
    }
}
class BlackHoleBox extends Box {
    private ArrayList<Thing> things = new ArrayList<>();

    public BlackHoleBox () {

    }

    @Override
    public void add(Thing thing) {
        things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}
class Main {
    public static void main(String[] args) {
        System.out.println("b)");
        MaxWeightBox coffeeBox = new MaxWeightBox(10);

        coffeeBox.add(new Thing("Saludo", 5));
        coffeeBox.add(new Thing("Pirkka", 5));
        coffeeBox.add(new Thing("Kopi Luwak", 5));

        System.out.println(coffeeBox.isInTheBox(new Thing("Saludo")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Pirkka")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Kopi Luwak")));

        System.out.println("\nc)");
        OneThingBox box = new OneThingBox();
        box.add(new Thing("Saludo", 5));
        box.add(new Thing("Pirkka", 5));

        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkka")));

        System.out.println("\nd)");
        BlackHoleBox box1 = new BlackHoleBox();
        box1.add(new Thing("Saludo", 5));
        box1.add(new Thing("Pirkka", 5));

        System.out.println(box1.isInTheBox(new Thing("Saludo")));
        System.out.println(box1.isInTheBox(new Thing("Pirkka")));
    }
}
