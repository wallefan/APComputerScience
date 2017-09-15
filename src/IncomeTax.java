import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class IncomeTax {

	public static void main(String[] args) {
		String name = promptString("Employee name");
		double totalSalary = promptFloat("Gross salary");

		double incomeTax = totalSalary * 0.15;
		double stateTax = totalSalary * 0.035;
		double socialSecurityTax = totalSalary * 0.0575;
		double medicaidTax = totalSalary * 0.0275;
		double pensionPlan = totalSalary * 0.05;
		double healthInsurance = 75D;

		Formatter f = new Formatter();

		// gross salary is by definition the longest number, use its length as the field
		// width
		int width = Integer.toString((int) totalSalary).length();

		/*
		 * I found a page online somewhere saying you can use variable width format
		 * specification using * instead of the width. This apparently works in C and I
		 * found a website that said (briefly) that it worked in Java too. I tried this:
		 * 
		 * f.format("Federal Income Tax:	$%*f%n", width, incomeTax);
		 * f.format("State Tax:			$%*f%n", width, stateTax);
		 * f.format("Social Security Tax:	$%*f%n", width, socialSecurityTax);
		 * f.format("Medical/Medicaid Tax:	$%*f%n", width, medicaidTax);
		 * f.format("Pension Plan:			$%*f%n", width,pensionPlan);
		 * 
		 * It failed miserably. This was mentioned in two separate questions on
		 * StackOverflow and this kludge is more or less all you can do.
		 * 
		 * Also, apparently Swing ignores tab characters.
		 * 
		 * And of course % formatting expects a fixed with font. And of course you can't
		 * specify a fixed with font on Swing.
		 */

		f.format("Name: %s%n$%,"+width+".2f Gross Salary%n%n", name, totalSalary);
		f.format("$%," + width + ".2f Federal Income Tax%n", incomeTax);
		f.format("$%," + width + ".2f State Tax%n", stateTax);
		f.format("$%," + width + ".2f Social Security Tax%n", socialSecurityTax);
		f.format("$%," + width + ".2f Medicare/Medicaid Tax%n", medicaidTax);
		f.format("$%," + width + ".2f Pension Plan%n", pensionPlan);
		f.format("$%," + width + ".2f Health Insurance%n%n", healthInsurance);
		f.format("$%," + width + ".2f Net Salary",
				totalSalary - incomeTax - stateTax - socialSecurityTax - medicaidTax - pensionPlan - healthInsurance);

		showString(f.toString());
		f.close();

	}

	// In Python you can put function definitions inside an if statement, so, for
	// example, you can have two different implementations for a method depending
	// on whether or not some resource (such as a window manager with which to
	// display a dialog box) is available. In C you can do the same with
	// #ifdef. Java has jack-all. You have to check every time. Most programmers
	// agree that Java was badly designed.

	static float promptFloat(String prompt) {
		while (true) {
			try {
				return Float.parseFloat(promptString(prompt));
			} catch (NumberFormatException e) {
				showString("Error: Number parsing failed: " + e + "\nPlease enter a valid floating point number.");
			}
		}
	}

	private static void showString(String string) {
		if (GraphicsEnvironment.isHeadless()) {
			System.out.println(string);
		} else {
			JOptionPane.showMessageDialog(null, string); // This silly thing expands tabs to 0 spaces! Rrgh!
		}
	}

	private static String promptString(String prompt) {
		String result = null;
		while (result == null) {
			if (!GraphicsEnvironment.isHeadless()) {
				// business as usual
				result = JOptionPane.showInputDialog(prompt);
				if(result==null) System.exit(1); // User clicked Cancel
				continue;
			} else {
				// We're running headless. Wonderful. That means either no window manager, no
				// keyboard, no mouse,
				// or some combination of the above. Guess we'll just use the console then.

				// One question, Java: WHY can't you just let us read from stdin a line at a
				// time?
				// WHY isn't that the default?
				System.out.print(prompt);
				Scanner s = new Scanner(System.in);
				result = s.next();
				s.close();
				continue;
			}
		}
		return result;
	}

}
