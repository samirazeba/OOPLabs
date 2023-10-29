package Week4.Lecture;

class SecondPerson {
    private String name;
    private int age;
    private int weight;
    private int height;

    public SecondPerson (String initialName) {
        this.name = initialName;
        this.age = 0;
        this.weight = 0;
        this.height = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }
    public double bodyMassIndex() {
        double heightDividedByHundred = this.height / 100.0;
        return this.weight / (heightDividedByHundred * heightDividedByHundred);
    }
}
class SecondPersonMain {
    public static void main(String[] args) {
        SecondPerson matti = new SecondPerson("Matti");
        SecondPerson john = new SecondPerson("John");

        matti.setHeight(180);
        matti.setWeight(86);

        john.setHeight(175);
        john.setWeight(64);

        System.out.println(matti.getName() + " body mass index: " + matti.bodyMassIndex());
        System.out.println(john.getName() + " body mass index: " + john.bodyMassIndex());

    }
}