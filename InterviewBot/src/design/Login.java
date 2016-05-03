package design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import user.Account;
import user.AccountManager;

public class Login {
	
	private static JTextField username; 
	private static JPasswordField password; 
	private static JButton login, passwordButton; 
	private static JCheckBox remember; 
	private static JLabel checkMessage;
	private static Window window;
	private static Account account;
	
	public static String getUsername() {
		return username.getText();
	}
	
	public static void loadLogin(Window window) {
		Login.window = window;
		
		username = new JTextField();
		username.setForeground(Color.LIGHT_GRAY);
		username.setCaretColor(Color.LIGHT_GRAY);
		GhostText usernameGhost = new GhostText(username, "Username");
		username.setBounds(110, 272, 130, 25);
		username.setOpaque(false);
		username.setBorder(null);
		
		password = new JPasswordField();
		password.setForeground(Color.LIGHT_GRAY);
		password.setCaretColor(Color.LIGHT_GRAY);
		GhostText passwordGhost = new GhostText(password, "Password");
		password.setBounds(110, 312, 130, 25);
		password.setOpaque(false);
		password.setBorder(null);
		
		remember = new JCheckBox();
		remember.setBounds(106, 352, 24, 24);
		remember.setIcon(new ImageIcon("../images/login/checkbox.png"));
		remember.setSelectedIcon(new ImageIcon("../images/login/checkboxSelected.png"));
		remember.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		checkMessage = new JLabel("Remember me");
		checkMessage.setBounds(135, 354, 100, 20);
		checkMessage.setForeground(Color.LIGHT_GRAY);
		
		login = new JButton();
		login.setBounds(63, 408, 195, 47);
		login.setIcon(new ImageIcon("../images/login/login.png"));
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		login.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        login.setIcon(new ImageIcon("../images/login/loginhover.png"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	login.setIcon(new ImageIcon("../images/login/login.png"));
		    }
		});
		
		passwordButton = new JButton("Forgot your password?");
		passwordButton.setForeground(Color.LIGHT_GRAY);
		passwordButton.setBounds(85, 380, 150, 20);
		passwordButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		passwordButton.setBorder(null);
		
		window.setContentPane(new JLabel(new ImageIcon("../images/login/loginBackground.png")));
		window.getContentPane().revalidate();
		window.getContentPane().repaint();
		
	    loadLoginListeners();
	    addLoginContentToPane();
	}
	
	private static void loadLoginListeners() {
		password.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
				    e.consume();
				    if (username.getText().isEmpty() || password.getPassword().toString().isEmpty() || username.getText().equalsIgnoreCase("username") || password.getPassword().toString().equalsIgnoreCase("password"))
						return;
					if (AccountManager.containsAccount(username.getText())) {
						account = AccountManager.loadAccount(username.getText());
						if (account.getPassword().equalsIgnoreCase(String.valueOf(password.getPassword())))
							Interviewee.loadInterviewee(window, account);
						else
							System.out.println(username.getText() + " " + String.valueOf(password.getPassword()) + " Wrong password");
					} else {
						account = new Account(username.getText(), String.valueOf(password.getPassword()));
						AccountManager.savePlayer(account);
						Interviewee.loadInterviewee(window, account);
					}
				}	
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
			
			}
		});
		
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (username.getText().isEmpty() || password.getPassword().toString().isEmpty() || username.getText().equalsIgnoreCase("username") || password.getPassword().toString().equalsIgnoreCase("password"))
					return;
				if (AccountManager.containsAccount(username.getText())) {
					account = AccountManager.loadAccount(username.getText());
					if (account.getPassword().equalsIgnoreCase(String.valueOf(password.getPassword())))
						Interviewee.loadInterviewee(window, account);
					else
						System.out.println(username.getText() + " " + String.valueOf(password.getPassword()) + " Wrong password");
				} else {
					account = new Account(username.getText(), String.valueOf(password.getPassword()));
					AccountManager.savePlayer(account);
					Interviewee.loadInterviewee(window, account);
				}
			}
		});
	}
	
	private static void addLoginContentToPane() {
		window.getContentPane().add(password);
		window.getContentPane().add(username);
		window.getContentPane().add(remember);
		window.getContentPane().add(checkMessage);
		window.getContentPane().add(passwordButton);
		window.getContentPane().add(login);
		//window.getContentPane().add(panel);
	}
	
}
