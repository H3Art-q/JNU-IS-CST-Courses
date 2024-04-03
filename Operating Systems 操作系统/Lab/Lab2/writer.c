// C Program for Message Queue (Writer Process)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/msg.h>

#define MAX 10

// structure for message queue
struct mesg_buffer {
  long mesg_type;
  char mesg_text[10];
} message;

int main() {
  key_t key;
  int msgid;

  // ftok to generate unique key
  if ((key = ftok("writer.c", 65)) == -1) {
    perror("ftok");
    exit(1);
  }

  // msgget creates a message queue
  // and returns identifier
  msgid = msgget(key, 0666 | IPC_CREAT);
  message.mesg_type = 1;

  printf("Write Data : ");
  fgets(message.mesg_text, MAX, stdin);

  // msgsnd to send message
  // unsigned long length = strlen(message.mesg_text);
  msgsnd(msgid, &message, sizeof(message), 0);

  // display the message
  printf("Data send is : %s \n", message.mesg_text);

  return 0;
}