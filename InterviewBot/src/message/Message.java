package message;

import user.Account;

public class Message {
	
	private String message;
	private boolean response;
	private Account account;
	
	public Message(String message, Account account, boolean response) {
		this.setMessage(message);
		this.setAccount(account);
		this.setResponse(response);
	}

	/**
	 * @return the response
	 */
	public boolean isResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(boolean response) {
		this.response = response;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
