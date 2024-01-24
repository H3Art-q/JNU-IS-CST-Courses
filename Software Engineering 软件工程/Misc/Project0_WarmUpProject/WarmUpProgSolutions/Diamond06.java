// Thanks to Mr. Z for the elegant design.
import static java.lang.Math.*;
public class Diamond06 {  
   public static void main (String[] args) {
      final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
      int N = args.length > 0 ? Integer.parseInt( args[0] ) : 9;
      for (int i = 0; i <= 2*N; i++) {
         int L = N + (i<=N ? i : 2*N-i);
         for (int j = 0; j <= L; j++)
            System.out.print(
               abs(j-N) + abs(i-N) <= N ? 
               DIGITS.charAt(abs(j-N)) + (j==L ? "\n" : ".") : 
               ".."
            );
      }
   }
}
