package remotevehicle.executer;

import org.apache.log4j.Logger;

import remotevehicle.exception.InvalidCommandException;
import remotevehicle.exception.NoVehicleFoundException;
import remotevehicle.grid.GridManager;
import remotevehicle.model.Direction;
import remotevehicle.model.Vehicle;

/**
 * The Class PingCommandExecuter.
 * 
 * PING will cause the position of the vehicle to be printed out in the console.
 */
public class PingCommandExecuter implements CommandExecutor {

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(PingCommandExecuter.class);

	/** The next command. */
	@SuppressWarnings("unused")
	private CommandExecutor nextCommand;
	
	/** The Constant COMMAND_PATTERN. */
	private static final String COMMAND_PATTERN = "PING";

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

			logger.info("Inside PingCommandExecuter");

			try {
				Vehicle vehicle = gridManager.getVehicle();
				Direction dir = vehicle.getDirection();

				int xPosition = vehicle.getX();
				int yPosition = vehicle.getY();

				logger.info("output : " + xPosition + "," + yPosition + "," + dir);
				return "output : " + xPosition + "," + yPosition + "," + dir;
			} catch (NoVehicleFoundException ex) {
				logger.error("No vehicle found",ex);
				return null;
			}
		} else {
			throw new InvalidCommandException("Invalid command :"+command);

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
