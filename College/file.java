import java.io.*;
import java.util.*;

public class file {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter fw1 = new FileWriter("numbers.txt");
        System.out.println("Enter how many digits you want to enter: ");
        int a = scanner.nextInt();             
        System.out.println("Enter the digits: ");
        int[] b = new int[a];       
        for (int i = 0; i < a; i++) {
            b[i] = scanner.nextInt();  
            fw1.write(String.valueOf(b[i]) + "\n");
        }
        fw1.close(); 
        FileReader fr1 = new FileReader("numbers.txt");
        FileWriter fw2 = new FileWriter("prime.txt");
        Scanner fileScanner = new Scanner(fr1);          
        while (fileScanner.hasNextInt()) {
            int n = fileScanner.nextInt();
            boolean prime = true;           
            if (n <= 1) prime = false;           
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }            
            if (prime) {
                fw2.write(n + "\n");  
            }           
        }
        fr1.close();
        fw2.close();
        fileScanner.close();  
         FileReader reader = new FileReader("prime.txt");
        Scanner primeScanner = new Scanner(reader);        
        System.out.println("Prime numbers from the file:");
        while (primeScanner.hasNextInt()) {
            System.out.println(primeScanner.nextInt());
        }
        primeScanner.close();
        reader.close();        
        System.out.println("Data written...");    
    }
}
