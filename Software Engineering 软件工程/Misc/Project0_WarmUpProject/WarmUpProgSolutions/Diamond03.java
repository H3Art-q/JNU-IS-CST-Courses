public class Diamond03 {   // Diamond03.java
   public static void main (String[] args) {
      int N = args.length > 0 ? Integer.parseInt( args[0] ) : 9;
      String diamond = "";
      for (int i = 0; i <= N; i++)
         diamond += blanks( 2 * (N-i) ) + mirrorDigits( i ) + "\n";
      for (int i = N-1; i >= 0; i--)
         diamond += blanks( 2 * (N-i) ) + mirrorDigits( i ) + "\n";
     System.out.print( diamond );  
   }
   public static String blanks (int n) {
      String s = "";
      while (n-- > 0) s += " ";
      return s;
   }
   public static final String DIGITS = 
      "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //constant like Math.PI
   public static String mirrorDigits (int n) {
      String s = "0";
      for (int i = 1; i <= n; i++) {
         char c = DIGITS.charAt(i);
         s = c + " " + s + " " + c;
      }
      return s;
   }  
}
