package com.Engines;

import java.awt.Desktop;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.gui.GUIMichael;
import com.gui.MTray;

public class DataBaseEngine {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/michaeldb?allowPublicKeyRetrieval=true&useSSL=false";
	private static String username = "root";
	private static String password = "admin";

	public static void exectueCommand(String recognizedCommand) {

		try {
			Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
			Statement myStmt = myConn.createStatement();
			myConn = DriverManager.getConnection(jdbcURL, username, password);

			String sqlString = ("SELECT * FROM commands where Command = '" + recognizedCommand + "'");
			ResultSet myRs = myStmt.executeQuery(sqlString);

			if (myRs.next()) {
				String execute = myRs.getString("Execute").trim();
//				System.out.println(execute);
				if (execute.contains("ChangeTabInfo")) {
					GUIMichael.tabbedPane.setSelectedIndex(1);
					GUIMichael.mainFrame.setVisible(true);
				} else if (execute.contains("ChangeTabMichael")) {
					GUIMichael.tabbedPane.setSelectedIndex(0);
					GUIMichael.mainFrame.setVisible(true);
				} else if (execute.contains("ChangeTabCommands")) {
					GUIMichael.tabbedPane.setSelectedIndex(2);
					GUIMichael.mainFrame.setVisible(true);
				} else if (execute.contains("ChangeTabAddCommands")) {
					GUIMichael.tabbedPane.setSelectedIndex(3);
					GUIMichael.mainFrame.setVisible(true);
				} else if (execute.contains("ChangeTabChangeCommands")) {
					GUIMichael.tabbedPane.setSelectedIndex(4);
					GUIMichael.mainFrame.setVisible(true);
				} else if (execute.contains("EXIT_MICHAEL")) {
					if(GUIMichael.isSoundOn) {
						@SuppressWarnings("unused")
						MVoice Michael = new MVoice("Goodbye, " + System.getProperty("user.name"));
						System.exit(0);
					} else {
						try {
							MTray.MTray.displayMessage("Michael:", "Goodbye, " + System.getProperty("user.name") ,  MessageType.INFO);
							System.exit(0);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else if (execute.contains("MICHAEL_TIME")) {
					java.util.Date date = new java.util.Date();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					String time = sdf.format(date);
					@SuppressWarnings("unused")
					MVoice Michael = new MVoice(time);
				} else if (execute.contains("MICHAEL_DATE")) {
					java.util.Date date = new java.util.Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String dateString = sdf.format(date);
					@SuppressWarnings("unused")
					MVoice f = new MVoice(dateString);
				} else if (isURL(execute)) {
					webPage(execute);
				} else if (!isURL(execute)) {
					localExe(execute);
				}
			} else{
				try {
					if (GUIMichael.isSoundOn) {
						@SuppressWarnings("unused")
						MVoice Michael = new MVoice("No such command, in database.");
					} else {
						try {
							MTray.MTray.displayMessage("Michael:", "No such command in database ", MessageType.INFO);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void webPage(String executeCommand) throws IOException, URISyntaxException {
		try {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				Desktop.getDesktop().browse(new URI(executeCommand));
			}
		} catch (Exception e) {
			if (GUIMichael.isSoundOn) {
				@SuppressWarnings("unused")
				MVoice Michael = new MVoice("File. paht. might. be. corrupted.");
			} else {
				try {
					MTray.MTray.displayMessage("Michael:", "File path might be corrupted ", MessageType.INFO);
				} catch (Exception l) {

				}
			}
		}
	}

	private static void localExe(String executeCommand) {
		try {
			Path path = FileSystems.getDefault().getPath(executeCommand);
			File file = path.toFile();
			Desktop desktop = Desktop.getDesktop();
			desktop.open(file);
		} catch (Exception e) {
			if (GUIMichael.isSoundOn) {
				@SuppressWarnings("unused")
				MVoice Michael = new MVoice("File. paht. might. be. corrupted.");
			} else {
				try {
					MTray.MTray.displayMessage("Michael:", "File path might be corrupted ", MessageType.INFO);
				} catch (Exception l) {

				}
			}
		}
	}

	/**
	 * ADD COMMAND
	 */

	public static void addCommand() {
		String addCommand = GUIMichael.addCommand.getText();
		String addAction = GUIMichael.addAction.getText();
		String addLocation = GUIMichael.addLocation.getText();

		if (addCommand.isEmpty() || addAction.isEmpty() || addLocation.isEmpty()) {
			JOptionPane.showMessageDialog(null, "A field can not be empty!", "Michael:",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try {
			Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
			Statement myStmt = myConn.createStatement();
			myConn = DriverManager.getConnection(jdbcURL, username, password);

			String SQLCheck = "SELECT * FROM commands WHERE Command ='" + "MICHAEL " + addCommand + "'";
			ResultSet myRs = myStmt.executeQuery(SQLCheck);

			if (myRs.next()) {
				JOptionPane.showMessageDialog(null, "Command already exists", "MICHAEL",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			} else {

				myStmt.execute(("INSERT INTO commands (Command, Execute, Label, Preinstalled) VALUES('" + "MICHAEL "
						+ addCommand.toUpperCase() + "', ' " + addLocation + "', ' " + addAction + "'," + "'0')"));

				JOptionPane.showMessageDialog(null, "Command added!", "MICHAEL", JOptionPane.INFORMATION_MESSAGE);
				GUIMichael.addCommand.setText("");
				GUIMichael.addAction.setText("");
				GUIMichael.addLocation.setText("");
				myConn.close();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection error!", "MICHAEL", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Update command
	 */
	public static void updateCommand() {
		String chaneCommand = GUIMichael.changeCommand.getSelectedItem().toString();
		String changeAction = GUIMichael.changeAction.getText();
		String changeLocation = GUIMichael.changeLocation.getText();

		if (chaneCommand.isEmpty() || changeAction.isEmpty() || changeLocation.isEmpty()) {
			JOptionPane.showMessageDialog(null, "A field can not be empty!", "Michael:",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try {
			Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
			String SQLUpdate = "UPDATE commands SET Execute ='" + changeLocation + "', Label ='" + changeAction
					+ "' where Command ='" + chaneCommand + "'";
			PreparedStatement prepStm = myConn.prepareStatement(SQLUpdate);
			prepStm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Command updated!", "Michael:", JOptionPane.INFORMATION_MESSAGE);
			GUIMichael.changeAction.setText("");
			GUIMichael.changeLocation.setText("");
			GUIMichael.model.fireTableDataChanged();
			myConn.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error updating command!", "Michael:", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public static void removeCommand() {
		String removeCommand = GUIMichael.removeCommand.getSelectedItem().toString();

		try {
			Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
			String SQLRemove = "DELETE from commands WHERE Command ='" + removeCommand + "'";
			PreparedStatement prepStm = myConn.prepareStatement(SQLRemove);
			prepStm.execute();

			JOptionPane.showMessageDialog(null, "Command removed!", "Michael:", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error removing command!", "Michael:", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static boolean isURL(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
