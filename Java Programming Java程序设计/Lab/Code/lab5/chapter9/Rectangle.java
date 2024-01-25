package lab5.chapter9;
// 9.1

public class Rectangle {
    private final double width;
    private final double height;

    Rectangle(){
        this.width = 1;
        this.height = 1;
    }

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    public double getArea(){
        return this.height * this.width;
    }

    public double getPerimeter(){
        return 2 * (height + width);
    }
}
