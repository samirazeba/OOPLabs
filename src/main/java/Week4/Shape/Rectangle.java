package Week4.Shape;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, FillType fillType, double width, double height) {
        super(color, fillType);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + "\n" + String.valueOf(this.height + "\n" + this.width);
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

}

