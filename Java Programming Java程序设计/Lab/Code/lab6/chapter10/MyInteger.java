package lab6.chapter10;
// 10.3

public class MyInteger {
    private final int value;

    MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isEven() {
        return this.value % 2 == 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isEven(MyInteger myInteger) {
        return myInteger.getValue() % 2 == 0;
    }

    public boolean isOdd() {
        return this.value % 2 == 1;
    }

    public static boolean isOdd(int num) {
        return num % 2 == 1;
    }

    public static boolean isOdd(MyInteger myInteger) {
        return myInteger.getValue() % 2 == 1;
    }

    public boolean isPrime() {
        if (this.value < 2 || this.isEven() && this.value != 2) {
            return false;
        }

        int limit = (int) Math.sqrt(this.value);
        for (int i = 3; i <= limit; i += 2) {
            if (this.value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int num){
        if (num < 2 || isEven(num) && num != 2) {
            return false;
        }

        int limit = (int) Math.sqrt(num);
        for (int i = 3; i <= limit; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(MyInteger myInteger){
        if (myInteger.getValue() < 2 || isEven(myInteger) && myInteger.getValue() != 2) {
            return false;
        }

        int limit = (int) Math.sqrt(myInteger.getValue());
        int value = myInteger.getValue();
        for (int i = 3; i <= limit; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(int num){
        return this.value == num;
    }

    public boolean equals(MyInteger myInteger){
        return this.value == myInteger.getValue();
    }

    public static int parseInt(char[] chArray){
        int positiveOrNegative = 1, result = 0;
        boolean isFirstCharacter = true;

        for(char ch:chArray){
            if (ch == '-' && isFirstCharacter){
                positiveOrNegative = -1;
            }else if(ch >= '0' && ch <= '9'){
                result = (result << 3) + (result << 1) + (ch ^ 48);
            }else {
                throw new IllegalArgumentException("Illegal character array");
            }
            isFirstCharacter = false;
        }

        return result * positiveOrNegative;
    }

    public static int parseInt(String string){
        return parseInt(string.toCharArray());
    }
}
