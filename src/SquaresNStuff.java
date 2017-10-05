import java.util.Scanner;

public class SquaresNStuff {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int a = in.nextInt();
		System.out.print("Enter the second number: ");
		int b = in.nextInt();
		int small, big;
		if(a>b) {
			small = b;
			big = a;
		} else {
			small = a;
			big = b;
		}
		System.out.println();
		
		int sum = 0;
		int sumOfSquares = 0;
		System.out.println("Odd integers between "+small+" and "+big+" are:");
		for(int i=small;i<=big;i++)
			if(i%2 == 0)
				sum += i;
			else {
				sumOfSquares += i*i;
				System.out.print(i+" ");
			}
		System.out.println();
		System.out.println("Sum of even integers between "+small+" and "+big+" = "+sum);
		System.out.println();
		System.out.println("Number	Square of Number");
		for(int i = 1;i<=10;i++)
			System.out.println("	"+i+"\t"+i*i);
		
		System.out.println();
		System.out.println("Sum of the squares of odd integers between "+small+" and "+big+" = "+sumOfSquares);
		System.out.println();
		System.out.println();
		for(int i=0;i<84;i++) System.out.print("=");
	}
}