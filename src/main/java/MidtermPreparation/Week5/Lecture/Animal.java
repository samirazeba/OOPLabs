package MidtermPreparation.Week5.Lecture;

import java.lang.annotation.Documented;
interface Ability {
    int age = 1;
    public void play();
}
abstract class Animal {
    private int age;
    private String name;

    public abstract void makeNoise();

    public void animalDescription() {
        System.out.println("I'm the ".concat(name).concat(" and I'm ").concat(String.valueOf(age).concat(" years old.")));
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Cat extends Animal {

    @Override
    public void makeNoise() {
        System.out.println("MEOW");
    }
}
class Dog extends Animal implements Ability {

    @Override
    public void play() {
        System.out.println("I play with a ball");
    }

    @Override
    public void makeNoise() {

    }
}
class Lion extends Animal implements Ability {

    @Override
    public void makeNoise() {
        System.out.println("GRRRR");
    }

    @Override
    public void play() {
        System.out.println("I play with people in a way I eat them.");
    }
}
class RunAnimal {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.makeNoise();

        Dog dog = new Dog();
        dog.play();

        Lion lion = new Lion();
        lion.makeNoise();
        lion.play();
    }

}
