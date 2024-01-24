// Dragon Curve Instructions
// d(n) = d(n-1) + 'L' + r(n-1)
// @ Max, March 2020

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void main (int argc, char* argv[]) {
   int n = atoi( argv[1] );
   char s[(int)pow(2, n+1)];  
   // length(d(n)) = 1 + 2^1 + 2^2... + 2^n = 2^(n+1)-1

   s[0] = 'F';       // d(0) 
   int M = 1;
   for (int i = 1; i <= n; i++) {
      // d(i-1) in s[0..M)
      s[M] = 'L';    // concat a 'L'
      int M2 = M + M;
      for (int k = M-1; k >= 0; k--)    //  concat r(i-1)
         s[M2 - k] =                    // reverse d(i-1)
            s[k] == 'F' ? 'F' : (s[k] == 'L' ? 'R' : 'L');
      M = M2 + 1;
      // d(i) in s[0..M)
   }
   // d(n) in s[0..M)
   s[M] = '\0';      // end the string

   printf( "%s\n", s );
}
