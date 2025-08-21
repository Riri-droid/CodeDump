#include <stdio.h>
#define MAX 5
int deque[MAX];
int front = -1, rear = -1;
void insertRear(int val) {
    if ((front == 0 && rear == MAX - 1) || (rear + 1) % MAX == front) {
        printf("Deque Overflow!\n");
        return;
    }
    if (front == -1) {
        front = rear = 0;
    } else {
        rear = (rear + 1) % MAX;
    }
    deque[rear] = val;
}
void insertFront(int val) {
    if ((front == 0 && rear == MAX - 1) || (rear + 1) % MAX == front) {
        printf("Deque Overflow!\n");
        return;
    }
    if (front == -1) {
        front = rear = 0;
    } else {
        front = (front - 1 + MAX) % MAX;
    }
    deque[front] = val;
}

void deleteFront() {
    if (front == -1) {
        printf("Deque Underflow!\n");
        return;
    }
    printf("%d deleted from front.\n", deque[front]);
    if (front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % MAX;
    }
}

void deleteRear() {
    if (front == -1) {
        printf("Deque Underflow!\n");
        return;
    }
    printf("%d deleted from rear.\n", deque[rear]);
    if (front == rear) {
        front = rear = -1;
    } else {
        rear = (rear - 1 + MAX) % MAX;
    }
}
void display() {
    if (front == -1) {
        printf("Deque is empty.\n");
        return;
    }
    int i = front;
    printf("Deque elements: ");
    while (1) {
        printf("%d ", deque[i]);
        if (i == rear) break;
        i = (i + 1) % MAX;
    }
    printf("\n");
}
int main() {
    int choice, val, type;
    printf("---Queue size is 5---");
    printf("Choose Deque Type:\n1. Input Restricted\n2. Output Restricted\n");
    printf("enter choice: ");
    scanf("%d", &type);
    while (1) {
        printf("\nMENU \n");
        if (type == 1) { 
            printf("1. Insert Rear\n2. Delete Front\n3. Delete Rear\n4. Display\n5. Exit\n");
            printf("enter choice: ");
            scanf("%d", &choice);
            switch (choice) {
                case 1: printf("Enter value: "); scanf("%d", &val); insertRear(val); break;
                case 2: deleteFront(); break;
                case 3: deleteRear(); break;
                case 4: display(); break;
                case 5: return 0;
                default: printf("Invalid choice!\n");
            }
        } else if (type == 2) { 
            printf("1. Insert Rear\n2. Insert Front\n3. Delete Front\n4. Display\n5. Exit\n");
            printf("enter choice: ");
            scanf("%d", &choice);
            switch (choice) {
                case 1: printf("Enter value: "); scanf("%d", &val); insertRear(val); break;
                case 2: printf("Enter value: "); scanf("%d", &val); insertFront(val); break;
                case 3: deleteFront(); break;
                case 4: display(); break;
                case 5: return 0;
                default:
                 printf("Invalid choice!\n");
            }
        } else {
            printf("Invalid type!\n");
            return 0;
        }
    }
}



