//
// Created by Lumos Nox on 11/11/2020.
//

#include <stdio.h>
#include <stdlib.h>
#include <winsock2.h>

#define BUFLEN 256

int main(int argc, const char * argv[]) {
    unsigned int s;
    struct sockaddr_in sin;
    int slen = sizeof(sin);
    char recvMsg[BUFLEN], sendMsg[BUFLEN];
    WSADATA wsaData;

    if (argc != 2) {
        printf("Usage: %s PORT\n", argv[0]);
        exit(1);
    }

    // Initialize Winsock
    if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) {
        printf("WSAStartup() failed: %d\n", WSAGetLastError());
        exit(1);
    }

    // Create socket
    if ((s = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)) == INVALID_SOCKET) {
        printf("socket() failed: %d\n", WSAGetLastError());
        WSACleanup();
        exit(1);
    }

    // Setup address structure
    memset((char *) &sin, 0, sizeof(sin));
    sin.sin_family = AF_INET;
    sin.sin_addr.s_addr = INADDR_ANY;
    sin.sin_port = htons((unsigned short) atoi(argv[1]));

    // Bind
    if (bind(s, (struct sockaddr *) &sin, sizeof(sin)) == SOCKET_ERROR) {
        printf("bind() failed: %d\n", WSAGetLastError());
        closesocket(s);
        WSACleanup();
        exit(1);
    }

    while (1) {
        memset(recvMsg, '\0', BUFLEN);
        if (recvfrom(s, recvMsg, BUFLEN, 0, (struct sockaddr *) &sin,
                &slen) == SOCKET_ERROR) {
            printf("recvfrom() failed: %d\n", WSAGetLastError());
            closesocket(s);
            WSACleanup();
            exit(1);
        }
        printf("MESSAGE [%s] FROM [%s:%d]\n", recvMsg,
               inet_ntoa(sin.sin_addr), ntohs(sin.sin_port));

        if (strcmp(recvMsg, "bye") == 0) break;

        memset(sendMsg, '\0', BUFLEN);
        strcpy(sendMsg, "I RECEIVED \"");
        strcpy(sendMsg + strlen(sendMsg), recvMsg);
        strcpy(sendMsg + strlen(sendMsg), "\"");
        if (sendto(s, sendMsg, strlen(sendMsg), 0,
                   (struct sockaddr *) &sin, slen) == SOCKET_ERROR) {
            printf("sendto() failed: %d\n", WSAGetLastError());
            closesocket(s);
            WSACleanup();
            exit(1);
        }
    }

    closesocket(s);
    WSACleanup();

    return 0;
}
