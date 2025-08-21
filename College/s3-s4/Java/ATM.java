import java.io.*;
import java.util.*;
public class ATM{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        do{
            System.out.println("---ATM---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice=s.nextInt();
            int balance=0;
            int balance1=0;
            if(choice==5){
            System.out.println("Exiting...");
            break;
            }
            String fileName1="";
            String fileName2="";
            try{
                System.out.print("Enter your account number: ");
                int accountNumber=s.nextInt();
                if(accountNumber != 1 && accountNumber != 2)
                {
                 throw new IOException("Invalid Account Number"); 
                }
                if(accountNumber==1){
                    fileName1="1.txt";
                    fileName2="2.txt";
                }else{
                    fileName1="2.txt";
                    fileName2="1.txt";
                }
                FileReader fr=new FileReader(fileName1);
                Scanner fileScanner=new Scanner(fr);
                if(fileScanner.hasNextInt()){
                    balance=fileScanner.nextInt();
                }
                switch(choice){
                    case 1:{
                        System.out.print("Enter amount you want to withdraw: ");
                        int amount=s.nextInt();
                        if(balance<amount){
                            throw new IOException("Error: Insufficient funds!");
                        }
                        balance-=amount;
                        System.out.println("$"+amount+" has been withdrawn");
                        fr.close();
                        FileWriter fw=new FileWriter(fileName1);
                        fw.write(Integer.toString(balance));
                        fw.close();
                        break;
                    }
                    case 2:{
                        System.out.print("Enter amount you want to deposit: ");
                        int amount=s.nextInt();
                        balance+=amount;
                        System.out.println("$"+amount+" has been deposited");
                        fr.close();
                        FileWriter fw=new FileWriter(fileName1);
                        fw.write(Integer.toString(balance));
                        fw.close();
                        break;
                    }
                    case 3:{
                        System.out.print("Enter amount you want to transfer: ");
                        int amount=s.nextInt();
                        if(balance<amount){
                            throw new IOException("Error: Insufficient funds!");
                        }
                        balance-=amount;
                        fr.close();
                        FileWriter fw=new FileWriter(fileName1);
                        fw.write(Integer.toString(balance));
                        fw.close();
                        System.out.println("$"+amount+" has been transferred");
                        FileReader fr1=new FileReader(fileName2);
                        Scanner fileScanner1=new Scanner(fr1);
                        if(fileScanner1.hasNextInt()){
                            balance1=fileScanner1.nextInt();
                        }
                        FileWriter fw1=new FileWriter(fileName2);
                        balance1+=amount;
                        fw1.write(Integer.toString(balance1));
                        fw1.close();
                        break;
                    }
                    case 4:{
                        System.out.println("Your current balance is: $"+balance);
                        break;
                    }                                    
                    default:System.out.println("Invalid choice. Please try again.");break;
                }
            }catch(IOException e){
                System.out.println(e.getMessage());
            }finally{
                System.out.println("Current account balance: $"+balance);
            }
        }while(true);
        s.close();       
    }
}

