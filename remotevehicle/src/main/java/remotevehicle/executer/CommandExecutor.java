package remotevehicle.executer;

import remotevehicle.exception.InvalidCommandException;
import remotevehicle.grid.GridManager;

/**
 * The Interface CommandExecutor.
 * 
 * Decode command string
 * If this executor can execute this command execute and give result
 * if this can't, then pass to next one
 * if this is the last executor and if this also can't execute this or
 * if syntax error then throw InvalidCommandException
 */
public interface CommandExecutor {
	
    /**
     * Execute command.
     *
     * @param command the command
     * @param gridManager the grid manager
     * @return the string
     * @throws InvalidCommandException the invalid command exception
     */
    String executeCommand( String command, GridManager gridManager );

    /**
     * Sets the next executor.
     *
     * @param commandExecutor the new next executor
     */
    void setNextExecutor( CommandExecutor commandExecutor );

}
