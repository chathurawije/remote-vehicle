package remotevehicle.executer;

import org.apache.log4j.Logger;

import remotevehicle.exception.InvalidCommandException;
import remotevehicle.exception.InvalidVehicleMoveException;
import remotevehicle.grid.GridManager;
import remotevehicle.model.Vehicle;
import remotevehicle.model.Direction;

/**
 * The Class PlaceCommandExecutor.
 * 
 * PLACE will put the vehicle at position X, Y on the grid facing one of four directions(NORTH, SOUTH, EAST, WEST).
 */
public class PlaceCommandExecutor implements CommandExecutor {
	
	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(PlaceCommandExecutor.class);
	
	/** The next command. */
	private CommandExecutor nextCommand;
	
	/** The Constant COMMAND_PATTERN. */
	private static final String COMMAND_PATTERN="START\\s-?\\d+\\,-?\\d+\\,(NORTH|EAST|SOUTH|WEST)";
	
	/** The Constant SPLIT_REGEX. */
	private static final String SPLIT_REGEX="\\s|\\,";

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
			
			logger.info("Inside PlaceCommandExecutor");
			
			String[] tokens = command.split(SPLIT_REGEX);

			int xPosition = Integer.parseInt(tokens[1]);			

			int yPosition = Integer.parseInt(tokens[2]);
			
			String direction = tokens[3];
			

			try {
				gridManager.setVehicle(new Vehicle(xPosition, yPosition, Direction.valueOf(direction)));
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
