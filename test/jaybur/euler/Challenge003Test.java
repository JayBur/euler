package jaybur.euler;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Challenge003Test {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_getLargestLong() {
		long[] testArray = new long[] { 1, 4, 0, 15, 2 };

		long result = Challenge003.getMaxLong(testArray);

		assertEquals(15, result);
	}

	@Test
	public void test_getLargestLong_nullInput() {
		long[] testArray = null;

		exception.expect(NullPointerException.class);
		exception.expectMessage("Input array is null!");

		Challenge003.getMaxLong(testArray);
	}

	@Test
	public void test_getLargestLong_zeroLengthInput() {
		long[] testArray = new long[0];

		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Input array contains no values!");

		Challenge003.getMaxLong(testArray);
	}

	/**
	 * example from challenge
	 */
	@Test
	public void test_getLargestPrimeFactor_example() {
		long input = 13195;
		long expectedPrimeFactor = 29;

		long result = Challenge003.getLargestPrimeFactor(input);

		assertEquals(expectedPrimeFactor, result);
	}

	/**
	 * example from challenge
	 */
	@Test
	public void test_getLargestPrimeFactorOnTheGo_example() {
		long input = 13195;
		long expectedPrimeFactor = 29;

		long result = Challenge003.getLargestPrimeFactorOnTheGo(input);

		assertEquals(expectedPrimeFactor, result);
	}

	/**
	 * example from challenge
	 */
	@Test
	public void test_getPrimeFactors_example() {
		long input = 13195;
		long[] expectedPrimeFactors = new long[] { 29, 13, 7, 5 };

		long[] result = Challenge003.getPrimeFactors(input);

		Assert.assertArrayEquals(expectedPrimeFactors, result);
	}

	/**
	 * example from wikipedia
	 */
	@Test
	public void test_getPrimeFactors_wiki() {
		long input = 360;
		long[] expectedPrimeFactors = new long[] { 5, 3, 2 };

		long[] result = Challenge003.getPrimeFactors(input);

		Assert.assertArrayEquals(expectedPrimeFactors, result);
	}

	/**
	 * Test to get all primes below 25
	 */
	@Test
	public void test_getPrimeNumbers() {
		long[] expectedPrimes = new long[] { 2, 3, 5, 7, 11, 13, 17, 19, 23 };
		long input = 25;

		long result[] = Challenge003.getPrimeNumbers(input);

		assertEquals("Incorrect amount of primes", expectedPrimes.length,
				result.length);
		Assert.assertArrayEquals("Incorrect primes were returned",
				expectedPrimes, result);
	}
}
