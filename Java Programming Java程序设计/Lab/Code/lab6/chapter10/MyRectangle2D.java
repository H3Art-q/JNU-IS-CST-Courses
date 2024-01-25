package lab6.chapter10;
// 10.13

public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    MyRectangle2D() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(double x, double y) {
        return x < this.x + width / 2 &&
                x > this.x - width / 2 &&
                y < this.y + height / 2 &&
                y > this.y - height / 2;
    }

    public boolean contains(MyRectangle2D r) {
        return r.getX() + r.getWidth() / 2 < this.x + width / 2 &&
                r.getX() - r.getWidth() / 2 > this.x - width / 2 &&
                r.getY() + r.getHeight() / 2 < this.y + height / 2 &&
                r.getY() - r.getHeight() / 2 > this.y - height / 2;
    }

    public boolean overlaps(MyRectangle2D r) {
        return contains(r.getX() + r.getWidth() / 2, r.getY() + r.getHeight() / 2) ||
                contains(r.getX() + r.getWidth() / 2, r.getY() - r.getHeight() / 2) ||
                contains(r.getX() - r.getWidth() / 2, r.getY() + r.getHeight() / 2) ||
                contains(r.getX() - r.getWidth() / 2, r.getY() - r.getHeight() / 2);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
