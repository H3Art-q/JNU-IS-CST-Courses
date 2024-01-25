package lab5.chapter9;
// 9.13

public class Location {
    public int row;
    public int column;
    public double maxValue;

    Location(){
        this.row = 0;
        this.column = 0;
        this.maxValue = Double.MIN_VALUE;
    }
}
