package lab8.chapter13;

public class ColorableTest {
    public static void main(String[] args) {
        GeometricObject[] geometricObjectsArray = new GeometricObject[5];

        geometricObjectsArray[0] = new Triangle();
        geometricObjectsArray[1] = new Square();
        geometricObjectsArray[2] = new Triangle("blue", true, 3, 4, 5);
        geometricObjectsArray[3] = new Square("red", false, 2);
        geometricObjectsArray[4] = new Square("green", false, 6);

        for (int i = 0; i < 5; i++) {
            System.out.printf("The %d geometric object's area is %f\n", i + 1, geometricObjectsArray[i].getArea());
            if (geometricObjectsArray[i] instanceof Colorable) {
                ((Colorable) geometricObjectsArray[i]).howToColor();
            }
            System.out.println();
        }
    }
}
