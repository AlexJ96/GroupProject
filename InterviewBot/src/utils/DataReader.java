package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DataReader {

	private static String fileDirectory = "../data/data.txt";
	
	public static HashMap<String, String> init() {
		System.out.println("Initilising data..");
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileDirectory));
			while (true) {
				String line = br.readLine();
				System.out.println("test");
				if (line == null) {
					br.close();
					return data;
				}
				String[] splittedLine = line.split(" - ", 2);
				if (splittedLine.length < 2) {
					br.close();
					throw new Exception("Incorrect Format in File");
				}
				String phrase = splittedLine[0];
				String response = splittedLine[1];
				System.out.println(phrase + " " + response);
				data.put(phrase, response);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			
		}
		return data;
	}

}
