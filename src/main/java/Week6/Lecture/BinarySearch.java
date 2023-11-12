package Week6.Lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Human implements Comparable<Human> {
    private String name;
    private int age;
    private int weight;

    public Human(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + String.valueOf(age) +
                ", weight=" + String.valueOf(weight) +
                '}';
    }

    @Override
    public int compareTo(Human human) {
        if (this.age == human.getAge() && this.weight == human.getWeight()) {
            return 0;
        } else if (this.age > human.getAge()) {
            return 1000; //mozemo staciti bilo koji broj
        } else  {
            return -1000; //mozemo staviti bilo koji broj
        }
    }
}
class ToBeRun {
    public static void main(String[] args) {
        List<Human> humanList = Arrays.asList(
                new Human("Becir", 29, 72),
                new Human ("Basar", 20, 67),
                new Human("Amila", 22, 40)
        );

        Collections.sort(humanList);
        System.out.println(humanList);

        //ako hocemo da printamo u suprotnom redoslijedu,
        //samo zamijenimo brojeve u return statementu
    }
}
