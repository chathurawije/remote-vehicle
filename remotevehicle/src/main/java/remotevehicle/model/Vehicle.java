package remotevehicle.model;


/**
 * The Class Vehicle.
 */
public class Vehicle {
	
	/** The x. */
	int x;
	
	/** The y. */
	int y;
	
	/** The direction. */
	Direction direction;

	/**
	 * Instantiates a new vehicle.
	 *
	 * @param x the x
	 * @param y the y
	 * @param direction the direction
	 */
	public Vehicle(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

}