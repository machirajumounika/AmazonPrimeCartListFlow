package com.amazonprimepack.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class LoggerUtil {

	private static final String LOG_LOCATION = "C:\\temp\\AmazonTestCaseLogFile";
	private static FileAppender fappender;
	private static Logger logger = Logger.getLogger(LoggerUtil.class);

	public static Logger getLoggerUtil() {
		try {
			fappender = new FileAppender(new SimpleLayout(), LOG_LOCATION
					+ new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()).toString().replaceFirst(".text", "")
					+ ".log");
			logger.addAppender(fappender);
			fappender.setLayout(new SimpleLayout());
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
		return logger;
	}

}
