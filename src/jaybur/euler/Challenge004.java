package jaybur.euler;

import java.util.concurrent.TimeUnit;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author JayBur & Marko
 *
 */
public class Challenge004 {

	public static boolean areEqualLength(int i, int j) {
		return Integer.toString(i).length() == Integer.toString(j).length();
	}

	public static int[] getEqualLengthDivisors(int input) {

		double squareRoot = Math.sqrt(input);

		for (int i = (int) squareRoot; i < input; i++) {
			if (input % i != 0) {
				continue;
			}

			int j = input / i;

			if (!areEqualLength(i, j)) {
				continue;
			}

			return new int[] { i, j };
		}

		return new int[] { input, 1 };
	}

	public static int getLargestPalindrome(int input, int desiredLength) {

		for (int i = input; i > 0; i--) {
			if (!isPalindrome(i)) {
				continue;
			}

			int[] divisors = getEqualLengthDivisors(i);

			if (areEqualLength(divisors[0], divisors[1])
					&& hasLength(divisors[0], desiredLength)) {
				return i;
			}
		}

		return 0;
	}

	public static boolean hasLength(int value, int length) {
		return Integer.toString(value).length() == length;
	}

	public static boolean isPalindrome(int testPalindrome) {
		String palindrome = Integer.toString(testPalindrome);

		for (int i = 0; i < palindrome.length() / 2; i++) {
			if (palindrome.charAt(i) != palindrome.charAt(palindrome.length()
					- 1 - i)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		long ms = System.currentTimeMillis();

		int input = 1000000;

		int result = getLargestPalindrome(input, 3);

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
