#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

#define SIZE 100

char stack[SIZE];
int top = -1;

int valueStack[SIZE];
int valueTop = -1;

void push(char ch) {
    stack[++top] = ch;
}

char pop() {
    if (top == -1)
        return -1;
    return stack[top--];
}

char peek() {
    if (top == -1)
        return -1;
    return stack[top];
}

void pushVal(int val) {
    valueStack[++valueTop] = val;
}

int popVal() {
    return valueStack[valueTop--];
}

int precedence(char op) {
    if (op == '^')
        return 3;
    else if (op == '*' || op == '/')
        return 2;
    else if (op == '+' || op == '-')
        return 1;
    else
        return 0;
}

int isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
}

int power(int base, int exp) {
    int result = 1;
    for (int i = 0; i < exp; i++) {
        result *= base;
    }
    return result;
}

void infixToPostfix(char infix[], char postfix[]) {
    int i = 0, k = 0;
    char ch;

    while (infix[i] != '\0') {
        ch = infix[i];

        if (isdigit(ch)) {
            while (isdigit(infix[i])) {
                postfix[k++] = infix[i++];
            }
            postfix[k++] = ' ';
            continue;
        } else if (ch == '(') {
            push(ch);
        } else if (ch == ')') {
            while (peek() != '(')
                postfix[k++] = pop(), postfix[k++] = ' ';
            pop();
        } else if (isOperator(ch)) {
            while (top != -1 && precedence(peek()) >= precedence(ch)) {
                postfix[k++] = pop();
                postfix[k++] = ' ';
            }
            push(ch);
        }
        i++;
    }

    while (top != -1) {
        postfix[k++] = pop();
        postfix[k++] = ' ';
    }

    postfix[k - 1] = '\0';
}

int evaluatePostfix(char postfix[]) {
    int i = 0;

    while (postfix[i] != '\0') {
        if (isdigit(postfix[i])) {
            int num = 0;
            while (isdigit(postfix[i])) {
                num = num * 10 + (postfix[i] - '0');
                i++;
            }
            pushVal(num);
        } else if (isOperator(postfix[i])) {
            int b = popVal();
            int a = popVal();
            int result;
            switch (postfix[i]) {
                case '+': result = a + b; break;
                case '-': result = a - b; break;
                case '*': result = a * b; break;
                case '/': result = a / b; break;
                case '^': result = power(a, b); break;
                default: printf("Invalid operator\n"); return -1;
            }

            pushVal(result);
        }
        i++;
    }
    return popVal();
}

int main() {
    char infix[SIZE], postfix[SIZE];
    int choice;
    while (1) {
        printf("\n---- MENU ----\n");
        printf("1. Infix to Postfix\n");
        printf("2. Evaluation of Postfix Expression\n");
        printf("3. Exit the Program\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        getchar();
        switch (choice) {
            case 1:
                printf("Enter infix expression: ");
                if (fgets(infix, sizeof(infix), stdin) != NULL) {
                    size_t len = strlen(infix);
                    if (len > 0 && infix[len - 1] == '\n') {
                        infix[len - 1] = '\0';
                    }
                    infixToPostfix(infix, postfix);
                    printf("Postfix expression: %s\n", postfix);
                }
                break;
            case 2:
                printf("Enter postfix expression: ");
                if (fgets(postfix, sizeof(postfix), stdin) != NULL) {
                    size_t len = strlen(postfix);
                    if (len > 0 && postfix[len - 1] == '\n') {
                        postfix[len - 1] = '\0';
                    }
                    printf("Result = %d\n", evaluatePostfix(postfix));
                }
                break;
            case 3:
                return 0;

            default:
                printf("WRONG INPUTTT\n");
        }
    }
    return 0;
}





