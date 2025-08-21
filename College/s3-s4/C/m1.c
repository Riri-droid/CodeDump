#include <stdio.h>

#define MAX_TERMS 100

void sparseRepresentation(int mat[][10], int rows, int cols, int sparse[][3]) {
    sparse[0][0] = rows;
    sparse[0][1] = cols;
    int k = 1;
    
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            if(mat[i][j] != 0) {
                sparse[k][0] = i;
                sparse[k][1] = j;
                sparse[k][2] = mat[i][j];
                k++;
            }
        }
    }
    sparse[0][2] = k - 1;
}

void sparseAddition(int A[][3], int B[][3], int C[][3]) {
    if(A[0][0] != B[0][0] || A[0][1] != B[0][1]) {
        printf("Error: Matrix dimensions don't match!\n");
        return;
    }

    C[0][0] = A[0][0];
    C[0][1] = A[0][1];
    
    int i = 1, j = 1, k = 1;
    while(i <= A[0][2] && j <= B[0][2]) {
        if(A[i][0] < B[j][0] || (A[i][0] == B[j][0] && A[i][1] < B[j][1])) {
            C[k][0] = A[i][0];
            C[k][1] = A[i][1];
            C[k][2] = A[i][2];
            i++;
        }
        else if(A[i][0] > B[j][0] || (A[i][0] == B[j][0] && A[i][1] > B[j][1])) {
            C[k][0] = B[j][0];
            C[k][1] = B[j][1];
            C[k][2] = B[j][2];
            j++;
        }
        else {
            C[k][0] = A[i][0];
            C[k][1] = A[i][1];
            C[k][2] = A[i][2] + B[j][2];
            i++;
            j++;
        }
        k++;
    }

    while(i <= A[0][2]) {
        C[k][0] = A[i][0];
        C[k][1] = A[i][1];
        C[k][2] = A[i][2];
        i++;
        k++;
    }

    while(j <= B[0][2]) {
        C[k][0] = B[j][0];
        C[k][1] = B[j][1];
        C[k][2] = B[j][2];
        j++;
        k++;
    }

    C[0][2] = k - 1;
}

void sparseTranspose(int A[][3], int T[][3]) {
    T[0][0] = A[0][1];
    T[0][1] = A[0][0];
    T[0][2] = A[0][2];
    
    for(int i = 1; i <= A[0][2]; i++) {
        T[i][0] = A[i][1];
        T[i][1] = A[i][0];
        T[i][2] = A[i][2];
    }
}

void printMatrix(int mat[][10], int rows, int cols) {
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }
}

void printSparse(int S[][3]) {
    for(int i = 1; i <= S[0][2]; i++) {
        printf("%d %d %d\n", S[i][0], S[i][1], S[i][2]);
    }
    printf("\n");
}

int main() {
    int mat1[10][10], mat2[10][10];
    int sparse1[MAX_TERMS][3], sparse2[MAX_TERMS][3], result[MAX_TERMS][3];
    int rows, cols, choice;

    while(1) {
        printf("\n1. Addition\n");
        printf("2. Transpose\n");
        printf("3. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        if(choice == 1) {
            
            printf("\nMatrix 1:\n");
            printf("Enter rows and columns: ");
            scanf("%d %d", &rows, &cols);
            printf("Enter elements:\n");
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    scanf("%d", &mat1[i][j]);
                }
            }

            
            printf("\nMatrix 2:\n");
            printf("Enter rows and columns: ");
            scanf("%d %d", &rows, &cols);
            printf("Enter elements:\n");
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    scanf("%d", &mat2[i][j]);
                }
            }

            
            sparseRepresentation(mat1, rows, cols, sparse1);
            sparseRepresentation(mat2, rows, cols, sparse2);

            
            printf("\nSparse Matrices in tuple format:\n");
            printf("Matrix 1:\n");
            printSparse(sparse1);
            printf("Matrix 2:\n");
            printSparse(sparse2);

            sparseAddition(sparse1, sparse2, result);

            printf("Result of Addition:\n");
            printSparse(result);
        }
        else if(choice == 2) {
            printf("\nEnter matrix dimensions (rows cols): ");
            scanf("%d %d", &rows, &cols);
            printf("Enter matrix elements:\n");
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    scanf("%d", &mat1[i][j]);
                }
            }

            sparseRepresentation(mat1, rows, cols, sparse1);

            printf("\nSparse Matrix:\n");
            printSparse(sparse1);

            sparseTranspose(sparse1, result);

            printf("Transposed Matrix:\n");
            printSparse(result);
        }
        else if(choice == 3)
         {  printf("---Exiting---");
            printf("\n");
            break;
        }
        else {
            printf("Invalid choice!\n");
        }
    }

    return 0;
}
	

