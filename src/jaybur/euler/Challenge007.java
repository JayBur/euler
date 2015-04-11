package jaybur.euler;

import java.util.concurrent.TimeUnit;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 * @author JayBur
 */
public class Challenge007 {

	public static long getPrimeByIndex(int index) {
		int primeCount = 0;
		long currentPrime = -1;

		for (long potentialPrime = 1; primeCount < index; potentialPrime++) {
			if (!Challenge003.isPrimeNumber(potentialPrime)) {
				continue;
			}

			primeCount++;
			currentPrime = potentialPrime;
		}

		return currentPrime;
	}

	public static void main(String[] args) {
		long ms = System.currentTimeMillis();

		int primeIndex = 10001;
		long result = getPrimeByIndex(primeIndex);

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
