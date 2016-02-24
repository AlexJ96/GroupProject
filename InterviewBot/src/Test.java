import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("unused")
public class Test extends JApplet {
	
	public static final long serialVersionUID = -2803431175048406077L;
	public JPanel panel;
	
	public static void main(String[] args) {
		init(args);
	}
	
	public static void init(String[] args) {
			Test test = new Test();
			test.setVisible(true);
	}
	
	public Test() {
		
		panel = new JPanel();
		
		JTextArea textField = new JTextArea();
		textField.setEditable(true);
		
		JTextArea messageField = new JTextArea();
		messageField.setEditable(true);
		messageField.setBounds(20, 340, 455, 40);
		
		JScrollPane scroll = new JScrollPane(textField);
	    scroll.setBounds(20, 20, 500, 300);
	    
	    JButton clear = new JButton("Clear");
	    clear.setBounds(480, 340, 40, 20);
	    
	    JButton send = new JButton("Send");
	    send.setBounds(480, 361, 40, 20);
	    
	    getContentPane().add(scroll);
	    getContentPane().add(clear);
	    getContentPane().add(send);
	    getContentPane().add(messageField);
	    getContentPane().add(panel);
	    
		setVisible(true);
	}
	
}