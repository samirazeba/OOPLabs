package Week6.Lecture;

class StringPrinter {
    private String name;

    public StringPrinter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printString() {
        System.out.println(this.name);
    }
}
class IntegerPrinter {
    private int number;

    public IntegerPrinter(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
class DoublePrinter { }

/*
class OurNewPrinter <T extends Animal & Iterable & Comparable> { }

 */
class OurPrinter<T, K> {

    private T myCustomThing;
    private K anotherThing;

    public OurPrinter(T myCustomThing, K anotherThing) {
        this.myCustomThing = myCustomThing;
        this.anotherThing = anotherThing;
    }

    public T getMyCustomThing() {
        return myCustomThing;
    }
    public void setMyCustomThing (T myCustomThing) {
        this.myCustomThing = myCustomThing;
    }

    public K getAnotherThing() {
        return anotherThing;
    }

    public void setAnotherThing(K anotherThing) {
        this.anotherThing = anotherThing;
    }

    public void print() {
        System.out.println(this.myCustomThing + "<-->" + this.anotherThing);
    }
}

class Implementation {
    public static void main(String[] args) {
        OurPrinter<Integer, String> integerOurPrinter = new OurPrinter<>(15, "Samira");
        integerOurPrinter.print();

        OurPrinter<String, String> stringOurPrinter = new OurPrinter<>("Samira", "Emina");
        stringOurPrinter.print();

        //OurPrinter<Dog, String> dogOurPrinter = new OurPrinter<Dog>(new Dog (), "Cuko");
        //dogOurPrinter.print();

    }
    /*
    public static void <T> doSomething (T something) {
        System.out.println("I did it");
    }
    public static void <T, K> doSomething(T something, K anotherSomething) {
        System.out.println("I did it");
        return something;
    }*/
}