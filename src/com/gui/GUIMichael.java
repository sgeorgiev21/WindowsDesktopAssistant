package com.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.FontFormatException;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import com.Engines.DataBaseEngine;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;

public class GUIMichael extends LookAndFeel {

	public static JFrame mainFrame;
	public static JButton btnSound;
	public static JLabel lblCon;
	public static DecimalFormat d2 = new DecimalFormat("0.00");
	public static File[] roots = File.listRoots();
	public static JTextField addCommand;
	public static JTextField addAction;
	public static JTextField addLocation;
	public static JComboBox<String> changeCommand;
	public static JTextField changeAction;
	public static JTextField changeLocation;
	public static JComboBox<String> removeCommand;
	public static DefaultTableModel model;
	public static JTable commandTable;
	public static JTabbedPane tabbedPane;
	public static boolean isSoundOn = true;

	public void CallMichael() throws FontFormatException, IOException {
		initialize();
	}

	private void initialize() throws FontFormatException, IOException {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 700, 500);
		mainFrame.setUndecorated(true);

		/**
		 * Controls panel
		 */
		JPanel controlsPane = new jGradientPanelTop();
		mainFrame.getContentPane().add(controlsPane, BorderLayout.NORTH);
		controlsPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		lblCon = new JLabel("");
		lblCon.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/noconnection.png")));
		controlsPane.add(lblCon);

		btnSound = new JButton();
		btnSound.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/sound1.png")));
		btnSound.setBorder(null);
		btnSound.setMargin(new Insets(0, 0, 0, 0));
		btnSound.setContentAreaFilled(false);
		btnSound.setFocusPainted(false);
		controlsPane.add(btnSound);

		JButton btnMini = new JButton("");
		btnMini.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/btnMini1.png")));
		btnMini.setBorder(null);
		btnMini.setMargin(new Insets(0, 0, 0, 0));
		btnMini.setContentAreaFilled(false);
		btnMini.setFocusPainted(false);
		controlsPane.add(btnMini);

		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/btnExit1.png")));
		btnExit.setBorder(null);
		btnExit.setMargin(new Insets(0, 0, 0, 0));
		btnExit.setContentAreaFilled(false);
		btnExit.setFocusPainted(false);
		controlsPane.add(btnExit);

		tabbedPane = new jGradientTab();
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		/**
		 * Main panel
		 */
		JPanel michaelPane = new jGradientPanel();
		tabbedPane.addTab("Michael", null, michaelPane, null);

		JLabel lblMichael = new myFontLabel();
		lblMichael.setText("Michael - Windows Desktop Assistant");
		lblMichael.setBounds(60, 350, 400, 30);
		michaelPane.add(lblMichael);
		michaelPane.setLayout(null);

		JLabel lblGif = new JLabel("");
		lblGif.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/AIM.gif")));
		lblGif.setBounds(0, 50, 400, 300);
		michaelPane.add(lblGif);

		/**
		 * Information panel
		 */
		JPanel infoPane = new jGradientPanel();
		tabbedPane.addTab("Information", null, infoPane, null);
		infoPane.setLayout(null);

		JLabel lblUsr = new myFontLabel();
		lblUsr.setText("Username: " + System.getProperty("user.name"));
		lblUsr.setBounds(75, 15, 86, 14);
		infoPane.add(lblUsr);

		JLabel lblPCname = new myFontLabel();
		lblPCname.setText("Computer name: " + (System.getenv("COMPUTERNAME")));
		lblPCname.setBounds(75, 50, 206, 14);
		infoPane.add(lblPCname);

		JLabel lblOperationSystem = new myFontLabel();
		lblOperationSystem.setText("Operation system: " + System.getProperty("os.name"));
		lblOperationSystem.setBounds(75, 85, 182, 14);
		infoPane.add(lblOperationSystem);

		JLabel lblProcessorArchitecture = new myFontLabel();
		lblProcessorArchitecture.setText("Processor Architecture: " + (System.getenv("PROCESSOR_ARCHITECTURE")));
		lblProcessorArchitecture.setBounds(75, 120, 206, 14);
		infoPane.add(lblProcessorArchitecture);

		JLabel lblNumberOfCores = new myFontLabel();
		lblNumberOfCores.setText("Number of cores: " + Runtime.getRuntime().availableProcessors());
		lblNumberOfCores.setBounds(75, 155, 213, 14);
		infoPane.add(lblNumberOfCores);

		JLabel lblUsableRam = new myFontLabel();
		lblUsableRam.setText("Usable RAM: " + (Runtime.getRuntime().totalMemory() / 1073741824.0) + " GB");
		lblUsableRam.setBounds(75, 190, 213, 14);
		infoPane.add(lblUsableRam);

		JLabel lblTotalDiskSpace = new myFontLabel();
		lblTotalDiskSpace.setText("Total Disk Space: " + (long) (new File("/").getTotalSpace() / 1073741824.0) + " GB");
		lblTotalDiskSpace.setBounds(75, 225, 213, 14);
		infoPane.add(lblTotalDiskSpace);

		JLabel lblFreeDiskSpace = new myFontLabel();
		lblFreeDiskSpace.setText("Free Disk Space: " + (long) (new File("/").getFreeSpace() / 1073741824.0) + " GB");
		lblFreeDiskSpace.setBounds(75, 260, 213, 14);
		infoPane.add(lblFreeDiskSpace);

		JLabel lblAllDrives = new myFontLabel();
		lblAllDrives.setText("All drives: " + allDrives());
		lblAllDrives.setBounds(75, 295, 213, 14);
		infoPane.add(lblAllDrives);

		/**
		 * Commands panel
		 */
		JPanel commandsPane = new jGradientPanel();
		commandsPane.setLayout(new CardLayout());
		tabbedPane.addTab("Commands", null, commandsPane, null);

		model = new DefaultTableModel();
		model.addColumn("COMMAND");
		model.addColumn("ACTION");

		commandTable = new myJTable();
		commandTable.setModel(model);
		commandTable.setBackground((new Color(35, 51, 80)));
		commandTable.setFont(LookAndFeel.cyberFontPane());
		commandTable.setForeground(new Color(149, 209, 214));
		commandTable.getTableHeader().setFont(LookAndFeel.cyberFont());
		commandTable.getTableHeader().setForeground(new Color(149, 209, 214));
		commandTable.getTableHeader().setBackground(new Color(3, 5, 30));
		commandTable.setSize(500, 495);

		String jdbcURL = "jdbc:mysql://localhost:3306/michaeldb?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "root";
		String password = "admin";

		try {
			Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
			Statement myStmt = myConn.createStatement();
			myConn = DriverManager.getConnection(jdbcURL, username, password);
			String sqlString = ("SELECT * FROM commands");
			ResultSet myRS = myStmt.executeQuery(sqlString);

			while (myRS.next()) {
				String command = myRS.getString("Command");
				String action = myRS.getString("Label");
				model.addRow(new Object[] { command, action });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane tableScroll = new JScrollPane();
		tableScroll.setBounds(0, 0, 515, 495);
		tableScroll.setViewportView(commandTable);
		tableScroll.getViewport().setBackground((new Color(35, 51, 80)));
		commandsPane.setLayout(null);
		commandsPane.add(tableScroll);

		/**
		 * Add commands panel
		 */
		JPanel addCommandPane = new jGradientPanel();
		tabbedPane.addTab("Add command", null, addCommandPane, null);
		addCommandPane.setLayout(null);

		JLabel lblNewCommand = new myFontLabel();
		lblNewCommand.setText("Add new command");
		lblNewCommand.setBounds(35, 25, 161, 14);
		addCommandPane.add(lblNewCommand);

		JLabel lblAction = new myFontLabel();
		lblAction.setText("Action");
		lblAction.setBounds(35, 60, 161, 14);
		addCommandPane.add(lblAction);

		JLabel lblLocation = new myFontLabel();
		lblLocation.setText("Location");
		lblLocation.setBounds(35, 95, 161, 14);
		addCommandPane.add(lblLocation);

		addCommand = new myFontTextField();
		addCommand.setBounds(250, 30, 200, 20);
		addCommand.setColumns(10);
		addCommandPane.add(addCommand);

		addAction = new myFontTextField();
		addAction.setColumns(10);
		addAction.setBounds(250, 65, 200, 20);
		addCommandPane.add(addAction);

		addLocation = new myFontTextField();
		addLocation.setColumns(10);
		addLocation.setBounds(250, 100, 200, 20);
		addCommandPane.add(addLocation);

		JButton btnBrowse = new JButton("");
		btnBrowse.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/browse.png")));
		btnBrowse.setBorder(null);
		btnBrowse.setMargin(new Insets(0, 0, 0, 0));
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setFocusPainted(false);
		btnBrowse.setBounds(420, 97, 89, 27);
		addCommandPane.add(btnBrowse);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(200, 130, 115, 25);
		btnAdd.setFocusPainted(false);
		btnAdd.setBackground(new Color(3, 5, 30));
		btnAdd.setFont(cyberFontBtn());
		btnAdd.setForeground(new Color(149, 209, 214));
		addCommandPane.add(btnAdd);

		JLabel lblPossibleCommands = new myFontLabel();
		lblPossibleCommands.setText("Possible commands and combinations");
		lblPossibleCommands.setBounds(80, 195, 304, 14);
		addCommandPane.add(lblPossibleCommands);

		JTextArea possibleCommands = new JTextArea();
		possibleCommands.setBounds(10, 220, 625, 191);
		possibleCommands.setFont(LookAndFeel.cyberFont());
		possibleCommands.setForeground(new Color(79, 165, 212));
		possibleCommands.setBackground(new Color(35, 51, 80));
		possibleCommands.setEditable(false);
		FileReader fReader = new FileReader(
				"C:\\Stoyan\\Workspace\\Java\\WindowsDesktopAssistant\\src\\resources\\files\\mAvaib.txt");
		possibleCommands.read(fReader, "possiblecommands.txt");
		;

		JScrollPane textAreaScroll = new JScrollPane();
		textAreaScroll.setViewportView(possibleCommands);
		textAreaScroll.setBounds(0, 220, 592, 264);
		addCommandPane.add(textAreaScroll);

		/**
		 * Change command panel
		 */
		JPanel changeCommandPane = new jGradientPanel();
		tabbedPane.addTab("Change command", null, changeCommandPane, null);
		changeCommandPane.setLayout(null);

		JLabel lblChange = new myFontLabel();
		lblChange.setText("Change command");
		lblChange.setBounds(50, 40, 159, 14);
		changeCommandPane.add(lblChange);

		JLabel lblChangeAction = new myFontLabel();
		lblChangeAction.setText("Change Action");
		lblChangeAction.setBounds(50, 75, 159, 14);
		changeCommandPane.add(lblChangeAction);

		JLabel lblChangeLocation = new myFontLabel();
		lblChangeLocation.setText("Change Location");
		lblChangeLocation.setBounds(50, 110, 159, 14);
		changeCommandPane.add(lblChangeLocation);

		changeCommand = new JComboBox<String>();
		changeCommand.setBounds(235, 45, 200, 20);
		changeCommand.setForeground(new Color(149, 209, 214));
		changeCommand.setBackground(new Color(3, 5, 30));
		changeCommand.setFont(cyberFontPane());
		changeCommandPane.add(changeCommand);

		try {
			Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
			Statement myStmt = myConn.createStatement();
			myConn = DriverManager.getConnection(jdbcURL, username, password);
			String sqlString = ("SELECT * FROM commands WHERE Preinstalled = '0'");
			ResultSet myRS = myStmt.executeQuery(sqlString);

			while (myRS.next()) {
				String command = myRS.getString("Command");
				changeCommand.addItem(command);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		changeAction = new myFontTextField();
		changeAction.setColumns(10);
		changeAction.setBounds(235, 80, 86, 20);
		changeCommandPane.add(changeAction);

		changeLocation = new myFontTextField();
		changeLocation.setColumns(10);
		changeLocation.setBounds(235, 115, 86, 20);
		changeCommandPane.add(changeLocation);

		JButton btnBrowsechange = new JButton();
		btnBrowsechange.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/browse.png")));
		btnBrowsechange.setBorder(null);
		btnBrowsechange.setMargin(new Insets(0, 0, 0, 0));
		btnBrowsechange.setContentAreaFilled(false);
		btnBrowsechange.setFocusPainted(false);
		btnBrowsechange.setBounds(405, 112, 89, 27);
		changeCommandPane.add(btnBrowsechange);

		JLabel lblRemove = new myFontLabel();
		lblRemove.setText("Remove Command");
		lblRemove.setBounds(50, 215, 143, 14);
		changeCommandPane.add(lblRemove);

		removeCommand = new JComboBox<String>();
		removeCommand.setBounds(245, 220, 200, 20);
		removeCommand.setForeground(new Color(149, 209, 214));
		removeCommand.setBackground(new Color(3, 5, 30));
		removeCommand.setFont(cyberFontPane());
		changeCommandPane.add(removeCommand);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBackground(new Color(3, 5, 30));
		btnUpdate.setFont(cyberFontBtn());
		btnUpdate.setBounds(190, 150, 115, 25);
		btnUpdate.setForeground(new Color(149, 209, 214));
		changeCommandPane.add(btnUpdate);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(190, 255, 115, 25);
		btnRemove.setFocusPainted(false);
		btnRemove.setBackground(new Color(3, 5, 30));
		btnRemove.setFont(cyberFontBtn());
		btnRemove.setForeground(new Color(149, 209, 214));
		changeCommandPane.add(btnRemove);

		try {
			Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
			Statement myStmt = myConn.createStatement();
			myConn = DriverManager.getConnection(jdbcURL, username, password);
			String sqlString = ("SELECT * FROM commands WHERE Preinstalled = '0'");
			ResultSet myRS = myStmt.executeQuery(sqlString);

			while (myRS.next()) {
				String command = myRS.getString("Command");
				removeCommand.addItem(command);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * ACTIONS
		 */

		controlsPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				mainFrame.setLocation(e.getXOnScreen(), e.getYOnScreen());
				;
			}
		});

		btnMini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnMini.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/btnMini2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMini.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/btnMini1.png")));
			}
		});

		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/btnExit2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/btnExit1.png")));
			}
		});

		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DataBaseEngine.addCommand();
			}
		});

		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DataBaseEngine.updateCommand();
				changeCommand.removeAll();
			}
		});

		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DataBaseEngine.removeCommand();
			}
		});

		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JFileChooser chosenFile = new JFileChooser();
					chosenFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					int returnValue = chosenFile.showOpenDialog(null);

					if (returnValue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = chosenFile.getSelectedFile();
						String stringPath = selectedFile.getAbsolutePath();
						String finalPath = stringPath.replaceAll("\\\\", "\\\\\\\\\\\\\\\\\\\\");
						addLocation.setText(finalPath);
					}
				} catch (Exception UIExc) {

				}
			}
		});

		btnBrowsechange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JFileChooser chosenFile = new JFileChooser();
					chosenFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					int returnValue = chosenFile.showOpenDialog(null);

					if (returnValue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = chosenFile.getSelectedFile();
						String stringPath = selectedFile.getAbsolutePath();
						String finalPath = stringPath.replaceAll("\\\\", "\\\\\\\\\\\\\\\\\\\\");
						changeLocation.setText(finalPath);
					}
				} catch (Exception UIExc) {

				}
			}
		});

		mainFrame.setVisible(true);

		btnSound.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isSoundOn =!isSoundOn;
				btnSound.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/sound2.png")));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(isSoundOn)
				btnSound.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/sound3.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(isSoundOn)
				btnSound.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/sound1.png")));
			}
		});

		controlsPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				checkCon();
			}
		});

	}

	public static String allDrives() {
		String allDrives = null;
		for (File root : roots) {
			allDrives = (root.getAbsolutePath()) + " " + d2.format((root.getFreeSpace() / 1073741824.0)) + " GB" + "/"
					+ d2.format((root.getTotalSpace() / 1073741824.0)) + " GB" + "\n";
		}
		return allDrives;

	}

	public static void checkCon() {
		try {
			URL url = new URL("http://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			GUIMichael.lblCon.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/connection.png")));
			GUIMichael.lblCon.setToolTipText("Internet connection");
		} catch (IOException e) {
			GUIMichael.lblCon.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/noconnection.png")));
			;
			GUIMichael.lblCon.setToolTipText("No internet connection");
		}
	}

}