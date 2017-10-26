import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class FasterTimesTables {

	public static void main(String[] args) throws FileNotFoundException {
		//System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\Sean 2\\Desktop\\timesTables2.txt")));
		Scanner in = new Scanner(System.in);
		System.err.print("Enter a number to compute multiplication tables up to (must be at most "+(long)Math.sqrt(Long.MAX_VALUE)+"):");
		long max = in.nextLong();
		in.close();
		int maxlen = Long.toString(max*max).length()+1;
		for(long i = 1;i <= max;i++) {
			for(long j = 1;j <= max;j++) {
				String s = Long.toString(i*j);
				System.out.print(s);
				for(int p=0;p<maxlen-s.length();p++)
					System.out.print(' ');
			}
			System.out.println();
		}
				
	}

}
