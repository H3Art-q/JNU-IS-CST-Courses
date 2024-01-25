package lab5.chapter9;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);
        System.out.println("We create the first rectangle with width " + rectangle1.getWidth()
                + " and height " + rectangle1.getHeight()
        );
        System.out.println("Its area is " + rectangle1.getArea() + ", perimeter is " + rectangle1.getPerimeter());

        Rectangle rectangle2 = new Rectangle(3.5, 35.9);
        System.out.println("We create the second rectangle with width " + rectangle2.getWidth()
                + " and height " + rectangle2.getHeight()
        );
        System.out.println("Its area is " + rectangle2.getArea() + ", perimeter is " + rectangle2.getPerimeter());
    }
}
