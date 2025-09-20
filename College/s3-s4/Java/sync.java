import java.util.*;
class BankAccount{
    private int balance=0;
    public void updateBalance(int amount){
        balance+=amount;
        System.out.println("Current Balance: "+balance);
        try{
            Thread.sleep(1500);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
class TransactionThread extends Thread{
    BankAccount account;
    Random rand=new Random();
    TransactionThread(BankAccount account){
        this.account=account;
    }
    public void run(){
        while(true){
            int action=rand.nextInt(2);
            if(action==0) {
               account.updateBalance(10);
               System.out.println("Deposited...");}
            else  {
               account.updateBalance(-10);
               System.out.println("Withdrawn..."); }
            try{
                Thread.sleep(rand.nextInt(2000));
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
public class sync{
    public static void main(String[] args){
        BankAccount account=new BankAccount();
        TransactionThread thread1=new TransactionThread(account);
        thread1.start();
    }
}

