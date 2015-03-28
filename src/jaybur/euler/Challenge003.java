package jaybur.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143
 *
 * @author JayBur
 */
public class Challenge003 {

	public static long getLargestPrimeFactor(long value) {
		long[] primeNumbers = getPrimeNumbers(value);
		double remainingInputValue = value;

		double divisionResult;
		for (int i = primeNumbers.length - 1; i >= 0; i--) {
			long primeNumber = primeNumbers[i];

			divisionResult = remainingInputValue / primeNumber;
			if (!isInteger(divisionResult)) {
				continue;
			}

			int power = 2;
			for (; isInteger(divisionResult); power++) {
				divisionResult = remainingInputValue
						/ Math.pow(primeNumber, power);
			}

			remainingInputValue /= Math.pow(primeNumber, power - 2);
			return primeNumber;
		}

		return -1;
	}

	public static long getLargestPrimeFactorOnTheGo(long value) {

		boolean squareRootUsed = false;

		for (long candidate = value; candidate >= 0; candidate--) {
			if (!isPrimeNumber(candidate)) {
				if (!squareRootUsed && isInteger(Math.sqrt(candidate))) {
					candidate = (long) Math.sqrt(candidate);
					squareRootUsed = true;
				}

				continue;
			}

			if (isInteger((double) value / (double) candidate)) {
				return candidate;
			}
		}

		return -1;
	}

	public static long getMaxLong(long[] values) {
		if (values == null) {
			throw new NullPointerException("Input array is null!");
		}

		if (values.length == 0) {
			throw new IllegalArgumentException(
					"Input array contains no values!");
		}

		long max = Long.MIN_VALUE;

		for (long longValue : values) {
			if (max < longValue) {
				max = longValue;
			}

		}

		return max;
	}

	public static long[] getPrimeFactors(long value) {
		List<Long> primeFactors = new ArrayList<>();
		long[] primeNumbers = getPrimeNumbers(value);
		double remainingInputValue = value;

		double divisionResult;
		for (int i = primeNumbers.length - 1; i >= 0; i--) {
			long primeNumber = primeNumbers[i];

			divisionResult = remainingInputValue / primeNumber;
			if (!isInteger(divisionResult)) {
				continue;
			}

			int power = 2;
			for (; isInteger(divisionResult); power++) {
				divisionResult = remainingInputValue
						/ Math.pow(primeNumber, power);
			}

			remainingInputValue /= Math.pow(primeNumber, power - 2);
			primeFactors.add(primeNumber);
		}

		return toLongArray(primeFactors);
	}

	/**
	 * Finding prime numbers based on Trial division
	 *
	 * @param maxValue
	 * @return primeNumbers int[]
	 */
	public static long[] getPrimeNumbers(long maxValue) {
		List<Long> primeNumbers = new ArrayList<>();

		for (long val = 2; val < maxValue; val++) {
			if (isPrimeNumber(val)) {
				primeNumbers.add(val);
			}
		}

		return toLongArray(primeNumbers);
	}

	public static boolean isInteger(double value) {
		return value == Math.floor(value) && !Double.isInfinite(value);
	}

	/**
	 * calculates whether a number is a prime number
	 *
	 * XXX: feed prime numbers to loop through for performance improvement
	 *
	 * XXX: based on Trial Division: more efficient algorithms exist
	 *
	 * @param potentialPrime
	 * @return
	 */
	public static boolean isPrimeNumber(long potentialPrime) {
		if (potentialPrime < 1) {
			throw new IllegalArgumentException(
					"Expected non-negative non-zero integer!");
		}

		// NOTE: wikipedia: The uniqueness in this theorem requires excluding 1
		// as a prime because one can include arbitrarily many instances of 1 in
		// any factorization, e.g., 3, 1 × 3, 1 × 1 × 3, etc. are all valid
		// factorizations of 3.
		if (potentialPrime == 1) {
			return false;
		}

		// known prime
		if (potentialPrime == 2) {
			return true;
		}

		// even numbers beyond 2 are not primes
		if (potentialPrime % 2 == 0) {
			return false;
		}

		double squareRoot = Math.sqrt(potentialPrime);

		if (isInteger(squareRoot)) {
			return false;
		}

		for (int i = 2; i < squareRoot; i++) {
			if (isInteger(potentialPrime / ((double) i))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		long ms = System.currentTimeMillis();

		long input = 600851475143L;

		// long result = getMaxLong(getPrimeFactors(input)); // takes > 1 hour

		// long result = getLargestPrimeFactor(input); realized more
		// optimizations options before completing running

		long result = getLargestPrimeFactorOnTheGo(input); // solves in 35 sec

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

	public static long[] toLongArray(List<Long> list) {
		long[] result = new long[list.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}

		return result;
	}
}
