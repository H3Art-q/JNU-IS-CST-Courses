#include <stdio.h>

#define MAXSTAGE 9

void printLine(int stage) {
    /* Calculate and output the SPACE */
    for (int i = 0; i < stage * 2; i++) {
        printf("%c", ' ');
    }
    /* Calculate and output the numbers */
    for (int i = MAXSTAGE - stage; i >= stage - MAXSTAGE; i--) {
        printf("%d ", i >= 0 ? i : -i);
    }
    printf("\n");
}

int main(int argc, char* argv[]) {
    for (int i = MAXSTAGE; i >= -MAXSTAGE; i--) {
        printLine(i > 0 ? i : -i);
    }
    return 0;
}