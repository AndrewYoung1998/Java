//Andrew Young
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RaceTrack {

	final static int[] distance = { 10, 5, 10 };

	public static void main(String[] args) throws IOException {

		String[] information;

		File myFile = new File("racecares.txt");
		Scanner sc = new Scanner(myFile);

		final int NUMCARS = Integer.parseInt(sc.nextLine());
		RaceCar[] racecar = new RaceCar[NUMCARS];
		double[] time1 = new double[NUMCARS];
		double[] time2 = new double[NUMCARS];
		double[] time3 = new double[NUMCARS];
		double[] raceTime = new double[NUMCARS];

		for (int i = 0; i < NUMCARS; i++) {
			String line;
			String carName, driverName;
			int red, green, blue;
			int maxSpeed;

			line = sc.nextLine();
			information = line.split(",");

			driverName = information[0];
			red = Integer.parseInt(information[1]);
			green = Integer.parseInt(information[2]);
			blue = Integer.parseInt(information[3]);
			maxSpeed = Integer.parseInt(information[4]);
			carName = information[5];
			RaceCar rc = new RaceCar(carName, driverName, red, green, blue, maxSpeed);
			racecar[i] = rc;
		}

		for (int count = 0; count < NUMCARS; count++) {

			// accelerate the car 5 times in leg 1
			for (int i = 0; i < 5; i++)
				racecar[count].accelerate();

			time1[count] = (double) distance[0] / racecar[count].getSpeed();

			// decelerate 2 times at turn 1
			for (int i = 0; i < 2; i++)
				racecar[count].decelerate();

			// accelerate the car 3 times in leg 2
			for (int i = 0; i < 3; i++)
				racecar[count].accelerate();

			time2[count] = (double) distance[1] / racecar[count].getSpeed();

			// decelerate 3 times at turn 2
			for (int i = 0; i < 3; i++)
				racecar[count].decelerate();

			// accelerate the car 5 times in leg 3
			for (int i = 0; i < 5; i++)
				racecar[count].accelerate();

			time3[count] = (double) distance[2] / racecar[count].getSpeed();

		}

		for (int i = 0; i < NUMCARS; i++)
			raceTime[i] = time1[i] + time2[i] + time3[i];

		// testing times
		for (int i = 0; i < NUMCARS; i++) {
			int hours, mins, secs;
			hours = (int) raceTime[i] / 1;
			mins = (int) (raceTime[i] % 1 * 60);
			secs = (int) (raceTime[i] % 1 * 60 % 1 * 60);
			System.out.println(racecar[i].getdriverName() +"\t" + racecar[i].getcarName() +"\t" +hours + ":" + mins + ":" + secs);
		}

	}

}
