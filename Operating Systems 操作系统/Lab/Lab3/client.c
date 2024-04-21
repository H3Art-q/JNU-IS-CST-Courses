#include <arpa/inet.h> // For inet_addr()
#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <unistd.h> // For Unix/Linux system function: read()/write()/close()

#define MAX 80
#define PORT 8080
#define SA struct sockaddr

void func(int sockfd) {
  char buff[MAX];
  int n;
  for (;;) {
    bzero(buff, sizeof(buff));
    printf("Enter the string : ");
    n = 0;

    // Read data from stdin and write them into client's buffer
    while ((buff[n++] = getchar()) != '\n')
      ;
    // Send the data from buffer to socket
    write(sockfd, buff, sizeof(buff));
    // Clear the buffer
    bzero(buff, sizeof(buff));
    // Read data from socket and store them into client's buffer
    read(sockfd, buff, sizeof(buff));
    printf("From server: %s", buff);

    if ((strncmp(buff, "exit", 4)) == 0) {
      printf("Client Exit...\n");
      break;
    }
  }
}

int main() {
  int sockfd;
  struct sockaddr_in servaddr;

  // socket create and varification
  // Use IPV4(AF_INET), TCP mode(SOCK_STREAM) and IP protocol(0)
  // to create a sockfd(socket file descriptor)
  sockfd = socket(AF_INET, SOCK_STREAM, 0);
  if (sockfd == -1) {
    printf("socket creation failed...\n");
    exit(0);
  } else
    printf("Socket successfully created..\n");

  // bzero() == memset(addr, 0, size_t)
  bzero(&servaddr, sizeof(servaddr));

  // assign IP, PORT
  servaddr.sin_family = AF_INET;
  servaddr.sin_addr.s_addr = inet_addr("127.0.0.1");
  servaddr.sin_port = htons(PORT);

  // connect the client socket to server socket
  if (connect(sockfd, (SA *)&servaddr, sizeof(servaddr)) != 0) {
    printf("connection with the server failed...\n");
    exit(0);
  } else
    printf("connected to the server..\n");

  // function for chat
  func(sockfd);

  // close the socket
  close(sockfd);

  return 0;
}
