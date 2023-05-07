package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilities {

	public static final String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir + "/src/main/resources/";

	public static Properties getProperty(String fileName) {
		FileInputStream fis = null;
		Properties prop = null;

		try {
			fis = new FileInputStream(filePath + fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			throw new RuntimeException("File not found");
		} catch (IOException ioe) {
			throw new RuntimeException("File not found");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				throw new RuntimeException("Error while closing file");
			}
		}
		return prop;
	}
}
