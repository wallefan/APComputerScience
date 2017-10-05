
public class Year {
	final int year; // seems kinda redundant,  but whatever
	public Year(int year) {
		this.year = year;
	}
	
	public boolean isLeapYear() {
		// remind me why an if statement is necessary?
		return (year % 4 == 0) && !(year % 100 == 0) || year % 400 == 0;
	}
}
