package thread;

import design.Chat;

public class UserTypingThread extends Thread {
	
	private boolean running;
	
	public boolean getRunning() {
		return running;
	}
	
	public void setRunning(boolean newRunning) {
		running = newRunning;
	}
	
	public UserTypingThread() {
		running = true;
		start();
	}
	
	public void run() {
		while (running) {
			Chat.getUserTyping().setVisible(true);
			Chat.getUserTyping().setText("Liam is typing/recording.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Chat.getUserTyping().setText("Liam is typing/recording..");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Chat.getUserTyping().setText("Liam is typing/recording...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Chat.getUserTyping().setVisible(false);
	}
	
	
}
