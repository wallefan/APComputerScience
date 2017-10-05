import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first number:");
		final int A = in.nextInt();
		int a = A;
		System.out.println("Enter the second number:");
		final int B = in.nextInt();
		int b = B;
		while(a > 0 && b > 0)
			if(a > b)
				a -= b;
			else
				b -= a;
		int gcd;
		if(a==0)
			gcd = b;
		else
			gcd = a;
		System.out.println("The greatest common divisor of "+A+" and "+B+" is "+gcd);
			
		
	}
}
