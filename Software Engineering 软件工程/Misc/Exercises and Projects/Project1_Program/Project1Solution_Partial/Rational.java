/*
 * Max @ April, 2017
 * Refactered on Dec 4, 2017
 * Refactered on Nov 4, 2018
 * Refactered on April 20, 2019
 */
public class Rational {
   private int num;   // numerator   分子
   private int den;   // denominator 分母
   
   public static void main (String[] args) {
      Rational r1 = new Rational( 1, 2);
      Rational r2 = new Rational( 1, 3);
      System.out.printf( "%s + %s = %s\n", r1, r2, r1.plus( r2) );
      System.out.printf( "%s - %s = %s\n", r2, r1, r2.minus( r1) );
      System.out.printf( "%s * %s = %s\n", r1, r2, r1.times( r2) );
      // call .toString(), One kind of Arguments Type Promotion. 

      Rational r3 = new Rational( 1, 1, 6);
      Rational r4 = new Rational( 2, 3);
      Rational r5 = r3.divides( r4);
      System.out.printf( "%s / %s = %s\n", r3, r4, r5 );
      System.out.printf( "%s = %s\n", r5, r5.floatString());
      System.out.printf( "%s = %s\n", r5, r5.floatString(6));
   }
    
   public Rational () {
      num = 0;
      den = 1;
   }
    
   public Rational (int num, int den) {
      this.num = num;
      this.den = den;     // den > 0
      normalize();
   }

   public Rational (int integral, int num, int den) {
      this( integral * den + num, den );
   }

   private void normalize () {
      int absNum = Math.abs( num );
      int gcd = greatestCommonDivisor( absNum, den);
      num /= gcd;
      den /= gcd;
   }

   // jhtp8, p185, Exe 6.24, Euclid's Algorithm.       
   public static int greatestCommonDivisor (int a, int b) {  
      while (true) {        // 1/2+ Loop            
         int m = a % b;
         
         if (m == 0) return b;
         
         a = b;
         b = m;
      }  
   }  // What about a < b ?
   
   public Rational plus (Rational r) {
      int gcd = greatestCommonDivisor( den, r.den);
      int theNum = r.den / gcd * num + den / gcd * r.num;  
      int theDen = den / gcd * r.den;
      return new Rational( theNum, theDen);
   }
   
   public Rational minus (Rational r) {
      int gcd = greatestCommonDivisor( den, r.den);
      int theNum = r.den / gcd * num - den / gcd * r.num;  
      int theDen = den / gcd * r.den;
      return new Rational( theNum, theDen);
   }

   public Rational times (Rational r) {
      int theNum = num * r.num;
      int theDen = den * r.den;
      return new Rational( theNum, theDen);
   }

   public Rational divides (Rational r) {
      int theNum = num * r.den;
      int theDen = den * r.num;
      return new Rational( theNum, theDen);
   }

   public int    intValue ()       { return num / den; }
   public double doubleValue ()    { return num / (double)den; }
   public int    getNumerator ()   { return num; }
   public int    getDenominator () { return den; }

   public String toString () {
      if (den == 1 || num == 0) return "" + num ;
      String s = "";
      int absNum = Math.abs( num );
      int integral = absNum / den;
      if (integral == 0) return num + "|" + den ;
      if (num < 0) s = "-";
      s = s + integral;
      int module = absNum % den;
      if (module == 0) return s;
      return s + "_" + module + "|" + den ;
   }

   public String floatString (int... digits) {
      return (digits.length == 0) ? "" + doubleValue() :
         String.format( String.format("%%.%df", digits[0]), doubleValue());
   }                //  String.format("%%.%df", 6) ==> %.6f
}

