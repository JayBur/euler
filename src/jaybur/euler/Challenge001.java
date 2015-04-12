package jaybur.euler;

/**
 * The following problem is taken from Project Euler:
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @author JayBur
 * @link http://projecteuler.net/problem=001
 * @source https://github.com/JayBur/euler
 */
public class Challenge001 {

	public static int calcSumOfMultiples(int multA, int multB, int max) {
		int total = 0;

		for (int i = 0; i < max; i++) {
			if (i % multA == 0 || i % multB == 0) {
				total += i;
			}
		}

		return total;
	}

	public static void main(String[] args) {

		long ms = System.currentTimeMillis();

		int result = calcSumOfMultiples(3, 5, 1000);

		long totalTime = System.currentTimeMillis() - ms;

		System.out.println("Result = " + result);
		System.out.println("Total time: " + totalTime + "ms");
	}
}
