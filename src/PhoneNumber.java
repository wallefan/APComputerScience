import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// You have rights to this code if you can explain to me how it works and don't delete this comment.

public class PhoneNumber {
	public static void main(String[] args) throws IOException {
		// no Scanners for me thanks

		// but I still have to wrap it in a Unicode input stream. Here I was getting all
		// excited about not using a scanner...*sigh*
		InputStreamReader stdin = new InputStreamReader(System.in);

		System.out.print(
				"Please input a phone number, 7, 10, or 11 digits, in any format (even one you make up on the spot!), delineated by a newline:");
		ArrayList<Integer> l = new ArrayList<Integer>();
		char ch;
		while ((ch = (char) stdin.read()) != '\n')
			if (Character.isDigit(ch))
				l.add(ch - '0');
		
		
		// Note the lack of any break statements anywhere here: this is intentional!
		switch (l.size()) {
		case 11:
			System.out.print("+" + l.remove(0) + " ");
		case 10:
			int a = l.remove(0);
			int b = l.remove(0);
			int c = l.remove(0);
			System.out.print("(" + a + b + c + ") ");
		case 7:
			int d = l.remove(0);
			int e = l.remove(0);
			int f = l.remove(0);
			System.out.print("" + d + e + f + "-"); // initial "" converts to str, so that d, e, and f will be
													// concatenated rather than summed
		
		default:
			l.stream().forEach(System.out::print); // print all digits remaining in the list to stdout
			System.out.println(); // output a newline
		}

	}
}
