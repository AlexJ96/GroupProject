import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import utils.DataReader;
import utils.KeywordReader;

@SuppressWarnings("unused")
public class Test extends JApplet {
	
	public static final long serialVersionUID = -2803431175048406077L;
	public JPanel panel;
	private JLabel title, availableCandidates, userOneName, userTwoName, userThreeName, instructions, instructionOne, instructionTwo, instructionThree;
	private JButton userOne, userTwo, userThree;
	private JTextArea messageField;
	
	private static HashMap<String, String> data = new HashMap<String, String>();
	private static ArrayList<String> keywords = new ArrayList<String>();
	
	public static void main(String[] args) {
	}
	
	public static void init(String[] args) {
	}
	
	public Test() {
		panel = new JPanel();
		
		title = new JLabel("<HTML><U>Live Interview Chat</U></HTML>");
		title.setBounds(20, 20, 120, 20);
		
		availableCandidates = new JLabel("Available Candidates:");
		availableCandidates.setBounds(60, 40, 180, 20);
		
		userOne = new JButton();
		userOne.setBounds(60, 60, 130, 130);
		userOne.setIcon(new ImageIcon("../images/blank-user.jpg"));
		
		userTwo = new JButton();
		userTwo.setBounds(190, 60, 130, 130);
		userTwo.setIcon(new ImageIcon("../images/blank-user.jpg"));
		
		userTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				initChat("userOne");
			}
		});
		
		userThree = new JButton();
		userThree.setBounds(320, 60, 130, 130);
		userThree.setIcon(new ImageIcon("../images/blank-user.jpg"));
		
		userThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				initChat("userOne");
			}
		});
		
		userOneName = new JLabel("NAME");
		userOneName.setBounds(105, 185, 40, 20);
		
		userTwoName = new JLabel("NAME");
		userTwoName.setBounds(235, 185, 40, 20);
		
		userThreeName = new JLabel("NAME");
		userThreeName.setBounds(365, 185, 40, 20);
		
		instructions = new JLabel("<HTML><U>Instructions</U></HTML>");
		instructions.setBounds(20, 280, 100, 20);
		
		instructionOne = new JLabel("1. Select an Interviewee");
		instructionOne.setBounds(40, 310, 150, 20);
		
		instructionTwo = new JLabel("2. Type your question");
		instructionTwo.setBounds(40, 340, 140, 20);
		
		instructionThree = new JLabel("3. Read the response or click the speaker symbol to hear the interviewee's response to your question");
		instructionThree.setBounds(40, 370, 700, 20);
		
		getContentPane().add(userThreeName);
		getContentPane().add(userTwoName);
		getContentPane().add(userOneName);
		getContentPane().add(userThree);
		getContentPane().add(userTwo);
		getContentPane().add(userOne);
		getContentPane().add(instructionThree);
		getContentPane().add(instructionTwo);
		getContentPane().add(instructionOne);
		getContentPane().add(instructions);
		getContentPane().add(availableCandidates);
		getContentPane().add(title);
	    getContentPane().add(panel);
	    
	    userOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				initChat("userOne");
				System.out.println("User 1 clicked");
			}
		});
	    

		data = DataReader.init();
		keywords = KeywordReader.init();
		setVisible(true);
	}
	
	private void initChat(String interviewee) {
		title.setVisible(false);
		availableCandidates.setVisible(false);
		userOne.setVisible(false);
		userTwo.setVisible(false);
		userThree.setVisible(false);
		userOneName.setVisible(false);
		userTwoName.setVisible(false);
		userThreeName.setVisible(false);
		instructions.setVisible(false);
		instructionOne.setVisible(false);
		instructionTwo.setVisible(false);
		instructionThree.setVisible(false);
		
		JTextArea textField = new JTextArea();
		textField.setEditable(true);
		
		messageField = new JTextArea();
		messageField.setEditable(true);
		messageField.setBounds(20, 340, 455, 40);
		
		JScrollPane scroll = new JScrollPane(textField);
	    scroll.setBounds(20, 20, 500, 300);
	    
	    JButton clear = new JButton("Clear");
	    clear.setBounds(480, 340, 40, 20);
	    
	    JButton send = new JButton("Send");
	    send.setBounds(480, 361, 40, 20);
	    
	    
	    send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				test();
				messageField.setText("");
			}
		});
    
	    
		getContentPane().add(scroll);
	    getContentPane().add(clear);
	    getContentPane().add(send);
	    getContentPane().add(messageField);
	    getContentPane().add(panel);
	    
	    validate();
	    repaint();
	    setVisible(true);
	   
	}
	
	private void test() {
		String question = messageField.getText();
		String phrase = "";
		for (String keyword : question.split(" ")) {
			for (String key_words : keywords) {
				if (keyword.equalsIgnoreCase(key_words)) {
					phrase += keyword;
				}
			}
		}
		if (data.containsKey(phrase)) {
			System.out.println(phrase);
			System.out.println(data.get(phrase));
		} else {
			System.out.println(phrase);
			System.out.println("Sorry I don't understand..");
		}
	}
	
}