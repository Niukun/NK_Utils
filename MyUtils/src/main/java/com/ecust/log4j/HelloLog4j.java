package com.ecust.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HelloLog4j {
	private static Logger logger = Logger.getLogger(HelloLog4j.class.getName());

	public static void main(String[] args) {
		BasicConfigurator.configure();

		logger.debug("Start of the main() in TestLog4j");
		logger.info("Just testing a log message with priority set to INFO");
		logger.warn("Just testing a log message with priority set to WARN");
		logger.error("Just testing a log message with priority set to ERROR");
		logger.fatal("Just testing a log message with priority set to FATAL");
		logger.debug("End of the main() in TestLog4j");
	}
}
