package com.niukun.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HelloLog4j {
	private static Logger logger = Logger.getLogger(HelloLog4j.class.getName());

	public static void main(String[] args) {
		BasicConfigurator.configure();

		logger.debug("Start of the main() in TestLog4j");
		logger.info("Just INFO");
		logger.warn("Just WARN");
		logger.error("Just ERROR");
		logger.fatal("Just FATAL");
		logger.debug("End of the main() in TestLog4j");
	}
}
