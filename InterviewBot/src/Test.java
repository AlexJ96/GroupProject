import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("unused")
public class Test extends JFrame {
	
	private static final long serialVersionUID = -2803431175048406077L;
	private JPanel panel;
	
	public static void main(String[] args) {
		Test test = new Test();
		test.setVisible(true);
	}
	
	private Test() {
		//setUndecorated(true);
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBackground(new Color(0, 0, 0, 0));
		panel = new JPanel();
		panel.setVisible(true);
		
		add(panel);
		setVisible(true);
	}
	
}