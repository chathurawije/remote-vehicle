package remotevehicle.executer;

import org.apache.log4j.Logger;

import remotevehicle.exception.InvalidCommandException;
import remotevehicle.exception.InvalidVehicleMoveException;
import remotevehicle.exception.NoVehicleFoundException;
import remotevehicle.grid.GridManager;
import remotevehicle.model.Direction;
import remotevehicle.model.Vehicle;

/**
 * The Class TurnLeftCommandExecutor.
 * 
 * TURN_LEFT will rotate the vehicle anti-clockwise in its current position 90 degrees in the corresponding direction.
 */
public class TurnLeftCommandExecutor implements CommandExecutor {

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(TurnLeftCommandExecutor.class);

	/** The next command. */
	private CommandExecutor nextCommand;
	
	/** The Constant COMMAND_PATTERN. */
	private static final String COMMAND_PATTERN = "TURN_LEFT";

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

			
			
			logger.info("Inside TurnLeftCommandExecutor");
			
			try {
				Vehicle vehicle = gridManager.getVehicle();
				Direction direction = vehicle.getDirection();

				int xPosition = vehicle.getX();
				int yPosition = vehicle.getY();

				switch (direction) {
				case NORTH:
					direction = Direction.WEST;
					break;
				case SOUTH:
					direction = Direction.EAST;
					break;
				case EAST:
					direction = Direction.NORTH;
					break;
				case WEST:
					direction = Direction.SOUTH;
					break;
				default:
					break;
				}

				gridManager.setVehicle(new Vehicle(xPosition, yPosition, direction));

			} catch (NoVehicleFoundException ex) {
				logger.error("No vehicle found",ex);
				
			}catch (InvalidVehicleMoveException ex) {
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
