import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccounts {

	public static void main(String[] args) throws FileNotFoundException {
		main(args[1] == "-" ? System.in : new FileInputStream(args[0]), args.length > 1 ?
				new ForkOutputStream(System.out, new FileOutputStream(args[1])) : System.out);

	}

	private static void main(InputStream input, OutputStream output) {
		Scanner s = new Scanner(input);
		ArrayList<Account> accounts = new ArrayList<Account>();
		readInput(s, accounts);
		do {
			for(Account a : accounts) {
				System.out.println("Account "+a.accountNumber);
				System.out.println("Balance:");
			}
		}
		
	}

	private static void readInput(Scanner s, List<Account> out) {
		// Any malformed input data is ignored. This is my not-janky-at-all way of
		// implementing that.
		while (s.hasNextLine()) {
			Account a = new Account();
			if (!s.hasNextInt()) {
				s.nextLine();
				continue;
			}
			a.accountNumber = s.nextInt();

			String next = s.next();
			if (next.toLowerCase().equals("s") || next.toLowerCase().equals("savings"))
				a.accountType = Account.AccountType.SAVINGS;
			else if (next.toLowerCase().equals("c") || next.toLowerCase().equals("checking"))
				a.accountType = Account.AccountType.SAVINGS;
			else {
				s.nextLine();
				continue;
			}

			if (!s.hasNextFloat()) {
				s.nextLine();
				continue;
			}
			a.minBalance = s.nextFloat();

			if (!s.hasNextDouble()) {
				s.nextLine();
				continue;
			}
			a.currentBalance = s.nextDouble();

			// Should it skip if there's extraneous data?
			if (s.hasNext()) {
				s.nextLine();
				continue;
			}
			out.add(a);
		}
	}

	static class Account {
		int accountNumber;

		enum AccountType {
			CHECKING, SAVINGS;
		}

		AccountType accountType;
		float minBalance;
		double currentBalance;
		
		public double endMonth() {
			if (currentBalance < minBalance) {
				return currentBalance - (accountType == Account.AccountType.CHECKING ? 25 : 10); // service charge
			} else
				switch (accountType) {
				case CHECKING:
					if (currentBalance >= (minBalance + 5000))
						return currentBalance + (currentBalance * (.05D / 12));
					else
						return currentBalance + (currentBalance * (.03D / 12));
				case SAVINGS:
					return currentBalance + (currentBalance * (.04D / 12));
				default:
					throw new Error("Invalid account type");
				}
		}
	}

}
