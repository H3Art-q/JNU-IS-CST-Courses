#include <stdio.h>
struct Student {
    char name[20];
    long long studId;
    char gender;
    union Body {
        char eye;
        struct {
            int height;
            int weight;
        } f;
    } body;
} stud[2];

int main()
{
    printf("Input format: Name Student ID Gender(M / F).\n");
    printf("Then, if Gender is M(Male), you need to type in his eyesight(Y / N),\n");
    printf("else you need to type in her height and weight.\n");
    for (int i = 0; i < 2; i++) {
        scanf("%s%10lld", stud[i].name, &stud[i].studId);
        do {
            stud[i].gender = getchar();
        } while (stud[i].gender != 'M' && stud[i].gender != 'F');
        if (stud[i].gender == 'M') {
            do {
                stud[i].body.eye = getchar();
            } while (stud[i].body.eye != 'Y' && stud[i].body.eye != 'N');
        } else {
            scanf("%d%d", &stud[i].body.f.height, &stud[i].body.f.weight);
        }
    }
    printf("\nThe students information is as follow:\n");
    for (int i = 0; i < 2; i++) {
        printf("Name:%22s\n", stud[i].name);
        printf("Student ID: %5c%010lld\n", ' ', stud[i].studId);
        if (stud[i].gender == 'M') {
            printf("Gender:%20s\n", "Male");
            if (stud[i].body.eye == 'Y') {
                printf("Eyesight: %17s\n", "Normal");
            } else {
                printf("Eyesight: %17s\n", "Abnormal");
            }
        } else {
            printf("Gender:%20s\n", "Female");
            printf("Height:%18dcm\n", stud[i].body.f.height);
            printf("Weight:%18dkg\n", stud[i].body.f.weight);
        }
        printf("\n");
    }
    return 0;
}