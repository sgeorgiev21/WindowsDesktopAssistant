package com.gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;


public class MTray {
public static TrayIcon MTray;
	
	public void initialize() {
		systemTrayM();
	}

	private void systemTrayM() {

		if (SystemTray.isSupported()) {

			SystemTray.getSystemTray();
			SystemTray systemTray = SystemTray.getSystemTray();

			PopupMenu popup = new PopupMenu();

			Image image = Toolkit.getDefaultToolkit()
					.getImage(MTray.class.getResource("/resources/image/trayIcon.gif"));
			MTray = new TrayIcon(image, "Michael", popup);
			MenuItem Michael = new MenuItem("Michael");
			MenuItem Mute = new MenuItem("Mute");
			MenuItem Exit = new MenuItem("Exit");

			popup.add(Michael);
			popup.add(Mute);
			popup.add(Exit);

			try {
				systemTray.add(MTray);

			} catch (AWTException e) {
				e.printStackTrace();
			}

/**
* Actions
*/
			Michael.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					GUIMichael.mainFrame.setVisible(true);
				}
			});
			
			Mute.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUIMichael.isSoundOn = !GUIMichael.isSoundOn;
					GUIMichael.btnSound.setIcon(new ImageIcon(GUIMichael.class.getResource("/resources/image/sound2.png")));
					
				}
			});
			
			Exit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});

		}
	}
}
