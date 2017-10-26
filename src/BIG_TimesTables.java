import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class BIG_TimesTables {

	public static void main(String[] args) throws FileNotFoundException {
		System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\Sean 2\\Desktop\\timesTables.txt")));
		Scanner in = new Scanner(System.in);
		System.err.print("Enter a number to compute the multiplication table up to (it can be arbitrarily large!  I'd like to see you TRY and break it!!):");
		BigInteger max = in.nextBigInteger();
		in.close();
		int maxlen = max.multiply(max).toString().length()+1;
		for(BigInteger i = BigInteger.ONE;i.compareTo(max) == -1;i = i.add(BigInteger.ONE)) {
			for(BigInteger j = BigInteger.ONE;j.compareTo(max) == -1;j = j.add(BigInteger.ONE)) {
				String s = i.multiply(j).toString();
				System.out.print(s);
				for(int p=0;p<maxlen-s.length();p++)
					System.out.print(' ');
			}
			System.out.println();
				
		}
				
	}

}
