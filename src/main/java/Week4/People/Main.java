package Week4.People;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }
    public static void main(String[] args) {
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");

        System.out.println("a)");
        System.out.println(pekka);
        System.out.println(esko);

        System.out.println("\nb)");
        Student olli = new Student ("Olli", "Ida Albergintie 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("credits: " + olli.getCredits());
        olli.study();
        System.out.println("credits: " + olli.getCredits());

        System.out.println("\nc)");
        pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println(pekka);
        System.out.println(esko);

        olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki");
        for (int i = 0; i < 25; i++) {
            olli.study();
        }
        System.out.println(olli);

        System.out.println("\nd)");
        List<Person> people = new ArrayList<Person>();
        people.add(new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200));
        people.add(new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki"));

        printDepartment(people);

        //3.
        System.out.println("\n3.");
        olli.setAge(21);
        olli.setCountry("Finland");
        System.out.println(olli + "\n" + olli.getAge() + "\n" + olli.getCountry());

        //4.
        System.out.println("\n4.");
        olli.addGrade(7);
        olli.addGrade(10);
        olli.addGrade(8);
        olli.addGrade(8);
        olli.printGrades();


    }

}
