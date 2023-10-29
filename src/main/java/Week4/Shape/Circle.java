package Week4.Shape;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, FillType fillType, double radius) {
        super(color, fillType);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double Area() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + "\n" + String.valueOf(this.radius);
    }

    public double calculateCircumference(double PI, double r) {
        return 2 * PI * r;
    }

    public double calculateCircumference(double r) {
        return 2 * Math.PI * r;
    }
}

