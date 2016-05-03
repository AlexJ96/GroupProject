package utils.audio;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AudioManager {
	
	private static ArrayList<String> audioNames = new ArrayList<String>();
	private static File folder = new File("../audio/");
	
	public static URL getAudioPath() {
		URL url = null;
		try {
			url = new URL("file://" + folder.getCanonicalPath().toString() + "/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

	/**
	 * @return the audioNames
	 */
	public static ArrayList<String> getAudioNames() {
		return audioNames;
	}

	/**
	 * @param audioNames the audioNames to set
	 */
	public static void setAudioNames(ArrayList<String> audioNames) {
		AudioManager.audioNames = audioNames;
	}
}
