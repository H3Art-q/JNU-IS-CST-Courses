public class Diamond04 {   // Diamond04.java
   public static void main (String[] args) {
      int N = args.length > 0 ? Integer.parseInt( args[0] ) : 9;
      String diamond = "";
      for (int line = 0; line <= 2*N; line++) {
         int i = line <= N ? line : 2*N - line;
         diamond += blanks( 2*(N-i) ) + mirrorDigits( i ) + "\n";
      }
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
