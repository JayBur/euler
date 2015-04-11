package jaybur.euler;

import java.util.concurrent.TimeUnit;

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385 The square of the sum of the first ten natural
 * numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 552 = 3025 Hence the difference between the sum of the
 * squares of the first ten natural numbers and the square of the sum is 3025 −
 * 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 *
 * @author JayBur
 */
public class Challenge006 {

	public static long differenceSumOfSquaresAndSquareOfSums(int range) {
		long sumSquares = 0;
		long squareSums = 0;

		for (int i = 1; i <= range; i++) {
			sumSquares += i * i;
			squareSums += i;
		}

		return (squareSums * squareSums) - sumSquares;
	}

	public static void main(String[] args) {
		long ms = System.currentTimeMillis();

		long result = differenceSumOfSquaresAndSquareOfSums(100);

		long totalTime = System.currentTimeMillis() - ms;

		System.out.println("Result = " + result);
		System.out.println("Total time: " + printTime(totalTime));
	}

	private static String printTime(long millis) {
		if (millis < 1000) {
			return millis + "ms";
		}

		return String.format(
				"%02d:%02d:%02d",
				TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis)
				% TimeUnit.HOURS.toMinutes(1),
				TimeUnit.MILLISECONDS.toSeconds(millis)
				% TimeUnit.MINUTES.toSeconds(1));
	}

}
