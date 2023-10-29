package Week4.Lecture;

public class Person {
    private String name;
    private int age;

    public Person(String initialName){
        this.age = 0;
        this.name = initialName;
    }
    public void printPerson() {
        System.out.println(this.name + ", age " + this.age + " years");
    }

    //Create a method that will increace the age of a person by one
    public void becomeOlder(){
        this.age++;
    }

    public int getAge(){
        return this.age;
    }

    public boolean isAdult() {
        return this.age >= 18;
    }
    public String getName() {
        return this.name;
    }
    public String toString() {
        return this.name + ", age " + this.age + " years";
    }
}
