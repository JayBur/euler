package jaybur.euler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Challenge002Test {

	@Test
	public void test_getSumOfEvenFibonacciNumbers() {
		int result = Challenge002.getSumOfEvenFibonacciNumbers(100);
		final int expectedResult = 44;

		assertEquals(
				"Result does not match up against hand-calculated result from example!",
				expectedResult, result);
	}
}
