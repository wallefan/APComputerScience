
public class ReferenceString {

	public static void main(String[] args) {
		//int a = 23; 
		//int b = 23;
		String a = "John Smith";
		String b = new String("John Smith");
		
		//if (a == b) Incorrect way to compare 2 objects for equality
		if (a.equals(b))
		{
			System.out.println("The two strings are the same.");
		}
		else
		{
			System.out.println("The two strings are DIFFERENT.");
		}

	}

}
