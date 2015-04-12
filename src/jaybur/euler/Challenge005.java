package jaybur.euler;

import java.util.ArrayList;
import java.util.List;

import jaybur.util.StringUtils;

/**
 * The following problem is taken from Project Euler:
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 *
 * @author JayBur
 * @link http://projecteuler.net/problem=005
 * @source https://github.com/JayBur/euler
 */
public class Challenge005 {

	private static List<Integer> usedProducts;

	public static long calculateMaxDivisableInRange(int maxRange) {
		long product = 1;
		usedProducts = new ArrayList<>();

		mainProductLoop: for (int i = maxRange; i > 1; i--) {

			if (product % i == 0) {
				continue;
			}

			for (Integer usedProd : usedProducts) {
				if (usedProd.intValue() % i == 0) {
					continue mainProductLoop;
				}
			}

			usedProducts.add(new Integer(i));
			product *= i;
		}

		return product;
	}

	public static long calculateMinDivisableInRange_BruteForce(int maxRange,
			long startPoint) {
		long minProduct = startPoint;

		for (long i = startPoint; i > 0; i--) {
			if (isDivisableByRange(i, maxRange)) {
				minProduct = i;
			}
		}

		return minProduct;
	}

	public static boolean isDivisableByRange(long input, long rangeMax) {
		for (long i = rangeMax; i > 1; i--) {
			if (input % i != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		long ms = System.currentTimeMillis();

		int maxRange = 20;

		long maxValue = Challenge005.calculateMaxDivisableInRange(maxRange);
		long result = Challenge005.calculateMinDivisableInRange_BruteForce(
				maxRange, maxValue);

		long totalTime = System.currentTimeMillis() - ms;

		System.out.println("Result = " + result);
		System.out.println("Total time: " + StringUtils.printTime(totalTime));
	}
}
