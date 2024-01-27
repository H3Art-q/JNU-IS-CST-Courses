#include <stdio.h>
#include <sys/time.h>
#include <winsock2.h>

//#define DST "192.168.1.177"
//#define DST "192.168.1.177"
#define PACKETSIZE 4096

typedef struct icmp {
    unsigned char type;
    unsigned char code;
    unsigned short checksum;
    unsigned short id;
    unsigned short sequence;
    unsigned long origTimestamp;
    unsigned long rxTimestamp;
    unsigned long txTimestamp;
} icmpHdr;

unsigned short csum(unsigned short *buf, int size);
int craftICMP(icmpHdr *icmph);

int main(int argc, const char * argv[]) {
    struct sockaddr_in dest;
    unsigned int s;
    char packet[PACKETSIZE];
    icmpHdr *icmph = (icmpHdr *) packet;
    WSADATA wsaData;

	if (argc != 2)
    {
        printf("usage: %s dstIP", argv[0]);
        return -1;
    }
	
    // Initialize Winsock
    if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) {
        printf("WSAStartup() failed: %d\n", WSAGetLastError());
        exit(1);
    }

    // Create socket
    if ((s = socket(AF_INET, SOCK_RAW, IPPROTO_ICMP)) == SOCKET_ERROR) {
        printf("socket() failed: %d\n", WSAGetLastError());
        exit(1);
    }

	printf("Send ICMP Timestamp to: %s", argv[1]);
	
    // Setup address structure
    memset((char *) &dest, 0, sizeof(dest));
    dest.sin_family = AF_INET;
    dest.sin_port = htons(0);
    dest.sin_addr.S_un.S_addr = inet_addr(argv[1]);

    // Craft ICMP
    memset(packet, 0, PACKETSIZE);
    int len = craftICMP(icmph);

    if (sendto(s, packet, len, 0,
               (struct sockaddr *) &dest, sizeof(dest)) < 0) {
        printf("sendto() failed: %d\n", WSAGetLastError());
        exit(1);
    }

    closesocket(s);
    WSACleanup();

    return 0;
}

unsigned short csum(unsigned short *buf, int size) {
    unsigned long cksum = 0;
    while (size > 1) {
        cksum += *buf ++;
        size -= sizeof(unsigned short);
    }
    if (size) cksum += *(char *) buf;
    cksum = (cksum >> 16) + (cksum & 0xffff);
    cksum += (cksum >> 16);
    return (unsigned short) (~cksum);
}

int craftICMP(icmpHdr *icmph) {
    icmph->type = 13; // Timestamp
    icmph->code = 0;
    icmph->checksum = 0;
    icmph->id = 0;
    icmph->sequence = 0;

    struct timespec ts;
    clock_gettime(CLOCK_REALTIME, &ts);
    int msec = ((ts.tv_sec % 86400) * 1000 + ts.tv_nsec / 1000000);

    icmph->origTimestamp = htonl(msec);
    icmph->rxTimestamp = 0;
    icmph->txTimestamp = 0;

    icmph->checksum = csum((unsigned short *) icmph, sizeof(icmpHdr));

    return sizeof(icmpHdr);
}
