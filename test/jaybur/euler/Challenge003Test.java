package jaybur.euler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void test_isInteger() {
		double intValue = 1d;

		assertTrue(Challenge003.isInteger(intValue));
	}

	@Test
	public void test_isInteger_false() {
		double intValue = 1.1d;

		assertFalse(Challenge003.isInteger(intValue));
	}

	@Test
	public void test_isPrimeNumber() {
		assertTrue(Challenge003.isPrimeNumber(2));
		assertTrue(Challenge003.isPrimeNumber(3));
		assertTrue(Challenge003.isPrimeNumber(5));
		assertTrue(Challenge003.isPrimeNumber(7));
		assertTrue(Challenge003.isPrimeNumber(11));
		assertTrue(Challenge003.isPrimeNumber(13));
		assertTrue(Challenge003.isPrimeNumber(17));
		assertTrue(Challenge003.isPrimeNumber(19));
		assertTrue(Challenge003.isPrimeNumber(23));

		assertFalse(Challenge003.isPrimeNumber(4));
		assertFalse(Challenge003.isPrimeNumber(6));
		assertFalse(Challenge003.isPrimeNumber(8));
		assertFalse(Challenge003.isPrimeNumber(9));
		assertFalse(Challenge003.isPrimeNumber(10));
		assertFalse(Challenge003.isPrimeNumber(12));
		assertFalse(Challenge003.isPrimeNumber(14));

		assertFalse(Challenge003.isPrimeNumber(33));
	}

	@Test
	public void test_isPrimeNumber_directSquareRootCase() {
		assertFalse(Challenge003.isPrimeNumber(144));
	}

	@Test
	public void test_isPrimeNumber_negative() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Expected non-negative non-zero integer!");

		assertTrue(Challenge003.isPrimeNumber(-13));
	}

	@Test
	public void test_isPrimeNumber_one() {
		assertFalse(Challenge003.isPrimeNumber(1));
	}

	@Test
	public void test_isPrimeNumber_zero() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Expected non-negative non-zero integer!");

		assertTrue(Challenge003.isPrimeNumber(0));
	}
}
