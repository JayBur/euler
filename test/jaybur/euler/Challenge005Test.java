package jaybur.euler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Challenge005Test {

	@Test
	public void testIsDivisableByRange() {

		boolean result = Challenge005.isDivisableByRange(2520, 10);

		assertTrue(
				"Failed to confirm the input is divisable by numbers in the range 1..10",
				result);
	}

	@Test
	public void testIsDivisableByRange_false() {

		boolean result = Challenge005.isDivisableByRange(2500, 10);

		assertFalse(
				"Failed to confirm the input is not divisable by numbers in the range 1..10",
				result);
	}

	@Test
	public void testMaxAnswerResult() {
		int maxRange = 10;
		long expected = 2520;

		long maxValue = Challenge005.calculateMaxDivisableInRange(maxRange);
		long result = Challenge005.calculateMinDivisableInRange_BruteForce(
				maxRange, maxValue);

		assertEquals(
				"calculated divisable number does not equal the minimal divisable number",
				expected, result);
	}
}
