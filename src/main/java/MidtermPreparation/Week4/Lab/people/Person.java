package MidtermPreparation.Week4.Lab.people;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private String address;
    private int age;
    private String country;

    public Person (String name, String address) {
        this.name = name;
        this.address = address;
    }
    public String getName () {
        return name;
    }
    public String getAddress() {
        return address;
    }
    private int getAge() {
        return age;
    }
    private String getCountry () {
        return country;
    }
    public void setName(String n) {
        this.name = n;
    }
    private void setAge(int a) {
        this.age = a;
    }
    private void setCountry(String c) {
        this.country = c;
    }
    public void setAddress(String a) {
        this.address = a;
    }

    @Override
    public String toString() {
        return this.name + "\n " + this.address;
    }
}
class Student extends Person {
    private int credits;
    private int student_id;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
    }

    public int credits() {
        return credits;
    }
    public int getStudent_id() {
        return student_id;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    public void setStudent_id(int id) {
        this.student_id = id;
    }

    public void study() {
        this.credits++;
    }

    @Override
    public String toString() {
        return getName() + "\n " + getAddress() + "\n credits " + credits();
    }

    public void addGrade() {
        for (Integer grade : this.grades) {
            this.grades.add(grade);
        }
    }
}
class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return getName() + "\n " + getAddress() + "\n salary " + salary + " euros/month";
    }
}
class RunPerson {
    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }
    public static void main(String[] args) {
        Person pekka = new Person ("Pekka Mikkola", "Korsontie Street 1");
        Person esko = new Person ("Esko Ukkonen", "Mannerheimintie Street 15");

        System.out.println("a)");
        System.out.println(pekka);
        System.out.println(esko);

        System.out.println("\nb)");
        Student olli = new Student("Olli", "Ida Albergintie Street 1");
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits " + olli.credits());

        System.out.println("\nc)");
        pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1", 1200);
        esko = new Teacher ("Esko Ukkonen", "Mannerheimintie", 5400);
        System.out.println(pekka);
        System.out.println(esko);

        olli = new Student("Olli", "Ida");
        for (int i = 0; i < 25; i++) {
            olli.study();
        }
        System.out.println(olli);

        System.out.println("\nd)");
        List<Person> people = new ArrayList<Person>();
        people.add (new Teacher("Pekka Mikkola", "Korsontie Street 1", 1200));
        people.add (new Student("Olli", "Ida"));

        printDepartment(people);

    }
}
