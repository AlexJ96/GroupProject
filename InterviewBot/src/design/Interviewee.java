package design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import user.Account;

public class Interviewee {
	
	private static Window window;
	private static JLabel interviewees, intervieweeOneName, intervieweeOneInfo,
	intervieweeTwoName, intervieweeTwoInfo, intervieweeThreeName, intervieweeThreeInfo,
	intervieweeFourName, intervieweeFourInfo;
	
	private static JButton intervieweeOneButton, intervieweeTwoButton, intervieweeThreeButton, 
	intervieweeFourButton, backArrow, menuButton, settingsButton;
	
	private static Account account;
	
	public static void loadInterviewee(Window window, Account account) {
		Interviewee.window = window;
		Interviewee.account = account; 
		window.setContentPane(new JLabel(new ImageIcon("../images/login/intervieweeMenu.png")));
		window.getContentPane().revalidate();
		window.getContentPane().repaint();
		
		interviewees = new JLabel("INTERVIEWEES");
		interviewees.setBounds(100, 13, 150, 20);
		interviewees.setFont(new Font(interviewees.getFont().getName(), interviewees.getFont().getStyle(), 20));
		interviewees.setForeground(Color.LIGHT_GRAY);
		
		
		/**
		 * Interviewee One
		 */
		intervieweeOneName = new JLabel("Liam Berridge");
		intervieweeOneName.setBounds(100, 80, 150, 20);
		intervieweeOneName.setFont(new Font(intervieweeOneName.getFont().getName(), intervieweeOneName.getFont().getStyle(), 16));
		intervieweeOneName.setForeground(Color.LIGHT_GRAY);
		intervieweeOneName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeOneInfo = new JLabel("ONLINE");
		intervieweeOneInfo.setBounds(100, 100, 150, 20);
		intervieweeOneInfo.setForeground(Color.LIGHT_GRAY);
		intervieweeOneInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeOneButton = new JButton();
		intervieweeOneButton.setIcon(new ImageIcon("../images/login/intervieweeOneButton.png"));
		intervieweeOneButton.setBounds(0, 52, 320, 95);
		intervieweeOneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		intervieweeOneButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	intervieweeOneButton.setIcon(new ImageIcon("../images/login/intervieweeButtonOnePressed.png"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	intervieweeOneButton.setIcon(new ImageIcon("../images/login/intervieweeOneButton.png"));
		    }
		});
		
		
		/**
		 * Interviewee Two
		 */
		intervieweeTwoName = new JLabel("Max Cussans");
		intervieweeTwoName.setBounds(100, 175, 150, 20);
		intervieweeTwoName.setFont(new Font(intervieweeTwoName.getFont().getName(), intervieweeTwoName.getFont().getStyle(), 16));
		intervieweeTwoName.setForeground(Color.LIGHT_GRAY);
		intervieweeTwoName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeTwoInfo = new JLabel("OFFLINE");
		intervieweeTwoInfo.setBounds(100, 195, 150, 20);
		intervieweeTwoInfo.setForeground(Color.LIGHT_GRAY);
		intervieweeTwoInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeTwoButton = new JButton();
		intervieweeTwoButton.setIcon(new ImageIcon("../images/login/intervieweeButtonTwo.png"));
		intervieweeTwoButton.setBounds(0, 148, 320, 95);
		intervieweeTwoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		intervieweeTwoButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	intervieweeTwoButton.setIcon(new ImageIcon("../images/login/intervieweeButtonTwoPressed.png"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	intervieweeTwoButton.setIcon(new ImageIcon("../images/login/intervieweeButtonTwo.png"));
		    }
		});
		
		/**
		 * Interviewee Three
		 */
		intervieweeThreeName = new JLabel("Daniel Martin");
		intervieweeThreeName.setBounds(100, 275, 150, 20);
		intervieweeThreeName.setFont(new Font(intervieweeThreeName.getFont().getName(), intervieweeThreeName.getFont().getStyle(), 16));
		intervieweeThreeName.setForeground(Color.LIGHT_GRAY);
		intervieweeThreeName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeThreeInfo = new JLabel("OFFLINE");
		intervieweeThreeInfo.setBounds(100, 295, 150, 20);
		intervieweeThreeInfo.setForeground(Color.LIGHT_GRAY);
		intervieweeThreeInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeThreeButton = new JButton();
		intervieweeThreeButton.setIcon(new ImageIcon("../images/login/intervieweeButtonThree.png"));
		intervieweeThreeButton.setBounds(0, 245, 320, 95);
		intervieweeThreeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		intervieweeThreeButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	intervieweeThreeButton.setIcon(new ImageIcon("../images/login/intervieweeButtonThreePressed.png"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	intervieweeThreeButton.setIcon(new ImageIcon("../images/login/intervieweeButtonThree.png"));
		    }
		});
		
		
		/**
		 * Interviewee Four
		 */
		intervieweeFourName = new JLabel("Alex Johnson");
		intervieweeFourName.setBounds(100, 370, 150, 20);
		intervieweeFourName.setFont(new Font(intervieweeFourName.getFont().getName(), intervieweeFourName.getFont().getStyle(), 16));
		intervieweeFourName.setForeground(Color.LIGHT_GRAY);
		intervieweeFourName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeFourInfo = new JLabel("OFFLINE");
		intervieweeFourInfo.setBounds(100, 390, 150, 20);
		intervieweeFourInfo.setForeground(Color.LIGHT_GRAY);
		intervieweeFourInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeFourButton = new JButton();
		intervieweeFourButton.setIcon(new ImageIcon("../images/login/intervieweeButtonFour.png"));
		intervieweeFourButton.setBounds(0, 342, 320, 95);
		intervieweeFourButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		intervieweeFourButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	intervieweeFourButton.setIcon(new ImageIcon("../images/login/intervieweeButtonFourPressed.png"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	intervieweeFourButton.setIcon(new ImageIcon("../images/login/intervieweeButtonFour.png"));
		    }
		});
		
		addInterfaceButtons();
		addIntervieweeContentToPane();
		loadIntervieweeListeners();
	}
	
	private static void addIntervieweeContentToPane() {
		window.getContentPane().add(interviewees);

		window.getContentPane().add(intervieweeOneName);
		window.getContentPane().add(intervieweeOneInfo);
		window.getContentPane().add(intervieweeOneButton);
		
		window.getContentPane().add(intervieweeTwoName);
		window.getContentPane().add(intervieweeTwoInfo);
		window.getContentPane().add(intervieweeTwoButton);
		
		window.getContentPane().add(intervieweeThreeName);
		window.getContentPane().add(intervieweeThreeInfo);
		window.getContentPane().add(intervieweeThreeButton);
		
		window.getContentPane().add(intervieweeFourName);
		window.getContentPane().add(intervieweeFourInfo);
		window.getContentPane().add(intervieweeFourButton);
		
		window.getContentPane().add(backArrow);
		window.getContentPane().add(menuButton);
		window.getContentPane().add(settingsButton);
	}
	
	public static void addInterfaceButtons() {
		/**
		 * BackArrow
		 */
		backArrow = new JButton();
		backArrow.setIcon(new ImageIcon("../images/login/backArrow.png"));
		backArrow.setBounds(25, 446, 24, 24);
		backArrow.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backArrow.setBorder(null);
		
		
		/**
		 * Settings Button
		 */
		settingsButton = new JButton();
		settingsButton.setIcon(new ImageIcon("../images/login/settings.png"));
		settingsButton.setBounds(275, 446, 24, 24);
		settingsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsButton.setBorder(null);
		
		/**
		 * Menu Button
		 */
		menuButton = new JButton();
		menuButton.setIcon(new ImageIcon("../images/login/menu.png"));
		menuButton.setBounds(18, 13, 24, 24);
		menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuButton.setBorder(null);
	}
	
	private static void loadIntervieweeListeners() {	
		backArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.loadLogin(window);
			}
		});
		
		intervieweeOneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Chat.loadChat(window, account);
			}
		});
	}
	
}
