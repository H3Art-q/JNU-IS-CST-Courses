package lab5.chapter9;
// 9.9

public class RegularPolygon {
    private int n; // number of side
    private double side; // length of side
    private double x; // x-coordinate of the polygon's center
    private double y; // y-coordinate of the polygon's center

    RegularPolygon() {
        this.n = 3;
        this.side = 1;
        this.x = 0;
        this.y = 0;
    }

    RegularPolygon(int numOfSide, double lenOfSide) {
        this.n = numOfSide;
        this.side = lenOfSide;
        this.x = 0;
        this.y = 0;
    }

    RegularPolygon(int numOfSide, double lenOfSide, double centerX, double centerY) {
        this.n = numOfSide;
        this.side = lenOfSide;
        this.x = centerX;
        this.y = centerY;
    }

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return this.n * this.side;
    }

    public double getArea() {
        return (n * Math.pow(this.side, 2)) / (4 * Math.tan(Math.PI / this.n));
    }
}
