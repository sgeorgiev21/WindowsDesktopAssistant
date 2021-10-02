package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LookAndFeel {
	static Font cyberFont;

	public static Font cyberFont() throws FontFormatException, IOException {
		try {
			cyberFont = Font.createFont(Font.TRUETYPE_FONT, new File(
					"C:\\Stoyan\\Workspace\\Java\\WindowsDesktopAssistant\\src\\resources\\files\\good-times.ttf"))
					.deriveFont(15f);
		} catch (Exception e) {
			cyberFont = new Font("Verdana", Font.PLAIN, 10);
		}
		return cyberFont;
	}

	public static Font cyberFontPane() throws FontFormatException, IOException {
		try {
			cyberFont = Font.createFont(Font.TRUETYPE_FONT, new File(
					"C:\\Stoyan\\Workspace\\Java\\WindowsDesktopAssistant\\src\\resources\\files\\good-times.ttf"))
					.deriveFont(13f);
		} catch (Exception e) {
			cyberFont = new Font("Verdana", Font.PLAIN, 10);
		}
		return cyberFont;
	}
	
	
	public static Font cyberFontBtn() throws FontFormatException, IOException {
		try {
			cyberFont = Font.createFont(Font.TRUETYPE_FONT, new File(
					"C:\\Stoyan\\Workspace\\Java\\WindowsDesktopAssistant\\src\\resources\\files\\good-times.ttf"))
					.deriveFont(12f);
		} catch (Exception e) {
			cyberFont = new Font("Verdana", Font.PLAIN, 10);
		}
		return cyberFont;
	}

	@SuppressWarnings("serial")
	class myFontLabel extends JLabel {
		public void paint(Graphics g) {
			try {
				super.setFont(cyberFont());
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.setForeground(new Color(149, 209, 214));
			super.setSize(400, 30);
			super.paint(g);
		}
	}

	@SuppressWarnings("serial")
	class myFontTextField extends JTextField {
		public void paint(Graphics g) {
			try {
				super.setFont(cyberFont());
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.setSize(200, 20);
			super.setForeground(new Color(149, 209, 214));
			super.setBackground(new Color(3, 5, 30));
			super.setBorder(null);
			super.paint(g);
		}
	}

	@SuppressWarnings("serial")
	class jGradientPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			int xWidth = getWidth();
			int yHeight = getHeight();
			Color xColor = new Color(3, 5, 30);
			Color yColor = new Color(35, 51, 80);
			GradientPaint gp = new GradientPaint(0, 0, yColor, 0, yHeight, xColor);
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, xWidth, yHeight);
		}
	}

	@SuppressWarnings("serial")
	class jGradientPanelTop extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			int xWidth = getWidth();
			int yHeight = getHeight();
			Color xColor = new Color(3, 5, 30);
			Color yColor = new Color(35, 51, 80);
			GradientPaint gp = new GradientPaint(0, 0, xColor, 0, yHeight, yColor);
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, xWidth, yHeight);
		}
	}

	@SuppressWarnings("serial")
	class jGradientTab extends JTabbedPane {
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			int xWidth = getWidth();
			int yHeight = getHeight();
			Color xColor = new Color(3, 5, 30);
			Color yColor = new Color(35, 51, 80);
			GradientPaint gp = new GradientPaint(0, 0, yColor, 0, yHeight, xColor);
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, xWidth, yHeight);

			super.setFont(cyberFont);
			super.setForeground(new Color(149, 209, 214));
			super.setBackground(yColor);

			Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
			insets.top = -1;
			UIManager.put("TabbedPane.contentBorderInsets", insets);

			super.paintComponent(g);
		}
	}

	@SuppressWarnings("serial")
	class myJTable extends JTable {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	}

	@SuppressWarnings("serial")
	class myJButton extends JButton{
		public void LnF() {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(Exception e){
				
			}
		}
	}
}
