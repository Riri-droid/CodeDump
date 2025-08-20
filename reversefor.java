import java.util.Scanner;

public class reversefor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int  = scan.nextInt();
        int reverse = 0;
        for (; a > 0; a = a / 10) {
            int d = a % 10;  
            reverse = reverse * 10 + d;  
        }

        System.out.println("Reversed: " + reverse);
    }
}

