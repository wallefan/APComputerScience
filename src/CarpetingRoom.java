import java.util.Scanner;

public class CarpetingRoom {
	public static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		double roomLength = promptdouble("Length of the floor: ");
		double roomWidth = promptdouble("Width of the floor: ");
		double roomHeight = promptdouble("Height of the room: ");
		Door door = new Door("the door");
		Door window1 = new Door("widnow 1");
		Door window2 = new Door("window 2");
		Bookcase bookcase = new Bookcase("the bookcase");
		double costOfPaint = promptdouble("Cost (in some arbitrary unit) of Paint: ");
		double costOfCarpet = promptdouble("Cost (in some arbitrary unit) of carpeting: ");
		double areaOfRoom = roomWidth*roomHeight*2 + roomLength*roomHeight*2 - door.area() - window1.area() - window2.area() - bookcase.area();
		double areaOfFloor = roomWidth*roomLength;
		if(!promptBool("Carpet underneath the bookcase? ")) areaOfFloor -= bookcase.floorArea();
		double costToPaint = areaOfRoom * costOfPaint;
		double costToCarpet = areaOfFloor * costOfCarpet;
		System.out.printf("Cost to Paint: %.2f\n",costToPaint);
		System.out.printf("Cost to carpet: %.2f\n", costToCarpet);
		System.out.printf("Total cost: %.2f\n", costToPaint+costToCarpet);
		
	}
	
	public static double promptdouble(String prompt) {
		System.out.print(prompt);
		double i= s.nextDouble();
		System.out.println(i);
		return i;
	}
	
	public static boolean promptBool(String prompt) {
		System.out.print(prompt);
		boolean b = s.nextBoolean();
		System.out.println();
		return b;
	}
	/**
	 * A generic space that doesn't need Painting (door, window etc.)
	 * @author 540725
	 *
	 */
	private static class Door {
		double width, height;
		private Door(String name) {
			width = promptdouble("Width of "+name+": ");
			height = promptdouble("Height of "+name+": ");
		}
		double area() {
			return width*height;
		}
	}
	private static class Bookcase extends Door {
		double depth;
		private Bookcase(String name) {
			super(name);
			depth = promptdouble("Depth of "+name+": ");
		}
		double floorArea() {
			return width * depth;
		}
	}
}
