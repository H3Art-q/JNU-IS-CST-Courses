#include <stdio.h>
#include <string.h>
#define MAXNAME 30
#define MAXPHONE 15

struct TeleType {
    char name[MAXNAME];
    char phoneNum[MAXPHONE];
    struct TeleType* nextaddr;
};

void search(struct TeleType*, char*); /* function prototype */
int len_cmp(int, int);

int main()
{
    printf("If you want to search a phone number from someone in the current phone directory\n");
    printf("Please type in a name then press ENTER to continue:\n");
    char input[MAXNAME];
    memset(input, 0, sizeof(input));
    for (int i = 0; i < MAXNAME; i++) {
        scanf("%c", &input[i]);
        if (input[i] == '\n') {
            input[i] = '\0';
            break;
        }
    }

    struct TeleType t1 = { "Acme, Sam", "(555) 898 2392" };
    struct TeleType t2 = { "Dolan, Edith", "(555) 682 3104" };
    struct TeleType t3 = { "Lanfrank, John", "(555) 718 4581" };
    struct TeleType* first; /* create a pointer to a structure */

    first = &t1; /* store t1's address in first */
    t1.nextaddr = &t2; /* store t2's address in t1.nextaddr */
    t2.nextaddr = &t3; /* store t3's address in t2.nextaddr */
    t3.nextaddr = NULL; /* store the NULL address in t3.nextaddr */

    search(first, input); /* send the address of the first structure */
    return 0;
}

void search(struct TeleType* contents, char* search_name) /* contents is a pointer */
{ /* to a structure of type TeleType */
    while (contents != NULL) { /* search till end of linked list */
        if (!memcmp(search_name, contents->name, sizeof(char) * len_cmp(strlen(search_name), strlen(contents->name)))) {
            printf("His/Her phone number is %s.\n", contents->phoneNum);
            return;
        }
        contents = contents->nextaddr; /* get next address */
    }
    printf("The name is not in the current phone directory.\n");
    return;
}

int len_cmp(int len1, int len2)
{
    return len1 > len2 ? len1 : len2;
}