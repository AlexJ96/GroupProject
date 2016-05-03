package thread;

import message.Message;
import user.Account;
import design.Chat;
import design.Window;

public class SendMessageThread extends Thread {
	
	private String messageToSend;
	private Window window;
	private Account account;
	
	public SendMessageThread(Window window, Account account, String message) {
		this.account = account;
		setMessageToSend(message);
		this.window = window;
		start();
	}
	
	public void run() {
		if (getMessageToSend().equalsIgnoreCase("Type message...") || getMessageToSend().equalsIgnoreCase("")) {
			return;
		} else {
			account.getMessages().add(new Message(getMessageToSend(), account, false));
			Chat.loadChat(window, account);
		}
	}

	/**
	 * @return the messageToSend
	 */
	public String getMessageToSend() {
		return messageToSend;
	}

	/**
	 * @param messageToSend the messageToSend to set
	 */
	public void setMessageToSend(String messageToSend) {
		this.messageToSend = messageToSend;
	}
}
