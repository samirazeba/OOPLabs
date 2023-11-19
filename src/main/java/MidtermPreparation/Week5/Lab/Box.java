package MidtermPreparation.Week5.Lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

abstract class Box {
    public abstract void add (Thing thing);

    public void add(Collection<Thing> things) {
        for(Thing thing : things) {
            add(thing);
        }
    }

    public abstract boolean isInTheBox(Thing thing);
}
class Thing {
    private double weight;
    private String name;


    public Thing (double weight, String name) {
        if (weight >= 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight cannot be nefative");
        }
        this.name = name;
    }
    public Thing (String n) {
        this.name = n;
    }

    public double getWeight() {
        return weight;
    }
    public String getName() {
        return name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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
class MaxWeightBox extends Box {
    private int maxWeight;
    private double weightInTheBox;
    private List<Thing> things = new ArrayList<>();

    public MaxWeightBox (int maxWeight) {
        this.maxWeight = maxWeight;
        this.weightInTheBox = 0;
    }

    @Override
    public void add(Thing thing) {
        if (this.weightInTheBox < this.maxWeight) {
            this.weightInTheBox += (int)thing.getWeight();
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
class OnethingBox extends Box {

    private List<Thing> things = new ArrayList<>();
    public OnethingBox () {}

    @Override
    public void add (Thing thing) {
        while (things.size() <= 1) {
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing t : things) {
            if (thing.getName().equals(t.getName())) {
                return true;
            }
        }
        return false;
    }
}
class BlackHoleBox extends Box {
    private List<Thing> things = new ArrayList<>();

    public BlackHoleBox() {}

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }

    @Override
    public void add (Thing thing) {
        things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}
class RunBox {
    public static void main(String[] args) {
        MaxWeightBox coffeeBox = new MaxWeightBox(10);
        coffeeBox.add(new Thing (5, "Saludo"));
        coffeeBox.add(new Thing (5, "Pirkka"));
        coffeeBox.add(new Thing (5, "Kopi Luwak"));

        System.out.println(coffeeBox.isInTheBox(new Thing ("Saludo")));
        System.out.println(coffeeBox.isInTheBox(new Thing ("Pirkka")));
        System.out.println(coffeeBox.isInTheBox(new Thing ("Kopi Luwak")));

        System.out.println("\nc)");
        OnethingBox box = new OnethingBox();
        box.add(new Thing (5, "Saludo"));
        box.add(new Thing (5, "Pirkka"));

        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkka")));

        System.out.println("\nd)");
        BlackHoleBox box1 = new BlackHoleBox();
        box1.add(new Thing (5, "Saludo"));
        box1.add(new Thing (5, "Pirkka"));

        System.out.println(box1.isInTheBox(new Thing("Saludo")));
        System.out.println(box1.isInTheBox(new Thing("Pirkka")));

        System.out.println("\ne)");
        //Upcasting
        Box b = new MaxWeightBox(10);
        b.add(new Thing (5, "Saludo"));

        //Downcastiong
        if (coffeeBox instanceof MaxWeightBox) {
            MaxWeightBox maxWeightBox = (MaxWeightBox) coffeeBox;
            System.out.println(maxWeightBox.isInTheBox(new Thing ("Saludo")));
        }
        Box b1 = new OnethingBox();
        b1.add(new Thing(5, "Saludo"));

        if (b1 instanceof OnethingBox) {
            OnethingBox onethingBox = (OnethingBox) b1;
            System.out.println(onethingBox.isInTheBox(new Thing ("Saludo")));
        }

        Box b2 = new BlackHoleBox();
        b2.add(new Thing (5, "Saludo"));

        if (b2 instanceof BlackHoleBox) {
            BlackHoleBox blackHoleBox = (BlackHoleBox) b2;
            System.out.println(blackHoleBox.isInTheBox(new Thing ("Saludo")));
        }
    }
}