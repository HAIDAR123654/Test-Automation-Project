package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtils {

	// read properties file!!

	public static String readProperty(Env env, String propertyName) {
		File propfile = new File(System.getProperty("user.dir") + "\\config\\" + env + ".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();

		try {
			fileReader = new FileReader(propfile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(propertyName.toUpperCase());
	}
}
