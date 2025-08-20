import java.util.Scanner;
public class largest{
 public static void main(String[] args){
  Scanner scan= new Scanner(System.in);
  System.out.println("Enter first number:");
  int a=scan.nextInt();
  System.out.println("Enter second number:");
  int b=scan.nextInt();
  System.out.println("Enter third number:");
  int c=scan.nextInt();
  if (a>b&&a>c) {
   System.out.println("The largest number is: "+a);}
  else if (c>b)
     System.out.println("The largest number is: "+c);
  else {
  System.out.println("The largest number is: "+b);}
  }
  }
      
   
 
