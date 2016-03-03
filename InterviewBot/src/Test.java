import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import design.GhostText;

/**
 * Images link: http://www.flaticon.com/free-icon/right-arrow_8767
 * @author Alex
 *
 */

public class Test extends JApplet {
		
	public static final long serialVersionUID = -2803431175048406077L;
	public JPanel panel;
	
	/**
	 * LOGIN MENU
	 */
	private JTextField username; 
	private JPasswordField password; 
	private JButton login, passwordButton; 
	private JCheckBox remember; 
	private JLabel checkMessage;
	
	
	/**
	 * IntervieweeMenu
	 */
	private JLabel interviewees, intervieweeOneName, intervieweeOneInfo,
	intervieweeTwoName, intervieweeTwoInfo, intervieweeThreeName, intervieweeThreeInfo,
	intervieweeFourName, intervieweeFourInfo;
	
	private JButton intervieweeOneButton, intervieweeTwoButton, intervieweeThreeButton, intervieweeFourButton;
	
	
	private static HashMap<String, String> data = new HashMap<String, String>();
	private static ArrayList<String> keywords = new ArrayList<String>();
		
	public static void main(String[] args) {
		Test test = new Test();
	}
	
	public static void init(String[] args) {
	}
	
	public Test() {
		panel = new JPanel();
		setContentPane(new JLabel(new ImageIcon("../images/login/loginBackground.png")));
		
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setOpaque(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(textArea);
	    scroll.setBounds(40, 45, 245, 310);
	    scroll.setOpaque(false);
	    scroll.getViewport().setOpaque(false);
	    scroll.setBorder(null);
	    scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
	    textArea.setForeground(Color.WHITE);
	    
	    loadLogin();
	    loadListeners();
	    addLoginContentToPane();
	}
	
	private void loadIntervieweeMenu() {
		setContentPane(new JLabel(new ImageIcon("../images/login/intervieweeMenu.png")));
		getContentPane().revalidate();
		getContentPane().repaint();
		
		interviewees = new JLabel("INTERVIEWEES");
		interviewees.setBounds(100, 13, 150, 20);
		interviewees.setFont(new Font(interviewees.getFont().getName(), interviewees.getFont().getStyle(), 20));
		interviewees.setForeground(Color.LIGHT_GRAY);
		
		
		/**
		 * Interviewee One
		 */
		intervieweeOneName = new JLabel("Interviewee Name");
		intervieweeOneName.setBounds(100, 80, 150, 20);
		intervieweeOneName.setFont(new Font(intervieweeOneName.getFont().getName(), intervieweeOneName.getFont().getStyle(), 16));
		intervieweeOneName.setForeground(Color.LIGHT_GRAY);
		intervieweeOneName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeOneInfo = new JLabel("Interviewee Information");
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
		intervieweeTwoName = new JLabel("Interviewee Name");
		intervieweeTwoName.setBounds(100, 175, 150, 20);
		intervieweeTwoName.setFont(new Font(intervieweeTwoName.getFont().getName(), intervieweeTwoName.getFont().getStyle(), 16));
		intervieweeTwoName.setForeground(Color.LIGHT_GRAY);
		intervieweeTwoName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeTwoInfo = new JLabel("Interviewee Information");
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
		intervieweeThreeName = new JLabel("Interviewee Name");
		intervieweeThreeName.setBounds(100, 275, 150, 20);
		intervieweeThreeName.setFont(new Font(intervieweeThreeName.getFont().getName(), intervieweeThreeName.getFont().getStyle(), 16));
		intervieweeThreeName.setForeground(Color.LIGHT_GRAY);
		intervieweeThreeName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeThreeInfo = new JLabel("Interviewee Information");
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
		intervieweeFourName = new JLabel("Interviewee Name");
		intervieweeFourName.setBounds(100, 370, 150, 20);
		intervieweeFourName.setFont(new Font(intervieweeFourName.getFont().getName(), intervieweeFourName.getFont().getStyle(), 16));
		intervieweeFourName.setForeground(Color.LIGHT_GRAY);
		intervieweeFourName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		intervieweeFourInfo = new JLabel("Interviewee Information");
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
		
		addIntervieweeContentToPane();
	}
	
	
	private void loadLogin() {
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
	}
	
	private void loadListeners() {
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadIntervieweeMenu();
			}
		});
	}
	
	private void addLoginContentToPane() {
		getContentPane().add(password);
		getContentPane().add(username);
		getContentPane().add(remember);
		getContentPane().add(checkMessage);
		getContentPane().add(passwordButton);
		getContentPane().add(login);
		getContentPane().add(panel);
	}
	
	private void addIntervieweeContentToPane() {
		getContentPane().add(interviewees);

		getContentPane().add(intervieweeOneName);
		getContentPane().add(intervieweeOneInfo);
		getContentPane().add(intervieweeOneButton);
		
		getContentPane().add(intervieweeTwoName);
		getContentPane().add(intervieweeTwoInfo);
		getContentPane().add(intervieweeTwoButton);
		
		getContentPane().add(intervieweeThreeName);
		getContentPane().add(intervieweeThreeInfo);
		getContentPane().add(intervieweeThreeButton);
		
		getContentPane().add(intervieweeFourName);
		getContentPane().add(intervieweeFourInfo);
		getContentPane().add(intervieweeFourButton);
	}
}

