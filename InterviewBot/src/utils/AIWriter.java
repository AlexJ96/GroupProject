package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AIWriter {

	private static String path = "../data/out.txt";
	private static ArrayList<String> fileInput = new ArrayList<String>();
	
	public static void init() {
		//ArrayList<String> keywords = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					br.close();
					break;
				}
				fileInput.add(line);
				//System.out.println("Added " + line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
		}
	}
	
	public static void writeFile() {
		try {
			//String str = input + " - " + output;
	        FileWriter fw = new FileWriter(path);
	        for (String str : fileInput) {
	        	fw.append(str + "\n");
	        }
	        fw.close();

		} catch (IOException iox) {
	        //do stuff with exception
	        iox.printStackTrace();
		}
	}

	/**
	 * @return the fileInput
	 */
	public static ArrayList<String> getFileInput() {
		return fileInput;
	}

	/**
	 * @param fileInput the fileInput to set
	 */
	public static void setFileInput(ArrayList<String> fileInput) {
		AIWriter.fileInput = fileInput;
	}
}
