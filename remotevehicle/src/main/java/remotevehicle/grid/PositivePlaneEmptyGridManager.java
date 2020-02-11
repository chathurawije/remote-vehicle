package remotevehicle.grid;

import remotevehicle.exception.InvalidVehicleMoveException;
import remotevehicle.exception.NoVehicleFoundException;
import remotevehicle.model.Vehicle;

/**
 * The Class PositivePlaneEmptyGridManager.
 * 
 * The most south-west corner of the grid is coordinate 0,0.
 */
public class PositivePlaneEmptyGridManager implements GridManager {

	/** The vehicle. */
	private Vehicle vehicle;

	/**
	 * Gets the vehicle.
	 *
	 * @return the vehicle
	 * @throws NoVehicleFoundException the no vehicle found exception
	 */
	public Vehicle getVehicle() {

		if (this.vehicle != null) {
			return this.vehicle;
		} else {
			throw new NoVehicleFoundException("No vehicle found on the grid");
		}
	}

	/**
	 * Sets the vehicle.
	 *
	 * @param vehicle the new vehicle
	 * @throws InvalidVehicleMoveException the invalid vehicle move exception
	 */
	public void setVehicle(Vehicle vehicle) {

		if (vehicle.getY() >= 0 && vehicle.getX() >= 0) {
			this.vehicle = vehicle;
		} else {
			throw new InvalidVehicleMoveException(
					"invalid position ( x: " + vehicle.getX() + " y:" + vehicle.getY() + ")");
		}

	}
}