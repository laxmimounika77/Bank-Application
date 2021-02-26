import java.util.Scanner;

public class Account {
	
	int balance;
	int previousTransaction;
	String cname;
	String cid;
	
	Account(String cname, String cid) {
		this.cname=cname;
		this.cid=cid;
		
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			balance= balance+amount;
			previousTransaction=amount;
		}
		
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance= balance - amount;
			previousTransaction=-amount;
		}
		
	}
	
	void getPreviousTransaction() {
		if(previousTransaction >0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction <0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction occured");
		}
	}
	
	void calculateInterest(int years) {
		double interestRate= .018499;
		double newBalance= (balance*interestRate*years)+ balance;
		System.out.println("The current interest rate is " +(100*interestRate));
		System.out.println("After " +years+ " years your balance will be" +newBalance);
		
	}
	
	void showMenu() {
		char option='\0';
		Scanner scanner= new Scanner(System.in);
		System.out.println("Welcome "+cname);
		System.out.println("Your ID is "+cid);
		System.out.println();
		System.out.println("What would you like to do today?");
		System.out.println("_______________________________________");
		System.out.println("A. Check your balance");
		System.out.println("B. Make a Deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View Previous Transaction");
		System.out.println("E. Calculate Interest");
		System.out.println("F. Exit");
		System.out.println("_______________________________________");
		
		do {
			System.out.println();
			System.out.println("Enter an Option: ");
			char option1= scanner.next().charAt(0);
			option= Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			
			case 'A':
				System.out.println("_______________________________________");
				System.out.println("Balance is $"+balance);
				System.out.println("_______________________________________");
				System.out.println();
				break;
			
			
			case 'B':
				
				System.out.println("Enter an amount to deposit: ");
				int amount=scanner.nextInt();
				deposit(amount);
				System.out.println();
				System.out.println("Your new balance is "+balance);
				System.out.println();
				break;
				
			case 'C':
				System.out.println("Enter an amount to withdraw ");
				int amount2=scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				System.out.println("Your new balance is "+balance);
				System.out.println();
				break;
				
				
			case 'D':
				System.out.println("_______________________________________");
				getPreviousTransaction();
				System.out.println("_______________________________________");
				System.out.println();
				break;
				
			case 'E':
				System.out.println("Enter how many years of cummilated interest");
				int y=scanner.nextInt();
				calculateInterest(y);
				break;
				
				
			case 'F':
				System.out.println("_______________________________________");
				break;
			}
			
		}while(option !='F');
		System.out.println("Thank you " +cname+ " for banking with us");
		System.out.println("_______________________________________");
		
	}
	


}
