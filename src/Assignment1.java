

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment1 {
	public static void main(String[] args) {
		printAssignmentBox(new String[] {
				"Programming Assignment 1",
				"Computer Programming I",
				"Author: Sean Worley",
				"Due date: Thursday, Jan. 24",
				"Hi! I like bananas! Bananas are great! I want a banana pie.",
//				"Helluratuch! Pokus salara. Flafigen. Joogarook-Breegal!"
		});
	}

	public static void printAssignmentBox(String[] args) {
		// It's nice to be able to use JDK 8.  Streams make Java bearable.
		int maxlen = Arrays.stream(args).mapToInt(String::length).max().getAsInt(); 
		// Plus 2 for the asterisks on either side of the string, plus 5 for 5 asterisks total of padding around the string
		printAssignmentBox(args, maxlen + 2 + 5);
	}

	public static void printAssignmentBox(String[] args, int asteriskWidth) {
		for (int i = 0; i < asteriskWidth; i++)
			System.out.print('*');
		System.out.println();
		for (String s : args) {
			// Minus 2 for the 2 asterisks, one on either side
			int padding = asteriskWidth - s.length() - 2;
			int paddingLeft = padding / 2 + padding % 2;
			int paddingRight = padding / 2;
			System.out.print('*');
			for (int i = 0; i < paddingLeft; i++)
				System.out.print(' ');
			System.out.print(s);
			for (int i = 0; i < paddingRight; i++)
				System.out.print(' ');
			System.out.println('*');
		}
		for (int i = 0; i < asteriskWidth; i++)
			System.out.print('*');
		System.out.println();
	}

}
