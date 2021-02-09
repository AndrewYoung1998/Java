//Andrew Young

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class peaksAndvalleys {

	public static void main(String args[]) throws IOException {
		File myFile = new File("terrain.dat");
		Scanner sc = new Scanner(myFile);
		
		//Delimiter
		String[] dimensions = sc.nextLine().replaceAll("[(')]", "").split(",");
		
		
		int height = Integer.parseInt(dimensions[0]);
		int width = Integer.parseInt(dimensions[1]);
		
		//Array of the file and arrays of the highest and lowest points
		int[][] heightMap = new int[32][20];
		int[] fiveHeights = new int[5];
		int[] fiveLowest = new int[5];
		Point[] heightPoints = new Point[5];
		Point[] lowPoints = new Point[5];
		
		//Loops through the rows in the file
		for (int i = 0; i < height; i++) {
			String tuple = sc.nextLine();
			
			String[] values = tuple.split("\\t");
			
			//Loops through the columns in the file
			for (int j = 0; j < width; j++) {

				int val = Integer.parseInt(values[j]);
				
				//Loops through to find the highest point
				for (int h = 0; h < fiveHeights.length; h++) {
					if (val > fiveHeights[h]) {
						if (h != 0) {
							fiveHeights[h - 1] = fiveHeights[h];
							heightPoints[h - 1] = heightPoints[h];
						}

						fiveHeights[h] = val;
						heightPoints[h] = new Point(j, i);
					}

				}
				
				//Loops through to find the lowest point
				for (int h = 0; h < fiveLowest.length; h++) {
					if (val < fiveLowest[h]) {
						if (h != 0) {
							fiveLowest[h - 1] = fiveLowest[h];
							lowPoints[h - 1] = lowPoints[h];
						}

						fiveLowest[h] = val;
						lowPoints[h] = new Point(j, i);
					}
				}

			}

		}
		
		System.out.println("The top 5 highest points are:\n");
		System.out.println("Height:" +"\t" +"Coordinates:");
		
		//Loop for displaying the highest points
		for (int h = fiveHeights.length - 1; h >= 0; h--) {
			System.out.println(fiveHeights[h] +"\t [" +heightPoints[h].x +","+heightPoints[h].y +"]" );
		}
		
		System.out.println("\nThe top 5 lowest points are:\n");
		System.out.println("Height:" +"\t" +"Coordinates:");
		
		//Loop for displaying the lowest points
		for (int h = fiveLowest.length - 1; h >= 0; h--) {
			System.out.println(fiveLowest[h] +"\t [" +lowPoints[h].x +","+lowPoints[h].y +"]");
		}
	}
}
