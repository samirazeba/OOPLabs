package MidtermPreparation.Week4.Lab.shapes;

enum FillType {
    FILLED, NOT_FILLED
}
class Shape {
    private String color;
    private FillType fillType;

    public Shape (String color, FillType fillType) {
        this.color = color;
        this.fillType = fillType;
    }
    public String getColor() {
        return color;
    }
    public FillType getFillType() {
        return fillType;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setFillType(FillType ft) {
        this.fillType = ft;
    }

    public String displayInfo() {
        return "Color: " + this.color + "\nFill type: " + this.fillType;
    }

    public double getArea() {
        return 0;
    }
}
class Circle extends Shape {
    private double radius;

    public Circle (String color, FillType fillType, double radius) {
        super(color, fillType);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double r) {
        this.radius = r;
    }

    @Override
    public String displayInfo() {
        return getColor() + ", " + getFillType() + ", " + getRadius();
    }
    @Override
    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
    public double calculateCircumferenec(double PI, double r) {
        return 2 * PI * r;
    }
    public double calculateCircumference(double r) {
        final double pi = 3.14;
        return 2 * pi * r;
    }
}
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, FillType ft, double h, double w) {
        super(color, ft);
        this.width = w;
        this.height = h;
    }

    @Override
    public String displayInfo() {
        return getColor() + ", " + getFillType() + ", " + width + ", " + height;
    }

    @Override
    public double getArea() {
        return this.height * this.width;
    }
}
class RunShape {
    public static void main(String[] args) {
        Circle c = new Circle ("red", FillType.FILLED, 2.0);
        Rectangle r = new Rectangle("blue", FillType.NOT_FILLED, 1.0, 2.0);

        System.out.println("Circle\n" + c.displayInfo());
        System.out.println("\nRectangle\n" + r.displayInfo());
    }
}