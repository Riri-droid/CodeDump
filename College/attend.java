import java.util.Scanner;
public class attend 
{
 public static void main(String[] args)
 {
  int flag=0;
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter amount of students in class: ");
  int a=scan.nextInt();
  int [] std1=new int[a];
  for(int i=0;i<a;i++)
  {
   std1[i]=(i+1);
  }
  System.out.println("Enter amount of students present in class: ");
  int b=scan.nextInt();
  int [] std2=new int[b];
  System.out.println("Enter the present roll no:- ");
  
  for (int i=0;i<b;i++)
  {
   std2[i]=scan.nextInt();
  }
   int n = std2.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (std2[j] > std2[j + 1]) {
                    int temp = std2[j];
                    std2[j] = std2[j + 1];
                    std2[j + 1] = temp;
                    
                }
            }
            
        }  
  System.out.println("Enter the roll no:- to check if present: ");
  int c=scan.nextInt();
  int [] abs=new int[a];
  for (int i=0;i<b;i++)
  {
   if (c==std2[i])
   {
    System.out.println("roll no:- "+std2[i]+" is present");
    flag=flag+1;
   }
  }
  System.out.println("Absent roll no:- " );
  for (int i=0; i<a; i++)
  {
   int h=0;
   for (int j=0; j<b; j++)
   {
    if (std1[i]==std2[j])
    {
     h=1;
    }
   }
   if (h==0)
   {
    System.out.print(" "+std1[i]);
   }
   }

System.out.println(" ");
  if (flag==0)
   {System.out.println("The roll number " +c+ " is absent");}
   
  System.out.println("Sorted list of present roll no:- are: ");
  for (int i=0;i<b;i++)
  {
   System.out.println(std2[i]);
  }
  }
  }
  
   
   
   
  
  
