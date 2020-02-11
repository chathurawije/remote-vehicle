package remotevehicle.grid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import remotevehicle.exception.InvalidVehicleMoveException;
import remotevehicle.model.Direction;
import remotevehicle.model.Vehicle;

/**
 * The Class PositivePlaneEmptyGridManagerTest.
 */
class PositivePlaneEmptyGridManagerTest {

	/**
	 * Test.
	 * test weather the grid throws InvalidVehicleMoveException when negative coordinates are given
	 */
	@Test
	void testSetVehicle() {

		Vehicle vehicle = new Vehicle(1, -1, Direction.SOUTH);
		PositivePlaneEmptyGridManager positivePlaneEmptyGridManager = new PositivePlaneEmptyGridManager();
		assertThrows(InvalidVehicleMoveException.class, () -> positivePlaneEmptyGridManager.setVehicle(vehicle),
				"PositivePlaneEmptyGridManager should throw InvalidVehicleMoveException when negative cordinates are given");

	}

}
