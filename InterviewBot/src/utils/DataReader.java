package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class DataReader {

	private static String fileDirectory = "../data/data.txt";
	private static HashMap<String, String> tempAudioArray = new HashMap<String, String>();
	
	public static HashMap<String, String> getTempAudioArray() {
		return tempAudioArray;
	}

	public static void setTempAudioArray(HashMap<String, String> tempAudioArray) {
		DataReader.tempAudioArray = tempAudioArray;
	}

	public static HashMap<String, String> init() {
		System.out.println("Reading data..");
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileDirectory));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					br.close();
					//System.out.println("Line null");
					return data;
				}
				String[] splittedLine = line.split(" - ", 3);
				if (splittedLine.length < 2) {
					br.close();
					throw new Exception("Incorrect Format in File");
				}
				String phrase = splittedLine[0];
				String response = splittedLine[1];
				String audioName = splittedLine[2];
				//System.out.println(phrase + " " + audioName);
				data.put(phrase, response);
				tempAudioArray.put(phrase, audioName);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("DONE LOADING");
		return data;
	}

}
