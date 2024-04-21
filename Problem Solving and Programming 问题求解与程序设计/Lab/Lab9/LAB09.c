#include <stdio.h>
#include <stdlib.h>
int main()
{
    FILE* fp;
    if ((fp = fopen("test.dat", "r")) == NULL) {
        printf("The file is not open correctly.\n");
        printf("Please check that the file exists\n");
        exit(1);
    } else {
        int i = 1;
        printf("Every second character in a file shows as follow:\n");
        while (1) {
            fseek(fp, i, SEEK_SET);
            char character = getc(fp);
            if (character == -1) {
                break;
            } else {
                putc(character, stdout);
            }
            i += 2;
        }
        printf("\n");
    }
    fclose(fp);
    return 0;
}