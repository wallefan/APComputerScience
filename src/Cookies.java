import java.math.BigInteger;
import java.util.Scanner;

public class Cookies {
	// This is a constant for two reasons: 1) no magic numbers, and 2) it's a BigInteger, and BigIntegers don't play nice with int literals.
	// Why BigIntegers? Two reasons: 1) Why not? Computers have plenty of memory, and Eclipse will break long before a BigInteger does;
	// and 2) I sit next to Adrian, and I plan to let him test it, enough said.
	private static final BigInteger COOKIES_PER_BOX = BigInteger.valueOf(24);
	private static final BigInteger BOXES_PER_CONTAINER = BigInteger.valueOf(75);

	public static void main(String[] args) {
		System.out.print("Enter the total number of cookies:");
		Scanner s = new Scanner(System.in);
		BigInteger totalCookies = s.nextBigInteger();
		BigInteger[] requiredBoxes = totalCookies.divideAndRemainder(COOKIES_PER_BOX);
		System.out.println(requiredBoxes[0]+" boxes requrired to hold the cookies");
		System.out.println(requiredBoxes[1]+" cookies left over");
		BigInteger[] requiredContainers = requiredBoxes[0].divideAndRemainder(BOXES_PER_CONTAINER);
		System.out.println(requiredContainers[0]+" containers requrired to store/ship the boxed cookies");
		System.out.println(requiredContainers[1]+" boxes left over");
	}

}
