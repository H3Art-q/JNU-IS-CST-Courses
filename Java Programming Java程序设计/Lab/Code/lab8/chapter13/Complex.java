package lab8.chapter13;

// 13.17
public class Complex implements Comparable<Complex>, Cloneable {
    private final double a;
    private final double b;

    protected Complex() {
        this.a = 0;
        this.b = 0;
    }

    protected Complex(double a) {
        this.a = a;
        this.b = 0;
    }

    protected Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

    public Complex add(Complex obj) {
        return new Complex(a + obj.a, b + obj.b);
    }

    public Complex subtract(Complex obj) {
        return new Complex(a - obj.a, b - obj.b);
    }

    public Complex multiply(Complex obj) {
        return new Complex(a * obj.a - b * obj.b, b * obj.a + a * obj.b);
    }

    public Complex divide(Complex obj) {
        return new Complex(
                (a * obj.a + b * obj.b) / (obj.a * obj.a + obj.b * obj.b),
                (b * obj.a - a * obj.b) / (obj.a * obj.a + obj.b * obj.b)
        );
    }

    public double abs() {
        return Math.sqrt(a * a + b * b);
    }

    @Override
    public int compareTo(Complex obj) {
        return Double.compare(this.abs(), obj.abs());
    }

    @Override
    public Complex clone() {
        try {
            return (Complex) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        if (b != 0)
            return String.format("(%f + %fi)", a, b);
        else
            return String.valueOf(a);
    }
}
