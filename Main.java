import java.util.Scanner;

class BankAccount {
	private String accountHolder;
	private double balance;

	private static int pin = 1234;
	private static int limit = 3;
	private static int pincount=0;

	public BankAccount(String accountHolder, double balance) {
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	// method to withdraw money
	public void withdraw(double amt) {
		try {
			if (amt > balance) {
				throw new InsufficientBalanceException("Insuffiecient balance for withdrwal");
			}
			balance -= amt;
			System.out.println(balance);
			System.out.println("Withdrwal sucess " + amt + " remaining balance is " + balance);
		} catch (InsufficientBalanceException e) {
			System.out.println("error" + e.getMessage());
		} finally {
			System.out.println("transacton complted " + accountHolder);
		}
	}

	public void Deposite(double amt) {
		try {
			if (amt <= 0) {
				throw new MinimumBalance("Please add more than 100rs");
			}
			balance += amt;
			System.out.println("Amount deposited " + amt + "successfully, Balance is " + balance);
		}

		catch (MinimumBalance e) {
			System.out.println("error: " + e);
		} finally {
			System.out.println("Transaction completed" + accountHolder);
		}

	}

	public void pin(int atmpin) 
	{		
			if (pin == atmpin) 
			{
				System.out.println("pin correct weclome");
			}

			else {
				System.out.println("incorrect pin");
				pincount++;
			}
			
	
		if(pincount == limit)
		{
			System.out.println("Card Blocked");
		}

	}

}

public class Main {
	public static void main(String args[]) {
		BankAccount dipakac = new BankAccount("Dipak", 5000);
		dipakac.withdraw(1000);

		dipakac.Deposite(5000);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your pin");
		int atmpin = sc.nextInt();

		dipakac.pin(atmpin);

	}

}

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

class MinimumBalance extends Exception {
	public MinimumBalance(String message) {
		super(message);
	}
}