package remotevehicle.controller;

import remotevehicle.executer.CommandExecutorManager;

/**
 * The Interface Controller.
 * 
 * 
 * get inputs from user
 * send that command to command executor
 * get result and display it
 * 
 */
public interface Controller {
	
	
	/**
	 * Start program.
	 *
	 * @param commandExecutorManager the command executor manager
	 */
	void startProgram( CommandExecutorManager commandExecutorManager );

}
