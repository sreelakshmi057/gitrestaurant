package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilities {

	public static final String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir + "/src/main/resources/";

	public static Properties getProperty(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;

		try {
			fis = new FileInputStream(filePath + fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
			System.out.println(fnfe.getCause());

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			System.out.println(ioe.getCause());
		} finally {
			fis.close();
		}
		return prop;
	}
}
