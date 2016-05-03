package thread;

import java.applet.AudioClip;

import message.Message;
import user.Account;
import utils.Utils;
import utils.audio.AudioManager;
import design.Chat;
import design.Window;

public class SendResponseThread extends Thread {
	
	private Account account;
	private Window window;
	private String message;
	private String[] unsureResponses = { "I'm not sure, sorry.", "I don't understand, sorry.", "I'm not sure what you're asking, sorry.", "Could you rephrase that as I'm unsure, sorry.", "I don't know what you mean, sorry.", "What do you mean? Sorry." };
	
	public SendResponseThread(Window window, Account account, String message) {
		this.account = account;
		this.window = window;
		this.message = message;
		start();
	}
	
	public void run() {
		UserTypingThread uTT = new UserTypingThread();
		try {
			Thread.sleep(message.length() * Utils.random(2, 5) * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String question = message;
		String phrase = "";
		for (String keyword : question.split(" ")) {
			for (String key_words : Window.getKeywords()) {
				if (keyword.endsWith("?")) {
					keyword = keyword.replace('?', ' ').trim();
				}
				if (keyword.endsWith(",")) {
					keyword = keyword.replace(',', ' ').trim();
				}
				if (keyword.equalsIgnoreCase(key_words)) {
					phrase += keyword;
				}
			}
		}
		if (phrase.equalsIgnoreCase("")) 
			phrase = unsureResponses[Utils.getRandom(unsureResponses.length-1)];
		if (window.getData().containsKey(phrase)) {
			System.out.println(window.getData().get(phrase).length());
			account.getMessages().add(new Message(window.getData().get(phrase), account, true));
			AudioClip responseAudio;
			responseAudio = window.getAudioClip(AudioManager.getAudioPath(), "CLEAN" + window.getAudioFiles().get(phrase) + ".wav");
			if (responseAudio == null)
				System.out.println("Audio null");
			responseAudio.play();
		} else {
			phrase = unsureResponses[Utils.getRandom(unsureResponses.length-1)];
			account.getMessages().add(new Message(phrase, account, true));
		}
		Chat.loadChat(window, account);
		Chat.getSendMessage().setEditable(true);
		Chat.getSendMessage().requestFocus();
		uTT.setRunning(false);
	}
}
