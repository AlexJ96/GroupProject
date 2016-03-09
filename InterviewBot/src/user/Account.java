package user;

import java.util.ArrayList;

import message.Message;

public class Account {

	
	private String username, password, email;
	
	private ArrayList<Message> messages = new ArrayList<Message>();
	
	public Account(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the messages
	 */
	public ArrayList<Message> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
	
}
