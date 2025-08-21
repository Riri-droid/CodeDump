import java.util.Scanner;
 public class calc {
   public static void main (String[] args){
	Scanner scan= new Scanner(System.in);
	float n1,n2,res;
	int choice=0;
	System.out.println("---CALCULATOR---");
	System.out.println("Enter number 1:");
	n1 = scan.nextFloat();
	System.out.println("Enter number 2:");
	n2 = scan.nextFloat();
	
	do {
	  System.out.println("1:ADDITION");
	  System.out.println("2:SUBTRACTION");
	  System.out.println("3:MULTIPLICATION");
	  System.out.println("4:DIVISION");
	  System.out.println("5:EXIT");
	  System.out.println("What do you choose: ");
	  choice = scan.nextInt();
	  switch(choice) {
	   case 1:
	   {
	    res=n1+n2;
	    System.out.println("The addition of " +n1+ " and " +n2+ " is " +res);
	    break;
	   }
	   case 2:
	   {
	    if (n1>n2)
	    {
	     res=n1-n2;
	     System.out.println("The substraction of " +n1+ " and " +n2+ " is " +res);
	     break;
	    }
	    else{
	      res=n2-n1;
	      System.out.println("The subtraction of " +n1+ " and " +n2+ " is " +res);
	      break;
	      }
	     
	     }
	    case 3:
	    {
	     res=n1*n2;
	     System.out.println("The multiplication of " +n1+ " and " +n2+ " is " +res);
	     break;
	     }
	    case 4:
	    {
	     if (n2==0)
	     {
	     System.out.println("The divisor cannot be 0");
	     break;
	     }
	     else
	     {
	      res=n1/n2;
	      System.out.println("The division of " +n1+ " and " +n2+ " is " +res);
	       break;
	     }}
	    case 5:{
                    System.out.println("Exiting...");
                    break;
	    }
	    default:
	     System.out.println(" Wrong Input ");
	    }
	    }
	    while (choice != 5);	    
	     scan.close();	     
	     
	 }}

	     
	     
	    
	    
	    
	  
