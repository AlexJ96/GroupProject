package design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import thread.SendMessageThread;
import thread.SendResponseThread;
import user.Account;

public class Chat {
	
	private static Window window;
	private static JButton send, backArrow, menuButton, settingsButton;;
	private static JTextArea sendMessage;
	private static JLabel userTyping; 
	private static JScrollPane scrollPane;
	private static Account account;
	private static int currentSize = 0;
	
	public static int getCurrentSize() {
		return currentSize;
	}
	
	public static void setCurrentSize(int size) {
		currentSize = size;
	}
	
	public static JTextArea getSendMessage() {
		return sendMessage;
	}
	
	public static JLabel getUserTyping() {
		return userTyping;
	}
	
	public static void loadChat(Window window, Account account) {
		Chat.window = window;
		Chat.account = account;
		
		window.setContentPane(new JLabel(new ImageIcon("../images/chat/chatMenu.png")));
	    
		ChatPane cPane = new ChatPane(account);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 55, 320, 290);
		scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.setBorder(null);
	    scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
	    scrollPane.setViewportView(cPane);
	    //scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	    
	    if (cPane.getMessages().size() > 1)
	    	scrollPane.scrollRectToVisible(cPane.getMessages().get(cPane.getMessages().size() -1).getBounds());
	    
	    //System.out.println("Current Size:" + getCurrentSize() + " VALUE: " + scrollPane.getVerticalScrollBar().getValue());
	    
	    
	    
	    
	    // int height = (int)cPane.getPreferredSize().getHeight();
        //scrollPane.getVerticalScrollBar().setValue(height);
	    //if (cPane.getMessages().size() > 0)
	    	//scrollPane.getViewport().setViewPosition(new Point(0, getCurrentSize() / 15));
	    	//scrollPane.scrollRectToVisible(cPane.getMessages().get(cPane.getMessages().size()-1).getBounds());
	    
	    send = new JButton("SEND");
	    send.setBounds(255, 400, 50, 20);
		send.setForeground(Color.LIGHT_GRAY);
		send.setCursor(new Cursor(Cursor.HAND_CURSOR));
		send.setBorder(null);
		send.setFont(new Font(send.getFont().getName(), Font.PLAIN, 16));
		
		sendMessage = new JTextArea();
		sendMessage.setBounds(20, 385, 200, 40);
		sendMessage.setForeground(Color.LIGHT_GRAY);
		sendMessage.setCaretColor(Color.LIGHT_GRAY);
		GhostText sendMessageGhost = new GhostText(sendMessage, "Type message...");
		sendMessage.setOpaque(false);
		sendMessage.setBorder(null);
		sendMessage.setLineWrap(true);
		sendMessage.setWrapStyleWord(true);
		
		JScrollPane sendMessageScroll = new JScrollPane(sendMessage);
		sendMessageScroll.setBounds(20, 385, 200, 40);
		sendMessageScroll.setOpaque(false);
		sendMessageScroll.setBorder(null);
		sendMessageScroll.getViewport().setOpaque(false);
		sendMessageScroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		
		userTyping = new JLabel("Liam is typing.");
		userTyping.setBounds(20, 350, 200, 20);
		userTyping.setForeground(Color.LIGHT_GRAY);
		userTyping.setVisible(false);
		
		addInterfaceButtons();

		window.getContentPane().add(send);
		window.getContentPane().add(sendMessageScroll);
		window.getContentPane().add(backArrow);
		window.getContentPane().add(menuButton);
		window.getContentPane().add(settingsButton);
		window.getContentPane().add(scrollPane);
		window.getContentPane().add(userTyping);
		
		loadSendListeners();

		window.getContentPane().revalidate();
		window.getContentPane().repaint();
	}
	
	private static void addInterfaceButtons() {
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
	
	private static void loadSendListeners() {
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = sendMessage.getText();
				sendMessage.setEditable(false);
				SendMessageThread sMT = new SendMessageThread(window, account, sendMessage.getText());
				SendResponseThread sRT = new SendResponseThread(window, account, message);
			}
		});
		
		backArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interviewee.loadInterviewee(window, account);
			}
		});
		
		sendMessage.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
				    e.consume();
				    String message = sendMessage.getText();
					sendMessage.setEditable(false);
					SendMessageThread sMT = new SendMessageThread(window, account, sendMessage.getText());
					SendResponseThread sRT = new SendResponseThread(window, account, message);
				}	
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
			
			}
		});
	}
}
