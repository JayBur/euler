package jaybur.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MathUtilsTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_isInteger() {
		double intValue = 1d;

		assertTrue(MathUtils.isInteger(intValue));
	}

	@Test
	public void test_isInteger_false() {
		double intValue = 1.1d;

		assertFalse(MathUtils.isInteger(intValue));
	}

	@Test
	public void test_isPrimeNumber() {
		assertTrue(MathUtils.isPrimeNumber(2));
		assertTrue(MathUtils.isPrimeNumber(3));
		assertTrue(MathUtils.isPrimeNumber(5));
		assertTrue(MathUtils.isPrimeNumber(7));
		assertTrue(MathUtils.isPrimeNumber(11));
		assertTrue(MathUtils.isPrimeNumber(13));
		assertTrue(MathUtils.isPrimeNumber(17));
		assertTrue(MathUtils.isPrimeNumber(19));
		assertTrue(MathUtils.isPrimeNumber(23));

		assertFalse(MathUtils.isPrimeNumber(4));
		assertFalse(MathUtils.isPrimeNumber(6));
		assertFalse(MathUtils.isPrimeNumber(8));
		assertFalse(MathUtils.isPrimeNumber(9));
		assertFalse(MathUtils.isPrimeNumber(10));
		assertFalse(MathUtils.isPrimeNumber(12));
		assertFalse(MathUtils.isPrimeNumber(14));

		assertFalse(MathUtils.isPrimeNumber(33));
	}

	@Test
	public void test_isPrimeNumber_directSquareRootCase() {
		assertFalse(MathUtils.isPrimeNumber(144));
	}

	@Test
	public void test_isPrimeNumber_negative() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Expected non-negative non-zero integer!");

		assertTrue(MathUtils.isPrimeNumber(-13));
	}

	@Test
	public void test_isPrimeNumber_one() {
		assertFalse(MathUtils.isPrimeNumber(1));
	}

	@Test
	public void test_isPrimeNumber_zero() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Expected non-negative non-zero integer!");

		assertTrue(MathUtils.isPrimeNumber(0));
	}

}
