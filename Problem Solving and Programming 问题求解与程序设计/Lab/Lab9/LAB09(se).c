#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define CLK_TCK 1000
int main()
{
    FILE* fp;
    if ((fp = fopen("test.txt", "r")) == NULL) {
        printf("The file is not open correctly.\n");
        printf("Please check that the file exists\n");
        exit(1);
    } else {
        clock_t start = clock();
        while (1) {
            if ((clock() - start) == CLK_TCK) {
                char character = getc(fp);
                if (character == -1) {
                    break;
                }
                putc(character, stdout);
                start = clock();
            }
        }
        printf("\n");
    }
    return 0;
}