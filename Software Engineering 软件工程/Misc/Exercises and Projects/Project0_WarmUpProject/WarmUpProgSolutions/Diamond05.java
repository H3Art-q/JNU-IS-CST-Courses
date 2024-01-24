// Thanks to Mr. Z for the elegant design.
public class Diamond05 {   // Diamond05.java
   public static void main (String[] args) {
      for (int i = 0; i <= 18; i++) 
         for (int j = 0; j <= 18; j++)
            System.out.print(
               Math.abs(j-9) + Math.abs(i-9) <= 9 ? 
               Math.abs(j-9) + (j==18 ? "\n" : ".") :
               j==18 ? "\n" : ".."
            );
   }
}
