import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BankAccounts {
	/**
	 * Syntax:
	 * 
	 * java BankAccounts [inputFile [outputFile ...]]
	 * 
	 * Either may be -
	 * 
	 * Duplicate account numbers are allowed and are not treated specially. You'll
	 * just end up with a duplicate in the output.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		InputStream input;
		OutputStream output;
		if (args.length < 1 || args[0].equals("-"))
			input = System.in;
		else
			try {
				input = new FileInputStream(args[0]);
			} catch (FileNotFoundException e) {
				System.err.println(
						"Input file not found.  Please check the syntax (java BankAccounts [inputFile] [outputFile] and the path to the file.");
				return;
			}

		if (args.length > 1) {
			OutputStream[] outs = new OutputStream[args.length - 1];
			for (int i = 1; i < args.length; i++)
				try {
					outs[i - 1] = args[i].equals("-") ? System.out : new FileOutputStream(args[i]);
				} catch (FileNotFoundException e) {
					System.err.println("Unable to create output file " + e
							+ ".  Please check that you have write permission here and that you aren't trying to write to a directory (folder).");
					return;
				}
			output = new ForkOutputStream(outs);
		} else
			output = System.out;
		
		main(input, output);

	}

	private static void main(InputStream input, OutputStream output) {
		Scanner s = new Scanner(input);
		ArrayList<Account> accounts = new ArrayList<Account>();
		readInput(s, accounts);
		do {
			for (Account a : accounts) {
				System.out.println("Account " + a.accountNumber);
				System.out.println("======================================");
				System.out.println("Balance: $" + a.currentBalance);
				System.out.println("New balance: $" + a.endMonth());
			}
		} while (false);

		writeOutput(accounts, output);

	}

	private static void writeOutput(ArrayList<Account> accounts, OutputStream output) {
		PrintStream out = new PrintStream(output);
		for (Account a : accounts) {
			out.print(a.accountNumber);
			out.print(' ');
			out.print(a.accountType);
			out.print(' ');
			out.print(a.minBalance);
			out.print(' ');
			out.println(a.currentBalance);
		}
	}

	private static void readInput(Scanner s, List<Account> out) {
		// Any malformed input data is ignored. This is my not-janky-at-all way of
		// implementing that.
		for (; s.hasNextLine(); s.nextLine()) {
			Account a = new Account();
			if (!s.hasNextInt())
				if (s.next().equals("end"))
					break;
				else
					continue;
			a.accountNumber = s.nextInt();

			if (!s.hasNext())
				continue;

			String next = s.next();

			if (next.toLowerCase().equals("s") || next.toLowerCase().equals("savings"))
				a.accountType = Account.AccountType.SAVINGS;

			else if (next.toLowerCase().equals("c") || next.toLowerCase().equals("checking"))
				a.accountType = Account.AccountType.CHECKING;

			else
				continue;

			if (!s.hasNextFloat())
				continue;
			a.minBalance = s.nextFloat();

			if (!s.hasNextDouble())
				continue;
			a.currentBalance = s.nextDouble();

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
				return currentBalance -= (accountType == Account.AccountType.CHECKING ? 25 : 10); // service charge
			} else
				switch (accountType) {
				case CHECKING:
					if (currentBalance >= (minBalance + 5000))
						return currentBalance += (currentBalance * (.05D / 12));
					else
						return currentBalance += (currentBalance * (.03D / 12));
				case SAVINGS:
					return currentBalance += (currentBalance * (.04D / 12));
				default:
					throw new Error("Invalid account type");
				}
		}
	}

}
