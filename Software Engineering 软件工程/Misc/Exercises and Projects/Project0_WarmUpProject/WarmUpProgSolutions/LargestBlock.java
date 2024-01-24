public class LargestBlock {
   public static void main (String[] args) {
      int[][] a = {
         { 1, 0, 1, 0, 1 },
         { 1, 1, 1, 0, 1 },
         { 1, 0, 1, 1, 1 },
         { 1, 0, 1, 1, 1 },
         { 1, 0, 1, 1, 1 }
      };            
      outputMatrix( a, "a[][]:" );
      
      int[][] s = findAllBlocks( a );
      outputMatrix( s, "s[][]:" );
      
      outputLargestBlock( s );
   }
         
   public static void outputLargestBlock (int[][] b) {
      final int N = b.length;
      int maxBlockSize = 0;
      for (int r = 0; r < N; r++)
         for (int c = 0; c < N; c++)
            if (maxBlockSize < b[r][c]) maxBlockSize = b[r][c];

      System.out.print( "The maximum square submatrix is at" ); 
      for (int r = 0; r < N; r++)
         for (int c = 0; c < N; c++)
            if (b[r][c] == maxBlockSize)
               System.out.printf( " (%d, %d)", r, c );
      System.out.printf( " with size %d\n", maxBlockSize ); 
   }
   
   public static void outputMatrix (int[][] a, String tips) {
      System.out.println( tips );
      for (int r = 0; r < a.length; r++)
         System.out.println( java.util.Arrays.toString( a[r] ) );
   }

   public static int[][] findAllBlocks (int[][] a) {
      final int N = a.length;
      int[][] s = new int[N][N];
      for (int c = N-1; c >= 0; c--)
         s[N-1][c] = a[N-1][c];    // last row
      for (int r = N-2; r >= 0; r--)
         s[r][N-1] = a[r][N-1];    // last column
  
      for (int r = N-2; r >= 0; r--)
         for (int c = N-2; c >= 0; c--)
            s[r][c] = a[r][c]==0 ? 0 :
                      1 + min(s[r][c+1], s[r+1][c], s[r+1][c+1]);
      return s;                
   }   

   public static int min (int a, int b, int c) {
      return Math.min(a, Math.min(b,c));
   }
}

