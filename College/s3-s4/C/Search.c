#include <stdio.h>

void LinearSearch(int arr[], int n, int ITEM);
void BinarySearch(int arr[], int n, int ITEM, int FIRST, int LAST);

int main() {
    int arr[1000], n, choice;
    int ITEM;
    int FIRST, LAST;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter item to be searched: ");
    scanf("%d", &ITEM);
    do{
    printf("\n--- MENU ---\n");
    printf("(1) Linear Search\n(2) Binary Search\n(3) Exit\n");
    printf("Select your choice: ");
    scanf("%d", &choice);
    
    switch (choice) {
        case 1:{
            LinearSearch(arr, n, ITEM);
            break;}

        case 2:{
            
            for(int i = 0; i < n - 1; i++) {
                for(int j = 0; j < n - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            
            
            printf("Sorted array: ");
            for (int i = 0; i < n; i++) {
                printf("%d ", arr[i]);
            }
            printf("\n");

            FIRST = 0;
            LAST = n - 1;
            BinarySearch(arr, n, ITEM, FIRST, LAST);
            break;}

        case 3:{
            printf("Exiting program...\n");
            break;}

        default:
           { printf("Invalid choice.\n");}
    }
    }
    while (choice!=3); 
     {
      return 0; }
}

void LinearSearch(int arr[], int n, int ITEM) {
    int LOC = -1;
    for (int i = 0; i < n; i++) {
        if (arr[i] == ITEM) {
            LOC = i;
            break;
        }
    }

    if (LOC != -1)
        printf("Item found at position %d\n", LOC + 1);
    else
        printf("Item not found in the array\n");
}

void BinarySearch(int arr[], int n, int ITEM, int FIRST, int LAST) {
    int MIDDLE;
    
    while (FIRST <= LAST) {
        MIDDLE = (FIRST + LAST) / 2;

        if (arr[MIDDLE] == ITEM) {
            printf("Item found at position %d\n", MIDDLE + 1);
            return;  
        } else if (arr[MIDDLE] > ITEM) {
            LAST = MIDDLE - 1;
        } else {
            FIRST = MIDDLE + 1;
        }
    }

    printf("Item not found in the array\n");
}

