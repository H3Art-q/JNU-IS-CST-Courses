// Thanks to Mr. Z for the elegant design.
public class Diamond052 {   
   public static void main (String[] args) {
      for (int i = 0; i <= 18; i++) {
         int L = 9 + (i<=9 ? i : 18-i);
         for (int j = 0; j <= L; j++)
            System.out.print(
               Math.abs(j-9) + Math.abs(i-9) <= 9 ? 
               Math.abs(j-9) + (j==L ? "\n" : ".") :
               ".."
            );
      }
   }
}
