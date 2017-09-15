
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Easter {
	public static void main(String[] args) {
		System.out.println("Enter a year (Adrian, no stupid tricks!): ");
		Scanner s = new Scanner(System.in);
		int y = s.nextInt();
		s.close();
		if (y < 0) {
			System.out.println(
					"Uhmmm...I'm not very good at negative years (not to mention Christ wasn't born yet, much less resurrected) but I'll try...");
		} else if (y < 33) {
			System.out.println(
					"O...kay... I'll tell you what day it would have been if it had been celebrated, but Christ wasn't dead yet soo....");
		}
		int a = y % 19;
		int b = y / 100;
		int c = y % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (19 * a + b - d - g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int n = (h - m + r + 90) / 25;
		int p = (h - m + r + n + 19) % 32;

		// System.out.println("In the year "+y+", Easter falls on "+months[n]+p);
		System.out.print("Easter falls on ");
		printAmerican(y, n, p);
	}

	public static void printAmerican(int year, int month, int day) {
		// to think the Java style guide mandates 80 column lines... I have written
		// quite a few lines of Java that did relatively simple things that were about
		// 115 characters each
		System.out.print(SimpleDateFormat.getDateInstance(0, Locale.US)
				.format(new GregorianCalendar(year, month, day).getTime()));
	}
}
