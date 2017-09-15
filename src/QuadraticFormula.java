


import java.util.Scanner;

public class QuadraticFormula {
	public static void main(String[] args) {
		System.out.print("Enter the values of A, B, and C, delimited by spaces, newlines, etc. or any combination: ");
		Scanner s = new Scanner(System.in);
		double a = s.nextDouble();
		double b = s.nextDouble();
		double c = s.nextDouble();
		double radical = (Math.pow(b, 2) - 4 * a * c);
		double rational = -b / (2 * a);
		boolean isReal = radical >= 0;
		double root = Math.sqrt(Math.abs(radical)) / (2*a);
		if (isReal)
			if (rational + root == rational - root)
				System.out.print("x = " + (rational + root));
			else
				System.out.printf("x = [%s, %s]", rational + root, rational - root);
		else
			System.out.printf("x  = %s +/- %si", rational, Math.abs(root));

	}
}
