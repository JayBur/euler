package jaybur.euler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Challenge006Test {

	@Test
	public void testDifference() {
		int range = 10;

		long result = Challenge006.differenceSumOfSquaresAndSquareOfSums(range);

		assertEquals(2640, result);
	}

}
