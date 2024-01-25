package lab6.chapter10;

public class MyRectangle2DTest {
    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);

        System.out.println("The area of r1 is " + r1.getArea() + " and its perimeter is " + r1.getPerimeter());

        System.out.println("r1 contains point(3, 3): " + r1.contains(3, 3));

        System.out.println("r1 contains MyRectangle2D(4, 5, 10.5, 3.2): " +
                r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));

        System.out.println("r1 overlaps MyRectangle2D(3, 5, 2.3, 5.4): " +
                r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }
}
