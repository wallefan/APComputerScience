// Example of using javax.swing package and static methods showInputDialog() & showMessageDialog()

import javax.swing.JOptionPane;
//OK to use import  java.swing.*; --Imports all classes from javax.swing package

public class JoptionExample {

	public static void main(String[] args) {
		String firstNum = JOptionPane.showInputDialog("Enter the first number: ");
		String secondNum = JOptionPane.showInputDialog("Enter the second number: ");
		
		int a = Integer.parseInt(firstNum);
		int b = Integer.parseInt(secondNum);
		
		
		JOptionPane.showMessageDialog(null, a + b, "RESULT", JOptionPane.INFORMATION_MESSAGE);

	}

}
