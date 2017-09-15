import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TicketSales {
	public static void main(String[] args) {
		float totalSales = 0;
		try (Scanner s = new Scanner(new FileInputStream("data.txt"))) {
			while (s.hasNext()) {
				if (s.hasNextFloat()) {// skip any non-numbers
					float ticketPrice = s.nextFloat();
					int ticketsSold = s.nextInt();
					totalSales += ticketPrice * ticketsSold;
				}
				if (s.hasNextLine())
					s.nextLine();
			}

			JOptionPane.showMessageDialog(null, new Formatter().format("Total ticket sales: $%,.2f", totalSales).toString());
		} catch (FileNotFoundException e) {
			System.err.println("data.txt not found, please create the file in the correct location and try again");
			System.exit(1);
		} catch (HeadlessException e) {
			System.out.printf("Total ticket sales: $%,.2f%n", totalSales);
		}
	}
}
