#include <stdio.h>
#include <string.h>
#define NUM 10
typedef struct data {
    char name[20];
    int age;
} data;

void sort_name(data* pers, int len)
{
    // BubbleSort
    for (int i = 0; i < len - 1; i++) {
        for (int j = 0; j < len - 1 - i; j++) {
            if (strcmp(pers[j].name, pers[j + 1].name) > 0) {
                data temp = pers[j];
                pers[j] = pers[j + 1];
                pers[j + 1] = temp;
            }
        }
    }
    return;
}

void sort_age(data* pers, int len)
{
    // SelectionSort
    for (int i = 0; i < len - 1; i++) {
        int maxage = pers[i].age, rec_index = i;
        for (int j = i + 1; j < len; j++) {
            if (pers[j].age < maxage) {
                maxage = pers[j].age;
                rec_index = j;
            }
        }
        data temp = pers[i];
        pers[i] = pers[rec_index];
        pers[rec_index] = temp;
    }
    return;
}

int main()
{
    data person[NUM] = {
        "Michael", 18,
        "David", 16,
        "Johnson", 22,
        "Ben", 18,
        "Steve", 25,
        "Amy", 15,
        "Hart", 17,
        "Zxh", 13,
        "Cathy", 9,
        "Lee", 21
    };
    printf("These person datas sorted by age in increasing sequence are as follows.\n");
    sort_age(person, NUM);
    for (int i = 0; i < 10; i++) {
        printf("Name: %-10s Age: %3d\n", person[i].name, person[i].age);
    }
    sort_name(person, NUM);
    printf("These person datas sorted by name in increasing sequence are as follows.\n");
    for (int i = 0; i < 10; i++) {
        printf("Name: %-10s Age: %3d\n", person[i].name, person[i].age);
    }
    return 0;
}