package com.seatseller;

import java.util.Properties;

/*
 * Configuration gathers all possible configuration variables defined in the config.properties files.
 * 
 *  Configuration follows the singleton pattern.
 */
public class Configuration {
	 Properties configFile;
	   public Configuration()
	   {
		configFile = new Properties();
		try {
		  configFile.load(this.getClass().getClassLoader().
		  getResourceAsStream("config.properties"));
		}catch(Exception e){
		    e.printStackTrace();
		}
	   }
	 
	   public String getProperty(String propriedade) {
		String valor = this.configFile.getProperty(propriedade);
		return valor;
	   }
	
}
