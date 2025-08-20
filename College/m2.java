import java.util.Scanner;

public class m2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("How many rows of matrix 1:");
        int m = scan.nextInt();
        System.out.println("How many columns of matrix 1:");
        int n = scan.nextInt();
        
        int[][] ar1 = new int[m][n];
        
       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter digit of " + (i + 1) + " and " + (j + 1) + ":");
                ar1[i][j] = scan.nextInt();
            }
        }
        
      
        System.out.println("How many rows of matrix 2:");
        int a = scan.nextInt();
        System.out.println("How many columns of matrix 2:");
        int b = scan.nextInt();
        
        
        if (m != a || n != b) {
            System.out.println("Matrix dimensions must match for addition!");
            return; 
        }

        int[][] ar2 = new int[a][b];
        
        
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.println("Enter digit of " + (i + 1) + " and " + (j + 1) + ":");
                ar2[i][j] = scan.nextInt();
            }
        }
        
        
        int[][] ar3 = new int[m][n];
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ar3[i][j] = ar1[i][j] + ar2[i][j];
            }
        }
        
        
        System.out.println("Matrix 1:");
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[i].length; j++) {
                System.out.print(ar1[i][j] + " ");
            }
            System.out.println();
            }
        
       
        System.out.println("Matrix 2:");
        for (int i = 0; i < ar2.length; i++) {
            for (int j = 0; j < ar2[i].length; j++) {
                System.out.print(ar2[i][j] + " ");
            }
            System.out.println();
            }
        
        
        System.out.println("Resultant Matrix (Matrix 1 + Matrix 2):");
        for (int i = 0; i < ar3.length; i++) {
            for (int j = 0; j < ar3[i].length; j++) {
                System.out.print(ar3[i][j] + " ");
            }
            System.out.println();
            }
            
        System.out.println("Transpose of the metrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ar3[j][i] + " ");
            }
            System.out.println();
            }
        
        
    }
    }
    
    
        
    
   
   
   


