import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccounts {

	public static void main(String[] args) throws FileNotFoundException {
		main(args[1] == "-" ? System.in : new FileInputStream(args[0]));

	}

	private static void main(InputStream input) {
		Scanner s = new Scanner(input);
		ArrayList<Account> accounts = new ArrayList<Account>();
		readInput(s, accounts);

	}
	
	public static void run(List<Account> accounts, int months) {
		for(int month = 0; month < months; month++) {
			
		}
	}

	private static void readInput(Scanner s, List<Account> out) {
		// Any malformed input data is ignored. This is my not-janky-at-all way of
		// implementing that with a Scanner because I know of no better tool. Or even if
		// there is a better way in Java.
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

			if (!s.hasNextFloat()) {
				s.nextLine();
				continue;
			}
			a.currentBalance = s.nextFloat();

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
		float currentBalance;
	}

}
