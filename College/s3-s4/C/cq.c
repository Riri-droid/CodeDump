#include <stdio.h>
#define MAX 5
int cq[MAX];
int front = -1, rear = -1;

void enqueue() {
    int val;
    if ((front == 0 && rear == MAX - 1) || (rear + 1) % MAX == front) {
        printf("Circular Queue Overflow!\n");
        return;
    }
    printf("Enter element to enqueue: ");
    scanf("%d", &val);
    if (front == -1) {
        front = rear = 0;
    } else {
        rear = (rear + 1) % MAX;
    }
    cq[rear] = val;
    printf("%d enqueued.\n", val);
}
void dequeue() {
    if (front == -1) {
        printf("Circular Queue Underflow!\n");
        return;
    }
    printf("%d dequeued.\n", cq[front]);
    if (front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % MAX;
    }
}

void display() {
    if (front == -1) {
        printf("Circular Queue is empty.\n");
        return;
    }
    printf("Circular Queue elements: ");
    int i = front;
    while (1) {
        printf("%d ", cq[i]);
        if (i == rear) 
          break;
        i = (i + 1) % MAX;
    }
    printf("\n");
}
int main() {
    int choice;
    printf("---The stack size is 5---");
    do {        
        printf("\n*** CIRCULAR QUEUE MENU ***\n");
        printf("1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\n");
        printf("Enter choice:");
        scanf("%d", &choice);
        switch (choice) {
            case 1: 
            enqueue(); 
            break;
            case 2:
             dequeue(); 
             break;
            case 3: 
            display(); 
            break;
            case 4: 
            printf("exiting...");
            return 0;
            break;
            default: 
            printf("Invalid choice!\n");
            break;
        }
    }
    while (choice != 4);
   return 0;
}



