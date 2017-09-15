

import java.math.BigInteger;
import java.util.Scanner;

public class EasterBroken {
	private static final String[] months = {
			"ERROR! ",
			"January ",
			"February ",
			"March ",
			"April ",
			"May ",
			"June ",
			"July ",
			"August ",
			"September ",
			"October ",
			"November ",
			"December ",
	};
	public static final java.util.function.LongFunction<BigInteger> toBigInt = BigInteger::valueOf; // so I can do less typing
	public static void main(String[] args) {
		System.out.println("Enter a year (big as you want!): ");
		Scanner s = new Scanner(System.in);
		BigInteger y = s.nextBigInteger();
		int a = (int) y.mod(toBigInt.apply(19)).intValueExact(); // no need to waste *too* much memory, anything mod 19 will fit in an int.  I don't do this with any of the rest because it's a lot of hassle
		// b_c[0]=b, b_c[1]=c
		BigInteger[] b_c = y.divideAndRemainder(toBigInt.apply(100));
		// ditto
		BigInteger[] d_e = b_c[0].divideAndRemainder(toBigInt.apply(4));
		BigInteger g = b_c[0].multiply(toBigInt.apply(8)).add(toBigInt.apply(13)).mod(toBigInt.apply(13));
		BigInteger h = toBigInt.apply(a*19).add(b_c[0]).add(b_c[0]).subtract(d_e[0]).subtract(g).add(toBigInt.apply(15)).mod(toBigInt.apply(30));
		BigInteger[] j_k = b_c[1].divideAndRemainder(toBigInt.apply(4));
		BigInteger m = BigInteger.valueOf(a).multiply(toBigInt.apply(11)).add(h);
		BigInteger r = d_e[1].multiply(toBigInt.apply(2)).add(j_k[0].multiply(toBigInt.apply(2))).subtract(j_k[1]).subtract(h).add(m).add(toBigInt.apply(32)).mod(toBigInt.apply(7));
		BigInteger q = h.subtract(m).add(r);
		int n = q.add(toBigInt.apply(90)).mod(toBigInt.apply(25)).intValueExact();
		int p = q.add(toBigInt.apply(n)).add(toBigInt.apply(19)).mod(toBigInt.apply(19)).intValueExact();
		
		System.out.println("In the year "+y+", Easter falls on "+months[n]+p);
	}
}
