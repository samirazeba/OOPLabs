package Week4.Shape;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape("black", FillType.FILLED);

        Circle circle = new Circle("blue", FillType.NOT_FILLED, 2.0);
        System.out.println("Information about our circle:");
        System.out.println(circle.displayInfo());
        System.out.print("Area: " + circle.getArea());

        Rectangle rectangle = new Rectangle("red", FillType.FILLED, 2.2, 10.0);
        System.out.println("\nInformation about our rectangle:");
        System.out.println(rectangle.displayInfo());
        System.out.print("Area: " + rectangle.getArea());

    }
}

