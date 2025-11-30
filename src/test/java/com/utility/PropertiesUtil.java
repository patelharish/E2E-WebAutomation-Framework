package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String propertyName) {
		File propFile = new File(System.getProperty("user.dir") + "/config/QA.properties");
		FileReader fileReader = null;
		Properties props = new Properties();
		try {
			fileReader = new FileReader(propFile);
			props.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = props.getProperty(propertyName.toUpperCase());
		return value;
	}
}
