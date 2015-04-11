package jaybur.euler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Challenge007Test {

	@Test
	public void test_getPrimeByIndex() {
		int index = 6;
		long expectedPrime = 13;

		long result = Challenge007.getPrimeByIndex(index);

		assertEquals(expectedPrime, result);
	}

}
