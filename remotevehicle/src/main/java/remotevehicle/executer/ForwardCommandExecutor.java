package remotevehicle.executer;

import org.apache.log4j.Logger;

import remotevehicle.exception.InvalidCommandException;
import remotevehicle.exception.InvalidVehicleMoveException;
import remotevehicle.exception.NoVehicleFoundException;
import remotevehicle.grid.GridManager;
import remotevehicle.model.Direction;
import remotevehicle.model.Vehicle;

/**
 * The Class ForwardCommandExecutor.
 * 
 * FORWARD will move the vehicle forward one space in the direction it is facing.
 */
public class ForwardCommandExecutor implements CommandExecutor {

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(ForwardCommandExecutor.class);

	/** The next command. */
	private CommandExecutor nextCommand;
	
	/** The Constant COMMAND_PATTERN. */
	private static final String COMMAND_PATTERN = "FORWARD";

	/**
	 * Execute command.
	 *
	 * @param command the command
	 * @param gridManager the grid manager
	 * @return the string
	 * @throws InvalidCommandException the invalid command exception
	 */
	public String executeCommand(String command, GridManager gridManager){
		if (command.matches(COMMAND_PATTERN)) {
			
			logger.info("Inside ForwardCommandExecutor");
			
			Direction direction;
			Vehicle vehicle;
			int xPosition = 0; 
			int yPosition = 0;

			try {
				direction = gridManager.getVehicle().getDirection();
				vehicle = gridManager.getVehicle();

				xPosition = vehicle.getX();
				yPosition = vehicle.getY();

				switch (direction) {
				case NORTH:
					++yPosition;

					break;
				case SOUTH:
					--yPosition;

					break;
				case EAST:
					++xPosition;

					break;
				case WEST:
					--xPosition;

					break;
				default:
					break;
				}
			
				gridManager.setVehicle(new Vehicle(xPosition, yPosition, direction));
			} catch (InvalidVehicleMoveException ex) {
				logger.error("invalid position :",ex);
			} catch (NoVehicleFoundException ex) {
				logger.error("No vehicle found",ex);
			}

			return null;

		} else {
			return nextCommand.executeCommand(command, gridManager);
		}

	}

	/**
	 * Sets the next executor.
	 *
	 * @param commandExecutor the new next executor
	 */
	public void setNextExecutor(CommandExecutor commandExecutor) {
		this.nextCommand = commandExecutor;
	}
}