import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.io.*;

class Customer
{
    String name;
    String address;
    String phoneNum;

    Customer(String nam, String add, String num)
    {
        name=nam;
        address = add;
        phoneNum = num;
    }
}

class bankAcc
{
    Customer CTM;
    String accNum;
    double balance;
    String dateCreated;
    //String accountTyp;

    bankAcc( String date, String accID, String cName , String cAdd , String cNum)
    {
        CTM = new Customer(cName, cAdd, cNum);
        dateCreated = date;
        accNum = accID;
        balance = 0;
    }
    public void makeDeposit(double depositAmt)
    {
    	if(depositAmt <= 0)
    	{
    		System.out.println("Invalid Amount.");
    	}
    	else 
    	{
    		balance += depositAmt;
    	}
        
    }
    public void makeWithdrawl(double withdrawlAmt)
    {
    	if(withdrawlAmt <= balance && withdrawlAmt > 0)
        {
    		balance -= withdrawlAmt ;
    		printStatement(withdrawlAmt);
        }
    	else if (withdrawlAmt > balance)
    	{
    		System.out.println("Not enough balance.");
    	}
    	else
    	{
    		System.out.println("Invalid Amount.");
    	}
    	
    }
    public void checkBalance()
    {
    	System.out.println("\nCustomer Name : " + CTM.name);
    	System.out.println("Account ID : " + accNum);
    	System.out.println("Balance : " + balance);
        
    }
    public void printStatement(double amount)
    {
    	System.out.println("\t\t[ Transaction Statement ]\n");
    	System.out.println("Name : " + CTM.name);
        System.out.println("Address : " + CTM.address);
        System.out.println("Phone Number : " + CTM.phoneNum);
        System.out.println("Account Number : " + accNum);
        System.out.println("Transaction Time : ");
        System.out.println("Transaction Date : ");
        System.out.println("Transaction Amount : " + amount);
        System.out.println("Remianing Balance : " + balance +"\n");
    }
    
    public void transferAmount(double amount, bankAcc reciever)
    {
        if( amount <= balance && amount > 0)
        {
        	balance -= amount;
            reciever.makeDeposit(amount);
    		printStatement(amount);
        }
    	else if (amount > balance)
    	{
    		System.out.println("Not enough balance.");
    	}
    	else
    	{
    		System.out.println("Invalid Amount.");
    	}
    }
    
    public void calculateZakat()
    {
    	double zakatAmt = 0;
    	if(balance >= 20000)
    	{
    		zakatAmt = ( balance * 2.5 ) / 100;
    		System.out.println("\n\t\t[ Zakat Calculation ]\n");
        	System.out.println("Zakat is: " + zakatAmt +"\n");
        	makeWithdrawl(zakatAmt);
    	}
    	else
    	{
    		System.out.println("\nZakat not applicable.");
    	}

    }
    public void displayAllDeductions()
    {
    	
    }

}


 class savingAcc extends bankAcc
 {
     double interest;
     savingAcc(String date, String accID, String cName , String cAdd , String cNum) 
     {
    	 super(date, accID, cName ,  cAdd , cNum);
    	 interest = 0.0;
     }
     public void calculateInterest(double interest_Amt)
     {
    	interest = interest_Amt;
    	System.out.println("Interest Amount is : " + interest);
    	Interest_Applied(interest);
     }
     public void Interest_Applied(double amount) 
     {
    	 System.out.println("Interest Applied.");
    	 makeWithdrawl(amount);
     }
 }


 class checkingAcc extends bankAcc
 {
	 checkingAcc(String date, String accID, String cName , String cAdd , String cNum) 
     {
    	  super(date, accID, cName ,  cAdd , cNum);
     }
 }

class AMS
{  
    public static void main(String[] args) 
    {
    	Scanner input = new Scanner(System.in);
    	
    	//bankAcc[] accountsArr = new bankAcc[5];
    	//accountsArr[0].makeDeposit(1500);
    	//System.out.println("~ " + accountsArr[0].balance);
    	
    	int input1;
    	
    	//bankAcc Acc = new bankAcc("12/09/2021","2178","Saif","H.no21","425");
    	savingAcc Acc = new savingAcc("12/09/2021","2178","Saif","H.no21","425");
    	Acc.makeDeposit(25000);
    	System.out.println("~ " + Acc.balance);
    	Acc.makeWithdrawl(1200);
    	Acc.makeWithdrawl(1200);
    	Acc.checkBalance();
    	Acc.calculateZakat();
    	
    	System.out.println("Specify Interest Rate: "); 
    	input1 = input.nextInt();
    	Acc.calculateInterest(input1);
    	
    	
    	
//        Scanner input = new Scanner(System.in);
//        int choice;
//        int maxCapacity=0;
//        bankAcc[] accountsArr = new bankAcc[maxCapacity];
//
//       
//        do
//        {
//            System.out.println("1. Login");
//            System.out.println("2. Signup");
//            System.out.println("0. Exit");
//            choice = input.nextInt();
//            switch(choice)
//            {
//                case 1:
//                System.out.println("1");
//
//                break;               
//                case 2:
//                String name,address,phoneNo,date,accNumber;
//                System.out.println("Enter Name: ");
//                name = input.nextLine();
//                System.out.println("Enter Address: ");
//                address = input.nextLine();
//                System.out.println("Enter Phone Number: ");
//                phoneNo = input.nextLine();
//                System.out.println("Enter Todays Date: ");
//                date = input.nextLine();
//                System.out.println("Enter Your new Account number: ");
//                accNumber = input.nextLine();
//
//                bankAcc[] tempArr = new bankAcc[maxCapacity];
//                for(int i=0;i<maxCapacity;i++)
//                {
//                    accountsArr[i] = tempArr[i]; 
//                }
//                // java.util.Set.remove();
//                // accountsArr = NULL;
//                maxCapacity++;
//                bankAcc temp = new bankAcc(date,accNumber,name,address,phoneNo);
//                break;              
//                case 0:
//                System.out.println("Exiting");
//                break;
//                default:
//                System.out.println("Enter Valid Number.");
//                break;
//            }
//
//        }while(choice != 0 );

        // Random rand = new Random();
        // int upBound = 9000000;
        // int r_Num = nextInt(upBound);
        // System.out.println(r_Num);
    }
}