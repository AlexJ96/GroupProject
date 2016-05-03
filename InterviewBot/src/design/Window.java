package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JApplet;
import javax.swing.JPanel;
import user.Account;
import utils.DataReader;
import utils.KeywordReader;

/**
 * Images link: http://www.flaticon.com/free-icon/right-arrow_8767
 * @author Alex
 *
 */

public class Window extends JApplet {
		
	public static final long serialVersionUID = -2803431175048406077L;
	public JPanel panel;
	private static Account account;
	
	public static Account getAccount() {
		return account;
	}
	
	private static HashMap<String, String> data = new LinkedHashMap<String, String>();
	private static ArrayList<String> keywords = new ArrayList<String>();
	private static HashMap<String, String> audioFiles = new HashMap<String, String>();
	
	public static ArrayList<String> getKeywords() {
		return keywords;
	}
		
	public static void main(String[] args) {
	}
	
	public static void init(String[] args) {
	}
	
	public Window() {
		
		//voce.SpeechInterface.init("voce/", true, 
				//true, "voce/gram", "test");
		//voce.SpeechInterface.synthesize("hello world");
		
		//System.out.println(voce.SpeechInterface.isRecognizerEnabled());
		
		panel = new JPanel();
	    
	    data = DataReader.init();
	    audioFiles = DataReader.getTempAudioArray();
	    keywords = KeywordReader.init();
	    
	    Login.loadLogin(this);
	}
	
	public HashMap<String, String> getData() {
		return data;
	}
	
	public HashMap<String, String> getAudioFiles() {
		return audioFiles;
	}
	
}

