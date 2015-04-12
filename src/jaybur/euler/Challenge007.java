package jaybur.euler;

import jaybur.util.MathUtils;
import jaybur.util.StringUtils;

/**
 * The following problem is taken from Project Euler:
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 * @author JayBur
 * @link http://projecteuler.net/problem=007
 * @source https://github.com/JayBur/euler
 */
public class Challenge007 {

	public static long getPrimeByIndex(int index) {
		int primeCount = 0;
		long currentPrime = -1;

		for (long potentialPrime = 1; primeCount < index; potentialPrime++) {
			if (!MathUtils.isPrimeNumber(potentialPrime)) {
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
		System.out.println("Total time: " + StringUtils.printTime(totalTime));
	}
}
