package lab4.chapter7;
// 7.13

public class RandomNumberChooser {
    public static int getRandom(int start, int end, int... numbers){
        boolean success = false;
        int random = 0;

        while(!success) {
            success = true;
            random = (int)((end - start) * Math.random() + start);
            for (int exclude : numbers) {
                if (random == exclude) {
                    success = false;
                    break;
                }
            }
        }

        return random;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 15; j++){
                System.out.printf("%4d", getRandom(1,100,4,8,95,93));
            }
            System.out.println();
        }
    }
}
