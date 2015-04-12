package jaybur.util;

public class MathUtils {

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

		/**
		 * NOTE: wikipedia: The uniqueness in this theorem requires excluding 1
		 * as a prime because one can include arbitrarily many instances of 1 in
		 * any factorization, e.g., 3, 1 × 3, 1 × 1 × 3, etc. are all valid
		 * factorizations of 3.
		 */
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

}
