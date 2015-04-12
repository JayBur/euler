package jaybur.euler;

import java.util.ArrayList;
import java.util.List;

import jaybur.util.MathUtils;
import jaybur.util.StringUtils;

/**
 * The following problem is taken from Project Euler:
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143
 *
 * @author JayBur
 * @link http://projecteuler.net/problem=003
 * @source https://github.com/JayBur/euler
 */
public class Challenge003 {

	public static long getLargestPrimeFactor(long value) {
		long[] primeNumbers = getPrimeNumbers(value);
		double remainingInputValue = value;

		double divisionResult;
		for (int i = primeNumbers.length - 1; i >= 0; i--) {
			long primeNumber = primeNumbers[i];

			divisionResult = remainingInputValue / primeNumber;
			if (!MathUtils.isInteger(divisionResult)) {
				continue;
			}

			int power = 2;
			for (; MathUtils.isInteger(divisionResult); power++) {
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
			if (!MathUtils.isPrimeNumber(candidate)) {
				if (!squareRootUsed
						&& MathUtils.isInteger(Math.sqrt(candidate))) {
					candidate = (long) Math.sqrt(candidate);
					squareRootUsed = true;
				}

				continue;
			}

			if (MathUtils.isInteger((double) value / (double) candidate)) {
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
			if (!MathUtils.isInteger(divisionResult)) {
				continue;
			}

			int power = 2;
			for (; MathUtils.isInteger(divisionResult); power++) {
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
			if (MathUtils.isPrimeNumber(val)) {
				primeNumbers.add(val);
			}
		}

		return toLongArray(primeNumbers);
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
		System.out.println("Total time: " + StringUtils.printTime(totalTime));
	}

	public static long[] toLongArray(List<Long> list) {
		long[] result = new long[list.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}

		return result;
	}
}
