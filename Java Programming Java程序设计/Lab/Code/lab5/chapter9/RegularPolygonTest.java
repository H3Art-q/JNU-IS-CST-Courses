package lab5.chapter9;

public class RegularPolygonTest {
    public static void main(String[] args) {
        RegularPolygon regularPolygon1 = new RegularPolygon();
        System.out.println("We create the first polygon with " + regularPolygon1.getN() + " sides");
        System.out.println("Its side has length " + regularPolygon1.getSide());
        System.out.println("Its area is " + regularPolygon1.getArea() + ", perimeter is "
                + regularPolygon1.getPerimeter());
        System.out.println();

        RegularPolygon regularPolygon2 = new RegularPolygon(6, 4);
        System.out.println("We create the second polygon with " + regularPolygon2.getN() + " sides");
        System.out.println("Its side has length " + regularPolygon2.getSide());
        System.out.println("Its area is " + regularPolygon2.getArea() + ", perimeter is "
                + regularPolygon2.getPerimeter());
        System.out.println();

        RegularPolygon regularPolygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println("We create the third polygon with " + regularPolygon3.getN() + " sides");
        System.out.println("Its side has length " + regularPolygon3.getSide());
        System.out.println("Its area is " + regularPolygon3.getArea() + ", perimeter is "
                + regularPolygon3.getPerimeter());
    }
}
