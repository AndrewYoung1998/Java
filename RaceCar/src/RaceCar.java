import java.awt.Color;
import java.util.Random;

public class RaceCar {

	// data members
	private String carName, driverName;
	private int speed, red, green, blue;
	private int maxSpeed;

	// method members

	// constructors

	/**
	 * This is the full constructor.
	 * 
	 * @param name
	 *            this will be the name of the Car object
	 * @param speed
	 *            this will be the speed of the Car object
	 * @param color
	 *            this will be the color of the Car object
	 * @param maxSpeed
	 *            this will be the maxSpeed of the Car object
	 */
	public RaceCar(String carName, String driverName, int red, int green, int blue, int maxSpeed) {
		super();
		this.carName = carName;
		this.driverName = driverName;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.maxSpeed = maxSpeed;
	}

	// getters and setters

	/**
	 * This method returns the name of the Car object
	 * 
	 * @return
	 */
	public String getcarName() {
		return carName;
	}

	public String getdriverName() {
		return driverName;
	}

	public int getSpeed() {
		return speed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * method return the String description of the object
	 */
	/*
	 * @Override
	 * 
	 * public String toString() { return "Car [name=" + name + ", speed=" + speed +
	 * ", color=" + ", maxSpeed=" + maxSpeed + "]"; }
	 */

	// object specific methods
	/**
	 * this method increases speed by a random number between 5 and 20
	 * 
	 */
	public void accelerate() {
		Random rand = new Random();

		speed += (5 + rand.nextInt(16));

		if (speed > maxSpeed)
			speed = maxSpeed;
	}

	/**
	 * this method decreases speed by a random number between 5 and 20
	 * 
	 */
	public void decelerate() {
		Random rand = new Random();

		speed -= (5 + rand.nextInt(16));

		if (speed < 0)
			speed = 0;
	}

}
