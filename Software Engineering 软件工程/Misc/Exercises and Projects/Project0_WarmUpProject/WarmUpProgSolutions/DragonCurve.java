// Dragon Curve Instructions
// d(n) = d(n-1) + "L" + r(n-1)
// r(n) = d(n-1) + "R" + r(n-1)
// @ Max, March 2020

public class DragonCurve {
   public static void main (String[] args) {
      int n = Integer.parseInt( args[0] );
      System.out.println( instructions( n ) );
   }

   public static String instructions (int n) {
      String d = "F", r = "F";
      for (int i = 1; i <= n; i++) {
         String d_ = d, r_ = r;
         d = d_ + "L" + r_;
         r = d_ + "R" + r_;
      }
      return d;
   }
}
