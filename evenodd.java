import java.util.Scanner;
public class evenodd{
 public static void main(String[] args){
  Scanner scan = new Scanner(System.in);
  int n;
  int odd=0;int even=0;int zero=0;
  System.out.println("How many digits to enter:");
  n = scan.nextInt();
  int[] arr = new int[n];
  for (int i=0; i<n; i++)
  {
   System.out.println("Enter digit " + (i+1) + ":");
   arr[i] = scan.nextInt();
  }
  for (int i=0; i<n; i++)
  {
   if (arr[i]==0)
   {
    zero=zero+1;
   }
   else if (arr[i]%2==0)
   {
    even=even+1;
   }
   else
    {odd=odd+1;}
    }
  
  System.out.println("Number of odd numbers: "+odd);
  System.out.println("Number of even numbers: "+even);
  System.out.println("Number of zero numbers: "+zero);
  
 }
 }
  
  
  
