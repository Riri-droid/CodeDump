import java.util.Scanner;

class BankAccount {
    int accountnumber;
    String accountname;
    float accountbalance;

    BankAccount(int accnum, String accname, float accbal) {
        accountnumber = accnum;
        accountname = accname;
        accountbalance = accbal; }
        
void deposit(float deposit) {
 accountbalance += deposit;
 }

void withdraw(float withdraw) {
  if (accountbalance > 0 && withdraw <= accountbalance)
     accountbalance -= withdraw;
  else
     System.out.println("Insufficient funds");
 }

 void balance() {
   System.out.printf("Account Balance: " + accountbalance + "\n");
}

void display() {
    System.out.printf("Account Number: " + accountnumber + "\n");
    System.out.printf("Account Holder Name: " + accountname + "\n");
    System.out.printf("Account Balance: " + accountbalance + "\n");
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    BankAccount acc1 = new BankAccount(01, "Riyan", 240);
    System.out.print("Enter Account Number: ");
    int num = input.nextInt();
    System.out.print("Enter Account Holder: ");
    String name = scanner.nextLine(); 
    System.out.print("Enter Account Balance: ");
    float bal = input.nextFloat();
    System.out.println("_________________________________________");
    BankAccount acc2 = new BankAccount(num, name, bal);
    acc1.display();
     System.out.print("\n");
    acc2.display();
    int choice = 0;  
     do {
         System.out.println("Enter what to do:- ");
         System.out.println("1. Deposit ");
         System.out.println("2. Withdraw ");
         System.out.println("3. Exit ");
         System.out.print("Enter your choice: ");
          choice = scanner.nextInt(); 
          switch (choice) {
               case 1: {
                   System.out.println("Enter the amount to deposit: ");
                   float depositAmount = scanner.nextFloat();
                   System.out.println("Which account (1 or 2)? ");
                   int accountChoice = scanner.nextInt();
                   if (accountChoice == 1) {
                       acc1.deposit(depositAmount);
                        System.out.println("After deposit: ");
                       acc1.display();
                    } else {
                       acc2.deposit(depositAmount);
                        System.out.println("After deposit: ");
                        acc2.display();
                    }
                    break; 
                }
                case 2: {
                 System.out.println("Enter the amount to withdraw: ");
                   float withdrawAmount = scanner.nextFloat();
                   System.out.println("Which account (1 or 2)? ");
                   int accountChoice = scanner.nextInt();
                  if (accountChoice == 1) {
                        acc1.withdraw(withdrawAmount);
                        System.out.println("After withdrawal: ");
                        acc1.display();
                    } else {
                        acc2.withdraw(withdrawAmount);
                        System.out.println("After withdrawal: ");
                        acc2.display();
                    }
                    break;  
                }
                case 3:
                    System.out.println("Exiting...");
                    break;  
                default:
                    System.out.println("Invalid choice! Please try again.");
                     }       
                    } 
                    while (choice != 3);  
                     }
}

