package it.betacom.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import it.betacom.model.Logger;

public class Controller {
	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			String configPath = "/Users/Tommasinez/Public/config.properties";
			properties.load(new FileInputStream(new File(configPath)));
			String parameter = properties.getProperty("logger.level");
			
			Logger log0 = new Logger("log0.txt", parameter);
			log0.logError("Error");
			Thread.sleep(500);
			log0.logWarning("Warning");
			Thread.sleep(500);
			log0.logInfo("Info");
			System.out.println("Operation 0 done!");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		try {
			Logger log1 = new Logger("log1.txt", "warning");
			log1.logError("Error");
			Thread.sleep(500);
			log1.logWarning("Warning");
			Thread.sleep(500);
			log1.logInfo("Info");
			System.out.println("Operation 1 done!");

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		try {
			File file = new File("log2.txt");
			Logger log2 = new Logger(file, "error");
			log2.logError("Error");
			Thread.sleep(500);
			log2.logWarning("Warning");
			Thread.sleep(500);
			log2.logInfo("Info");
			System.out.println("Operation 2 done!");

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		try {
			Logger log3 = new Logger("log3.txt");
			log3.setLevel("Some info text");
			log3.logError("Error");
			Thread.sleep(500);
			log3.logWarning("Warning");
			Thread.sleep(500);
			log3.logInfo("Info: ");
			System.out.println("Operation 3 done!");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}