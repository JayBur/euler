package jaybur.euler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Challenge001Test {

	@Test
	public void test_challengeExample() {
		int multA = 3;
		int multB = 5;
		int max = 10;

		int result = Challenge001.calcSumOfMultiples(multA, multB, max);
		assertEquals("Result does not match the challenge's example!", 23,
				result);
	}
}