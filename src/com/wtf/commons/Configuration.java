package com.wtf.commons;

import java.util.ResourceBundle;

public class Configuration {

	   //private static 	Properties prop = new Properties();
	   private static ResourceBundle props = ResourceBundle.getBundle("Configuration");
	   
	  /* static {
			//ClassLoader loader = Thread.currentThread().getContextClassLoader();     
			InputStream is = getClass().getResourceAsStream(fileName);
			InputStream stream = loader.getResourceAsStream("Configuration.properties");
			try {
				prop.load(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
	   }*/
	   
	   public static final String PROTOCOL = props.getString("PROTOCOL");
	   public static final String PORT = props.getString("PORT");
	   public static final String HOST = props.getString("HOST");
	   
}
