package lab8.chapter13;

// 13.1
public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    protected Triangle() {
        super();
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    protected Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (!isTriangle()) {
            throw new IllegalArgumentException("These 3 side cannot form a triangle!");
        }
    }

    private boolean isTriangle() {
        return side1 + side2 > side3 &&
                side1 + side3 > side2 &&
                side2 + side3 > side1;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double factor = this.getPerimeter() / 2;
        return Math.sqrt(factor * (factor - side1) * (factor - side2) * (factor - side3));
    }

    @Override
    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "The triangle's area is " + getArea() +
                ", its perimeter is " + getPerimeter() +
                ", " + super.toString();
    }
}
