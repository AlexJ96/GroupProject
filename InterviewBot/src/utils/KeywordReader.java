package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class KeywordReader {
	
	private static String fileDirectory = "../data/keywords.txt";
	
	public static ArrayList<String> init() {
		ArrayList<String> keywords = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileDirectory));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					br.close();
					return keywords;
				}
				keywords.add(line);
				System.out.println("Added " + line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			
		}
		return keywords;
	}
}
