package remotevehicle.executer;

import org.apache.log4j.Logger;

import remotevehicle.exception.InvalidCommandException;
import remotevehicle.exception.InvalidVehicleMoveException;
import remotevehicle.exception.NoVehicleFoundException;
import remotevehicle.grid.GridManager;
import remotevehicle.model.Direction;
import remotevehicle.model.Vehicle;

/**
 * The Class TurnRightCommandExecutor.
 * 
 * TURN_RIGHT will rotate the vehicle clockwise in its current position 90 degrees in the corresponding direction.
 */
public class TurnRightCommandExecutor implements CommandExecutor {
	
	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(TurnRightCommandExecutor.class);

	/** The next command. */
	private CommandExecutor nextCommand;
	
	/** The Constant COMMAND_PATTERN. */
	private static final String COMMAND_PATTERN = "TURN_RIGHT";

	/**
	 * Execute command.
	 *
	 * @param command the command
	 * @param gridManager the grid manager
	 * @return the string
	 * @throws InvalidCommandException the invalid command exception
	 */
	public String executeCommand(String command, GridManager gridManager) {
		if (command.matches(COMMAND_PATTERN)) {

			logger.info("Inside TurnRightCommandExecutor");

			try {
				Vehicle vehicle = gridManager.getVehicle();
				Direction direction = vehicle.getDirection();

				int xPosition = vehicle.getX();
				int yPosition = vehicle.getY();

				switch (direction) {
				case NORTH:
					direction = Direction.EAST;
					break;
				case SOUTH:
					direction = Direction.WEST;
					break;
				case EAST:
					direction = Direction.SOUTH;
					break;
				case WEST:
					direction = Direction.NORTH;
					break;
				default:
					break;
				}

				gridManager.setVehicle(new Vehicle(xPosition, yPosition, direction));
			} catch (NoVehicleFoundException ex) {
				logger.error("No vehicle found",ex);

			} catch (InvalidVehicleMoveException ex) {
				logger.error("invalid position",ex);
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
