package design;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import message.Message;
import user.Account;

public class ChatPane extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<JTextArea> messages = new ArrayList<JTextArea>();
	
    public ArrayList<JTextArea> getMessages() {
		return messages;
	}

	public ChatPane(Account account) {

    	int size = 0;
		
		for (int i = 0; i < account.getMessages().size(); i++) {
    		messages.add(new JTextArea(account.getMessages().get(i).getMessage()));
    		size += (int) messages.get(i).getSize().height;
    	}
		
    	System.out.println(size);
    	
    	setLayout(null);
    	setOpaque(false);
    	setPreferredSize(new Dimension(310, Chat.getCurrentSize()/2));
    	
    	
    	for (int i = 0; i < messages.size(); i++) {
    		JTextArea messageBefore = i == 0 ? messages.get(i) : messages.get(i-1);
    		JTextArea textArea = messages.get(i);
    		Message message = account.getMessages().get(i);
    		if (!message.isResponse()) {
    			textArea.setBounds(60, (messageBefore.getY() + messageBefore.getHeight() + 5), 250, 50);
    			//System.out.println("1: " + (messageBefore.getY()  + messageBefore.getHeight() + 5));
    			Chat.setCurrentSize(Chat.getCurrentSize() + (messageBefore.getHeight() + 5));
    		} else {
    			textArea.setBounds(10, (messageBefore.getY()  + messageBefore.getHeight() + 5), 250, 50);
    			//System.out.println("2: " + (messageBefore.getY()  + messageBefore.getHeight() + 5));
    			Chat.setCurrentSize(Chat.getCurrentSize() + (messageBefore.getHeight() + 5));
    		}
    		textArea.setLineWrap(true);
    		textArea.setWrapStyleWord(true);
    		textArea.setForeground(Color.LIGHT_GRAY);
    		textArea.setEditable(false);
    		textArea.setBackground(new Color(31, 51, 77));
    		Border border = BorderFactory.createLineBorder(new Color(31, 51, 77), 10);
    		textArea.setBorder(border);
    		textArea.setSize(250, (int) textArea.getPreferredSize().getHeight());

    		size += textArea.getPreferredSize().height;
    		
    		add(textArea);
    	}
    }
}