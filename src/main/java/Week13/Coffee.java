package Week13;

import java.util.ArrayList;
import java.util.List;

class Coffee {
    private String type;
    private String size;
    private List<String> toppings;

    public Coffee(String type, String size, List<String> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Type: " + this.type + "\nSize: " + this.size + "\nToppings: " + this.toppings;
    }
}
interface CoffeeBuilder {
    void buildType();
    void buildSize();
    void buildToppings();
    Coffee getResult();
}
class EspressoBuilder implements CoffeeBuilder {
    private Coffee coffee = new Coffee("Espresso", "", new ArrayList<>());

    @Override
    public void buildType() {
        coffee = new Coffee("Espresso", "", new ArrayList<>());
    }
    @Override
    public void buildSize() {
        coffee = new Coffee("Espresso", "M", new ArrayList<>());
    }
    @Override
    public void buildToppings() {
        coffee = new Coffee("Espresso", "M", List.of("Whipped cream"));
    }
    @Override
    public Coffee getResult() {
        return coffee;
    }
}
class LatteBuilder implements CoffeeBuilder {
    private Coffee coffee = new Coffee("Latte", "", new ArrayList<>());

    @Override
    public void buildType() {
        coffee = new Coffee("Latte", "", new ArrayList<>());
    }
    @Override
    public void buildSize() {
        coffee = new Coffee("Latte", "L", new ArrayList<>());
    }
    @Override
    public void buildToppings() {
        coffee = new Coffee("Latte", "L", List.of("Mocha"));
    }
    @Override
    public Coffee getResult() {
        return coffee;
    }
}
class CappuccinoBuilder implements CoffeeBuilder {
    private Coffee coffee = new Coffee("Cappuccino", "", new ArrayList<>());

    @Override
    public void buildType() {
        coffee = new Coffee("Cappuccino", "", new ArrayList<>());
    }
    @Override
    public void buildSize() {
        coffee = new Coffee("Cappuccino", "S", new ArrayList<>());
    }
    @Override
    public void buildToppings() {
        coffee = new Coffee("Cappuccino", "S", List.of("Whipped cream"));
    }
    @Override
    public Coffee getResult() {
        return coffee;
    }
}
class CoffeeDirector {
    public void constructCoffee(CoffeeBuilder builder) {
        builder.buildType();
        builder.buildSize();
        builder.buildToppings();
    }
}
class BuilderMain {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        CoffeeBuilder latteBuilder = new LatteBuilder();
        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder();

        director.constructCoffee(espressoBuilder);
        Coffee espresso = espressoBuilder.getResult();
        System.out.println("Espresso: \n" + espresso + "\n");

        director.constructCoffee(latteBuilder);
        Coffee latte = latteBuilder.getResult();
        System.out.println("Latte: \n" + latte + "\n");

        director.constructCoffee(cappuccinoBuilder);
        Coffee cappuccino = cappuccinoBuilder.getResult();
        System.out.println("Cappuccino: \n" + cappuccino);

    }
}