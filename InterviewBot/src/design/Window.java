package design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Images link: http://www.flaticon.com/free-icon/right-arrow_8767
 * @author Alex
 *
 */

public class Window extends JApplet {
		
	public static final long serialVersionUID = -2803431175048406077L;
	public JPanel panel;
	private JButton candidate, rightArrow, leftArrow, home, options, info, list;
	private JLabel bottomBar;
	
	private static HashMap<String, String> data = new HashMap<String, String>();
	private static ArrayList<String> keywords = new ArrayList<String>();
		
	public static void main(String[] args) {
	}
	
	public static void init(String[] args) {
	}
	
	public Window() {
		panel = new JPanel();
		
		setContentPane(new JLabel(new ImageIcon("../images/background.png")));
		
		candidate = new JButton();
		candidate.setBounds(60, 50, 200, 200);
		candidate.setIcon(new ImageIcon("../images/user1.png"));
		candidate.setOpaque(false);
		candidate.setBorderPainted(false);
		candidate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		rightArrow = new JButton();
		rightArrow.setBounds(270, 140, 32, 32);
		rightArrow.setIcon(new ImageIcon("../images/rightArrow.png"));
		rightArrow.setOpaque(false);
		rightArrow.setBorderPainted(false);
		rightArrow.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		rightArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				candidate.setIcon(new ImageIcon("../images/user1.png"));
			}
		});
		
		leftArrow = new JButton();
		leftArrow.setBounds(20, 140, 32, 32);
		leftArrow.setIcon(new ImageIcon("../images/leftArrow.png"));
		leftArrow.setOpaque(false);
		leftArrow.setBorderPainted(false);
		leftArrow.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		leftArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				candidate.setIcon(new ImageIcon("../images/user2.png"));
			}
		});
		
		bottomBar = new JLabel();
		bottomBar.setIcon(new ImageIcon("../images/bottomBar.png"));
		bottomBar.setBounds(0, 440, 360, 40);
		
		
		home = new JButton();
		home.setBounds(20, 444, 32, 32);
		home.setIcon(new ImageIcon("../images/home.png"));
		home.setOpaque(false);
		home.setBorderPainted(false);
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		info = new JButton();
		info.setBounds(190, 444, 32, 32);
		info.setIcon(new ImageIcon("../images/info.png"));
		info.setOpaque(false);
		info.setBorderPainted(false);
		info.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		list = new JButton();
		list.setBounds(105, 444, 32, 32);
		list.setIcon(new ImageIcon("../images/list.png"));
		list.setOpaque(false);
		list.setBorderPainted(false);
		list.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		options = new JButton();
		options.setBounds(270, 444, 32, 32);
		options.setIcon(new ImageIcon("../images/options.png"));
		options.setOpaque(false);
		options.setBorderPainted(false);
		options.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		candidate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				candidate.setVisible(false);
				leftArrow.setVisible(false);
				rightArrow.setVisible(false);
				
				
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
			    

				setContentPane(new JLabel(new ImageIcon("../images/background2.png")));
				
				home.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						textArea.setText(textArea.getText() + "Interviewee: I really like to do this because it's my hobby, please let me work for you. Mucho Gracias.\n\n");
						
					}
				});
				
				list.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						textArea.setText(textArea.getText() + "You: That's excellent, please tell me about yourself?\n\n");
					}	
				});

			    getContentPane().add(scroll);
				getContentPane().add(list);
				getContentPane().add(info);
				getContentPane().add(options);
				getContentPane().add(home);
				getContentPane().add(bottomBar);
				getContentPane().add(leftArrow);
				getContentPane().add(rightArrow);
				getContentPane().add(candidate);
				getContentPane().add(panel);
			    
			}
			
		});
		
		
		getContentPane().add(list);
		getContentPane().add(info);
		getContentPane().add(options);
		getContentPane().add(home);
		getContentPane().add(bottomBar);
		getContentPane().add(leftArrow);
		getContentPane().add(rightArrow);
		getContentPane().add(candidate);
		getContentPane().add(panel);
	}
}

