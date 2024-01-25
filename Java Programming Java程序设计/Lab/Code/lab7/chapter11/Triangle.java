package lab7.chapter11;

// 11.1
public class Triangle extends GeometricObject {
    private final double side1;
    private final double side2;
    private final double side3;

    Triangle() {
        super();
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        if (!isTriangle(side1, side2, side3)) {
            throw new IllegalArgumentException("These 3 side cannot form a triangle!");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    private boolean isTriangle(double side1, double side2, double side3) {
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

    public double getArea() {
        double factor = this.getPerimeter() / 2;
        return Math.sqrt(factor * (factor - side1) * (factor - side2) * (factor - side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 +
                " side3 = " + side3;
    }
}
