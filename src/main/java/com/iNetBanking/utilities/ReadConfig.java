package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;

	public ReadConfig() {
		
		File src = new File("../inetBankingProject/Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getbaseUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
			}
	
	public String getUsername() {
		String username = prop.getProperty("userName");
		return username;
			}
	
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
			}
	
	public String getChromePath() {
		String chromePath = prop.getProperty("ChromePath");
		return chromePath;
			}
	public String getFirefoxPath() {
		String FirefoxPath = prop.getProperty("FirefoxPath");
		return FirefoxPath;
			}
	public String getIEPath() {
		String IEPath = prop.getProperty("IEPath");
		return IEPath;
			}
}
