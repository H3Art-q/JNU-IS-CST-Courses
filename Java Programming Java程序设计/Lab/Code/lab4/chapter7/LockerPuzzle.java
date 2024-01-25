package lab4.chapter7;
// 7.23

public class LockerPuzzle {
    private static int TOTAL = 100;

    private static boolean[] locker = new boolean[TOTAL];

    public static void main(String[] args) {
        for (int student = 1; student <= TOTAL; student++) {
            for (int position = student - 1; position < TOTAL; position += student){
                locker[position] = !locker[position];
            }
        }

        for (int denote = 0; denote < TOTAL; denote++){
            if(locker[denote]){
                System.out.print(denote + 1);
                System.out.print(" ");
            }
        }

    }
}
