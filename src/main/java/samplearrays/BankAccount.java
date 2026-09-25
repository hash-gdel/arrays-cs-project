package samplearrays;
import java.lang.Math;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];
    int index =0;
    public BankAccount(String name, int startingBalance){
        this.name =name;
        this.currentBalance =startingBalance;
    }

    public void deposit(double amount){
        if (amount<0){System.out.println("The deposit amount is invalid");}
        else{
            this.currentBalance += amount ;
            this.transactions[this.index] =amount;
            this.index++;
            System.out.println("Depositor's name: "+this.name+", deposited amount: "+amount+", new balance: "+this.currentBalance);
        }

    }

    public void withdraw(double amount){
        if (Math.abs(amount)>this.currentBalance){System.out.println("The withdrawal amount is invalid");}
        else{
            this.currentBalance += amount ;
            this.transactions[this.index] =amount;
            this.index++;
            System.out.println("Depositor's name: "+this.name+", withdrawal amount: "+amount+", new balance: "+this.currentBalance);
        }
    }

    public void displayTransactions(){
        for(int i=0;i<transactions.length;i++){
            System.out.println("Transaction number "+(i+1)+" is "+this.transactions[i]);
            System.out.println();
        }
    }

    public void displayBalance(){
        System.out.println("Current balance is : "+this.currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
