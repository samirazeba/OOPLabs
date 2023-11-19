package MidtermPreparation.Week5.Lecture.polymorphism;

enum Colors {
    EHITE, BLACK, RED, GREEN
}
class Animal {
    private String name;
    private Colors color;

    //method overloading
    public void eat() {
        System.out.println("MLJAC MLJCA");
    }
    public void makeSoound(String sound) {
        System.out.println(sound);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
}
class Tiger extends Animal {
    private int numOfTeeth;

    @Override
    public void eat() {
        System.out.println("TIGER MLJAC MLJAC");
    }
    public void sayTigerHello() {
        System.out.println("HELLO FROM TIGER");
    }

    public int getNumOfTeeth() {
        return numOfTeeth;
    }

    public void setNumOfTeeth(int numOfTeeth) {
        this.numOfTeeth = numOfTeeth;
    }
}
class Turtle extends Animal {
    private String bread;

    @Override
    public void eat() {
        System.out.println("TURTLE MLJAC MLJAC");
    }
    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }
}
class RunPolymorphism {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        Tiger tiger = new Tiger();
        tiger.eat();

        Turtle turtle = new Turtle();
        tiger.eat();

        //Upcasting
        Animal myTiger = new Tiger();
        System.out.println(myTiger);

        doSomeAnimalStaff(tiger);
        doSomeAnimalStaff(myTiger);
        doSomeAnimalStaff(turtle);

    }
    public static void doSomeAnimalStaff(Animal animal) {
        animal.eat();

        //Downcasting
        if (animal instanceof Tiger) {
            Tiger myLocalTiger = (Tiger) animal;
            myLocalTiger.getNumOfTeeth();
        }
    }
}
