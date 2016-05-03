package utils;

import java.util.Random;

public class Utils {
	
	static Random random = new Random();
	
	
	public static final int getRandom(int maxValue) {
		return (int) (Math.random() * (maxValue + 1));
	}
	
	public static final int random(int min, int max) {
		final int n = Math.abs(max - min);
		return Math.min(min, max) + (n == 0 ? 0 : random(n));
	}
	
	public static final int random(int maxValue) {
		if(maxValue <= 0)
			return  0;
		return random.nextInt(maxValue);
	}
}
