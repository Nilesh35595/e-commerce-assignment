package com.e_commerce.ui.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resource/testConfig.properties";
    private static final Properties properties = new Properties();

    static {
    	
        try {
        	File filepath = new File(CONFIG_FILE_PATH);
        	FileInputStream file = new FileInputStream(filepath);
            properties.load(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
    
    public static String getProductName() {
        return properties.getProperty("prodcutname");
    }
    
    public static String getBrowser() {
        return properties.getProperty("browser");
    }
    
    public static String getShortWait() {
    	return properties.getProperty("shortWait");
    }
    
}
