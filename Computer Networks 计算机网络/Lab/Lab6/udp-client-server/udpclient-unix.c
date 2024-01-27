#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>

#define BUFLEN 256 // Send at most 255 characters

int main(int argc, const char * argv[]) {
    int s;
    struct sockaddr_in dest;
    socklen_t slen = sizeof(dest);
    char sendMsg[BUFLEN], recvMsg[BUFLEN];
    int broadcast = 1;

    if (argc != 3) {
        printf("Usage: %s IP PORT\n", argv[0]);
        exit(1);
    }

    // Create socket
    if ((s = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)) == -1) {
        perror("socket failed");
        exit(1);
    }
    
    // Enable broadcast
    if (setsockopt(s, SOL_SOCKET, SO_BROADCAST, &broadcast, sizeof(broadcast)) < 0) {
        perror("setsockopt (SO_BROADCAST)");
        close(s);
        exit(1);
    }

    // Setup address structure
    memset((char *) &dest, 0, sizeof(dest));
    dest.sin_family = AF_INET;
    dest.sin_addr.s_addr = inet_addr(argv[1]);
    dest.sin_port = htons((unsigned short) atoi(argv[2]));

    while (1) {
        printf("MESSAGE: ");
        fgets(sendMsg, BUFLEN, stdin);
        sendMsg[strcspn(sendMsg, "\n")] = 0; // Remove newline character

        if (strlen(sendMsg) > BUFLEN - 14) {
            printf("MESSAGE TOO LONG\n");
            break;
        }
        if (sendto(s, sendMsg, strlen(sendMsg), 0,
                   (struct sockaddr *) &dest, slen) == -1) {
            perror("sendto failed");
            close(s);
            exit(1);
        }

        if (strcmp(sendMsg, "bye") == 0) break;

        memset(recvMsg, '\0', BUFLEN);
        if (recvfrom(s, recvMsg, BUFLEN, 0,
                     (struct sockaddr *) &dest, &slen) == -1) {
            perror("recvfrom failed");
            close(s);
            exit(1);
        }
        printf("REPLY [%s]\n\n", recvMsg);
    }

    close(s);

    return 0;
}
