package utils;

import java.text.DecimalFormat;
import java.util.Random;


/**
 * generate random number for scanning of a product and the number of products
 */
public class RandomNum {

	/**
	 * @param min minimal range of a random number
	 * @param max maximal range of a random number
	 * @return the Integer value of a random
	 */
	public static int generateRandomNumByInt(int min, int max) {
		Random random = new Random();
		int result = random.nextInt(max)%(max-min+1) + min;
		return result;
	}

	/**
	 * @param min minimal range of a random number
	 * @param max maximal range of a random number
	 * @return the Double value of a random
	 */
	public static double generateRandomNumByDouble(double min, double max) {
		Random random = new Random();
		Double result = min + random.nextDouble() * (max - min);
		//format the number
		DecimalFormat df = new DecimalFormat("0.0");
		result = Double.parseDouble(df.format(result));
		return result;
	}
}
