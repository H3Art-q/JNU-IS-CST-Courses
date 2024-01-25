package lab1.chapter1;

public class Rectangle {
    private final double width = 4.5;
    private final double height = 7.9;

    public static void main(String[] args) {
        Rectangle obj = new Rectangle();
        System.out.println("The area = width * height = " + obj.width * obj.height);
        System.out.println("The perimeter = 2 * (width + height) = " + 2 * (obj.width + obj.height));
    }
}
