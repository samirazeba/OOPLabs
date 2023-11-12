package Week6.Lecture;

class Examples {
    private static int counter;
    private String name;

    public Examples(String name) {
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Examples.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void increaseCounter() {
        counter++;
    }
}
class Main {
    public static void main(String[] args) {
        Examples e = new Examples("Samira");

        //accessing static (class is owner) and non static (object is owner) variable
        System.out.println(e.getName());
        Examples.increaseCounter();
        System.out.println(Examples.getCounter());

        Examples emina = new Examples("Emina");
        System.out.println(emina.getName());
        Examples.increaseCounter();
        System.out.println(Examples.getCounter());
    }
}
