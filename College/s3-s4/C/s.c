#include <stdio.h>
#define MAX 100

int stack[MAX];
int top = -1;

void push(int value) {
    if (top >= MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = value;
    printf("%d pushed onto the stack.\n", value);
}

void pop() {
    if (top < 0) {
        printf("Stack Underflow\n");
        return;
    }
    printf("%d popped from the stack.\n", stack[top--]);
}

void display() {
    if (top < 0) {
        printf("Stack is empty.\n");
        return;
    }
    printf("Current stack elements:\n");
    for (int i = top; i >= 0; i--) {
        printf("%d ", stack[i]);
    }
}

int main() {
    int option;

    do {
        printf("\n---MENU---\n");
        printf("1. Push\n2. Pop\n3. Display\n4. Exit\n");
        printf("Select an option: ");
        scanf("%d", &option);

        switch (option) {
            case 1: {
                int count, val;
                printf("How many elements would you like to push?:  ");
                scanf("%d", &count);
                for (int i = 0; i < count; i++) {
                    printf("Enter element %d: ", i + 1);
                    scanf("%d", &val);
                    push(val);
                }
                break;
            }
            case 2:
                pop();
                break;
            case 3:
                display();
                break;
            case 4:
                printf("Exiting...\n");
                break;
            default:
                printf("Wrong option, Try again\n");
        }
    } while (option != 4);

    return 0;
    }
