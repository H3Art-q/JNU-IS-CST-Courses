package lab8.chapter13;

public class Square extends GeometricObject implements Colorable {
    private double side;

    protected Square() {
        super();
        this.side = 0;
    }

    protected Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
