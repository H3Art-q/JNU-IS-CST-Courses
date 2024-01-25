package lab3.chapter6;
// 6.11

public class CommissionCalculator {
    public static double computeCommission(double salesAmount){
        double commission;
        if(salesAmount > 10000){
            commission = (salesAmount - 10000) * 0.12 + 900;
        }else if(salesAmount > 5000){
            commission = (salesAmount - 5000) * 0.1 + 400;
        }else {
            commission = salesAmount * 0.08;
        }
        return commission;
    }

    public static void displayTable(int minAmount, int maxAmount, int offset){
        System.out.println("Sales Amount\t\tCommission");
        for(int amount = minAmount; amount <= maxAmount; amount += offset){
            System.out.println(amount + "\t\t\t\t" + computeCommission(amount));
        }
    }

    public static void main(String[] args) {
        displayTable(10000, 100000, 5000);
    }
}
