package remotevehicle.executer;

import org.apache.log4j.Logger;

import remotevehicle.exception.InvalidCommandException;
import remotevehicle.grid.GridManager;

/**
 * The Class CommandExecutorManager.
 */
public class CommandExecutorManager {

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(CommandExecutorManager.class);

	/** The initial executor. */
	private CommandExecutor initialExecutor;
	
	/** The grid manager. */
	private GridManager gridManager;

	/**
	 * Instantiates a new command executor manager.
	 *	Create command executor chain
	 * @param gridManager the grid manager
	 */
	public CommandExecutorManager(GridManager gridManager) {
		this.gridManager = gridManager;
		PlaceCommandExecutor placeCommandExecutor = new PlaceCommandExecutor();
		ForwardCommandExecutor forwardCommandExecutor = new ForwardCommandExecutor();
		TurnLeftCommandExecutor turnLeftCommandExecutor = new TurnLeftCommandExecutor();
		TurnRightCommandExecutor turnRightCommandExecutor = new TurnRightCommandExecutor();
		PingCommandExecuter pingCommandExecuter = new PingCommandExecuter();

		this.initialExecutor = placeCommandExecutor;
		placeCommandExecutor.setNextExecutor(forwardCommandExecutor);
		forwardCommandExecutor.setNextExecutor(turnLeftCommandExecutor);
		turnLeftCommandExecutor.setNextExecutor(turnRightCommandExecutor);
		turnRightCommandExecutor.setNextExecutor(pingCommandExecuter);

		logger.info("CommandExecutorManager created");
	}

	/**
	 * Execute command.
	 *
	 * @param command the command
	 * @return the string
	 * @throws InvalidCommandException the invalid command exception
	 */
	public String executeCommand(String command){

		return initialExecutor.executeCommand(command, gridManager);
	}
}