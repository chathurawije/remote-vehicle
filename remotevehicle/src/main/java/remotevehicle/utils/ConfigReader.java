package remotevehicle.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * The Class ConfigReader.
 */
public class ConfigReader {

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(ConfigReader.class);

	private static ConfigReader configReader;

	private ConfigReader() {

	}

	/**
	 * Gets the instance.
	 *
	 * @return the config reader
	 */
	public static ConfigReader getInstance() {

		if (configReader == null) {
			configReader = new ConfigReader();
		}
		return configReader;
	}

	/**
	 * Gets the configs.
	 *
	 * @param propFileName the prop file name
	 * @return the configs
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Properties getConfigs(String propFileName) throws IOException {

		Properties prop = new Properties();

		try (InputStream input = getClass().getClassLoader().getResourceAsStream(propFileName)) {

			prop = new Properties();

			if (input == null) {
				throw new FileNotFoundException("config file " + propFileName + " not found in the classpath");
			}

			prop.load(input);

		}
		return prop;
	}

}
