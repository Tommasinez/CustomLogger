package it.betacom.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

	private BufferedWriter writer;

	private String level = "error";

	public Logger(String filename, String level) throws IOException {
		this.writer = new BufferedWriter(new FileWriter(new File(filename)));
		this.level = level;
	}

	public Logger(String filename) throws IOException {
		this.writer = new BufferedWriter(new FileWriter(new File(filename)));
	}

	public Logger(File logFile, String level) throws IOException {
		this.writer = new BufferedWriter(new FileWriter(logFile));
		this.level = level;
	}

	public Logger(File logFile) throws IOException {
		this.writer = new BufferedWriter(new FileWriter(logFile));
	}

	public void logError(String string) throws IOException {
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.writer.write(dateTime.format(now) + " [ERROR]" + " : " + string);
		this.writer.newLine();
		this.writer.flush();
	}

	public void logWarning(String string) throws IOException {

		if (!this.level.equalsIgnoreCase("error")) {
			DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			this.writer.write(dateTime.format(now) + " [WARNING] : " + string);
			this.writer.newLine();
			this.writer.flush();
		}
	}

	public void logInfo(String string) throws IOException {
		if (!this.level.equalsIgnoreCase("error") && !this.level.equalsIgnoreCase("warning")) {
			DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			this.writer.write(dateTime.format(now) + " [INFO] : " + string);
			this.writer.newLine();
			this.writer.flush();
		}
	}

	public void close() throws IOException {
		this.writer.close();
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
