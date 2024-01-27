#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>

#define BUFLEN 256

int main(int argc, const char * argv[]) {
    int s;
    struct sockaddr_in sin;
    socklen_t slen = sizeof(sin);
    char recvMsg[BUFLEN], sendMsg[BUFLEN];

    if (argc != 2) {
        printf("Usage: %s PORT\n", argv[0]);
        exit(1);
    }

    // Create socket
    if ((s = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)) == -1) {
        perror("socket failed");
        exit(1);
    }

    // Setup address structure
    memset((char *) &sin, 0, sizeof(sin));
    sin.sin_family = AF_INET;
    sin.sin_addr.s_addr = htonl(INADDR_ANY);
    sin.sin_port = htons((unsigned short) atoi(argv[1]));

    // Bind
    if (bind(s, (struct sockaddr *) &sin, sizeof(sin)) == -1) {
        perror("bind failed");
        close(s);
        exit(1);
    }

    while (1) {
        memset(recvMsg, '\0', BUFLEN);
        if (recvfrom(s, recvMsg, BUFLEN, 0, (struct sockaddr *) &sin,
                &slen) == -1) {
            perror("recvfrom failed");
            close(s);
            exit(1);
        }
        printf("MESSAGE [%s] FROM [%s:%d]\n", recvMsg,
               inet_ntoa(sin.sin_addr), ntohs(sin.sin_port));

        if (strcmp(recvMsg, "bye") == 0) break;

        memset(sendMsg, '\0', BUFLEN);
        snprintf(sendMsg, BUFLEN, "I RECEIVED \"%s\"", recvMsg);
        if (sendto(s, sendMsg, strlen(sendMsg), 0,
                   (struct sockaddr *) &sin, slen) == -1) {
            perror("sendto failed");
            close(s);
            exit(1);
        }
    }

    close(s);

    return 0;
}
