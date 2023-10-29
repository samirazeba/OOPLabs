package Week4.Lecture;

public class Main {
    public static void main(String[] args) {
        Person pekka = new Person("Pekka");
        Person brian = new Person("Brian");
        Person martin = new Person("Martin");

        pekka.printPerson();
        brian.printPerson();
        martin.printPerson();

        pekka.becomeOlder();
        brian.becomeOlder();
        brian.becomeOlder();

        System.out.println("\nAfter becomeOlder method:");

        pekka.printPerson();
        brian.printPerson();

        System.out.println("\ngetAge:");
        System.out.println("Pekka's age: " + pekka.getAge());
        System.out.println("Brian's age: " + brian.getAge());

        int total = pekka.getAge() + brian.getAge();
        System.out.println("\nPekka and Brian total of " + total + " years old.");

        Person bob = new Person("Bob");
        Person andy = new Person("Andy");

        int i = 0;
        while (i < 30) {
            bob.becomeOlder();
            i++;
        }
        andy.becomeOlder();
        System.out.println();

        if (andy.isAdult()){
            System.out.println("adult: ");
            andy.printPerson();
        } else {
            System.out.println("minor: ");
            andy.printPerson();
        }
        if (bob.isAdult()){
            System.out.println("adult: ");
            bob.printPerson();
        } else {
            System.out.println("minor: ");
            bob.printPerson();
        }

        System.out.println();

        //Printing with getters
        if (andy.isAdult()){
            System.out.println(andy.getName() + " is an adult.");
        } else {
            System.out.println(andy.getName() + " is a minor.");
        }
        if (bob.isAdult()) {
            System.out.println(bob.getName() + " is an adult.");
        } else {
            System.out.println(bob.getName() + " is a minor.");
        }

        System.out.println("\ntoString()");
        System.out.println(andy.toString());
        System.out.println(brian);
    }
}
