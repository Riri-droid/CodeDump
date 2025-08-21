#include<stdio.h>
#define MAX 100

int queue[MAX];
int front = -1, rear = -1;
int a;
void enqueue(int value) {
if (rear == MAX - 1) {
printf("Queue Overflow\n");
} else {
 if (front == -1) front = 0;
 queue[++rear] = value;
 printf("Enqueued %d\n", value);
}
}


void dequeue() {
if (front == -1 || front > rear) {
printf("Queue Underflow\n");
} else {
printf("Dequeued %d\n", queue[front++]);
if (front > rear) {

front = rear = -1;
}
}
}

void display() {
if (front == -1 || front > rear) {
printf("Queue is empty\n");
} else {
printf("Queue elements: ");
for (int i = front; i <= rear; i++) {
printf("%d ", queue[i]);
}
printf("\n");
}
}

int main() {
int choice, value;

do {
printf("---MENU---\n");
printf("1. Enqueue\n");
printf("2. Dequeue\n");
printf("3. Display\n");
printf("4. Exit\n");
printf("Enter your choice: ");
scanf("%d", &choice);

switch (choice) {
case 1:
printf("Enter how many elements: ");
scanf("%d",&a);
for(int i=0; i<a; i++)
{
 printf("Enter %d value to enqueue: ", i+1);
 scanf("%d", &value);
 enqueue(value);
}
break;
case 2:
dequeue();
break;
case 3:
display();
break;
case 4:
printf("Exiting program...\n");
break;
default:
printf("Invalid choice, try again\n");
break;
}
} while (choice != 4);

return 0;
}
