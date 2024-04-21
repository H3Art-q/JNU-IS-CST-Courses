// C Program for Message Queue (Reader Process)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/msg.h>

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

  // msgrcv to receive message
  msgrcv(msgid, &message, sizeof(message), 1, 0);

  // display the message
  printf("Data Received is : %s \n", message.mesg_text);

  // to destroy the message queue
  msgctl(msgid, IPC_RMID, NULL);

  return 0;
}
