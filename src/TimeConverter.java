

import java.util.Scanner;
import java.math.BigInteger;

// I plan to let Adrian test this, which means I need to use BigIntegers.  Trust me.  He will enter a 1 followed by about 30 zeroes.  He's that kind of guy.
public class TimeConverter {
	static final BigInteger SIXTY = BigInteger.valueOf(60); // seconds per minute and minutes per hour
	static final BigInteger HOURS_PER_DAY = BigInteger.valueOf(24);
	private static final BigInteger DAYS_PER_YEAR = BigInteger.valueOf(365);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of seconds: ");
		BigInteger[] minutesSeconds = s.nextBigInteger().divideAndRemainder(SIXTY);
		int seconds = minutesSeconds[1].intValueExact();
		BigInteger[] hoursMinutes = minutesSeconds[0].divideAndRemainder(SIXTY);
		int minutes = hoursMinutes[1].intValueExact();
		BigInteger[] daysHours = hoursMinutes[0].divideAndRemainder(HOURS_PER_DAY);
		int hours = daysHours[1].intValueExact();
		BigInteger[] yearsDays = daysHours[0].divideAndRemainder(DAYS_PER_YEAR);
		int days = yearsDays[1].intValueExact();
		BigInteger years = yearsDays[0];
		if(years.signum() != 0)
			System.out.printf("%,d years, ", years);
		if(days != 0)
			System.out.print(days + " days, ");
		if (hours != 0)
			System.out.print(hours + " hours, ");
		if (minutes != 0)
			System.out.print(minutes + " minutes, ");
		System.out.println(seconds + " seconds");
		System.out.printf("%d:%02d:%02d\n", hoursMinutes[0], minutes, seconds);
	}
}
