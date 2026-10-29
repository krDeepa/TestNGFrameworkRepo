package com.training.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	FileInputStream fileInput;
	
	public String readPropertiesFile(String key) {
		
		String srcFilePath="Properties\\application.properties";
		try {
			 fileInput=new FileInputStream(srcFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop=new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=prop.get(key).toString();
		//String value=(String)prop.get(key);
		return value;		
		
	}

}
