package remotevehicle.controller;

import remotevehicle.exception.ControllerTypeNotFoundException;

/**
 * A factory for creating Controller objects.
 */
public class ControllerFactory {

	/**
	 * Gets the controller according to controller type argument.
	 *
	 * @param controllerType the controller type
	 * @return the controller
	 */
	public Controller getController(String controllerType) {

		if (controllerType.equals("CLI")) {
			return new CLIController();
		} else {
			throw new ControllerTypeNotFoundException("Controller type not found :"+controllerType);
		}
	}
}
