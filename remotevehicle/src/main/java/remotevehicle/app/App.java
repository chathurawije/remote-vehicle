package remotevehicle.app;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import remotevehicle.controller.Controller;
import remotevehicle.controller.ControllerFactory;
import remotevehicle.exception.ControllerTypeNotFoundException;
import remotevehicle.exception.GridTypeNotFoundExeption;
import remotevehicle.executer.CommandExecutorManager;
import remotevehicle.grid.GridManager;
import remotevehicle.grid.GridManagerFactory;
import remotevehicle.utils.ConfigReader;

/**
 * The Class App.
 */
public class App {

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(App.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		App app = new App();
		app.startApp();
	}

	/**
	 * Start app.
	 */
	public void startApp() {
		logger.info("App Started... ");

		Properties configs = null;
		GridManager gridManager = null;
		Controller controller = null;

		try {
			// load configurations
			configs = ConfigReader.getInstance().getConfigs("config/app.properties");

			// create grid manager
			gridManager = new GridManagerFactory().getGridManager(configs.getProperty("grid.type"));

			// create controller
			controller = new ControllerFactory().getController(configs.getProperty("controller.type"));

		} catch (GridTypeNotFoundExeption ex) {
			logger.fatal("Invalid Grid type :", ex);
			System.out.println("Program exited due to an error. Please refer logs");
			System.exit(1);
		} catch (ControllerTypeNotFoundException ex) {
			logger.fatal("Invalid Controller type :", ex);
			System.out.println("Program exited due to an error. Please refer logs");
			System.exit(1);
		} catch (IOException ex) {
			logger.fatal("Error while reading configurations", ex);
			System.out.println("Program exited due to an error. Please refer logs");
			System.exit(1);
		}

		CommandExecutorManager commandExecutorManager = new CommandExecutorManager(gridManager);


		// start controller
		controller.startProgram(commandExecutorManager);

	}
}
