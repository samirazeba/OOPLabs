package Week4.People;

public class Person {
    private String name;
    private String address;
    private int age;
    private String country;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public int getAge() {
        return this.age;
    }

    public String getCountry() {
        return this.country;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setCountry(String newCountry) {
        this.country = newCountry;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name + "\n" + this.address);
    }
}
