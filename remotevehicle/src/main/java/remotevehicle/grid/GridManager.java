package remotevehicle.grid;

import remotevehicle.exception.InvalidVehicleMoveException;
import remotevehicle.exception.NoVehicleFoundException;
import remotevehicle.model.Vehicle;


/**
 * The Interface GridManager.
 */
public interface GridManager {

	/**
	 * Gets the vehicle.
	 *
	 * @return the vehicle
	 * @throws NoVehicleFoundException the no vehicle found exception
	 */
	Vehicle getVehicle();


	/**
	 * Sets the vehicle.
	 *
	 * @param vehicle the new vehicle
	 * @throws InvalidVehicleMoveException the invalid vehicle move exception
	 */
	void setVehicle(Vehicle vehicle);
}