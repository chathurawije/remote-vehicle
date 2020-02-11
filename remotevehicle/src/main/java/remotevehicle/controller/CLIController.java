package remotevehicle.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import remotevehicle.exception.InvalidCommandException;
import remotevehicle.executer.CommandExecutorManager;

/**
 * The Class CLIController.
 * 
 * 
 * get console inputs from user
 * send that command to command executor
 * get result and display it in console
 */
public class CLIController implements Controller {

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(CLIController.class);

	/**
	 * Start program.
	 *
	 * @param commandExecutorManager the command executor manager
	 */
	@SuppressWarnings("resource")
	public void startProgram(CommandExecutorManager commandExecutorManager) {
		logger.info("Remote Vehicle CLI started");

		System.out.println("Remote Vehicle CLI\n");

		Scanner in = new Scanner(System.in);
		String input;
		String output;
		do {
			input = in.nextLine();
			try {
				output = commandExecutorManager.executeCommand(input);
				if (output != null) {
					
					System.out.println(output);
					
					logger.info(output);
				}
			} catch (InvalidCommandException ex) {
				logger.error("Invalid command :",ex);

			}

		} while (true);

	}
}