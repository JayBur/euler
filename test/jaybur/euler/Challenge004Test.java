package jaybur.euler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Challenge004Test {

	@Test
	public void test_getMaxPalindromicDivisors() {
		int expectedDivisorsA[] = new int[] { 91, 99 };
		int expectedDivisorsB[] = new int[] { 99, 91 };

		int inputPalindrome = 9009;

		int[] resultDivisors = Challenge004
				.getEqualLengthDivisors(inputPalindrome);

		assertTrue(
				"Did not return the maximum correct palindromic Divisors",
				Arrays.equals(resultDivisors, expectedDivisorsA)
						|| Arrays.equals(resultDivisors, expectedDivisorsB));
	}

	@Test
	public void test_getMaxPalindromicDivisors_equalDivisorLength() {
		int inputPalindrome = 12321;

		int[] resultDivisors = Challenge004
				.getEqualLengthDivisors(inputPalindrome);

		assertTrue("The resulting divisors were not of the same length",
				Integer.toString(resultDivisors[0]).length() == Integer
				.toString(resultDivisors[1]).length());
	}

	@Test
	public void test_getSolution() {
		int input = 10000;

		int palindromeResult = Challenge004.getLargestPalindrome(input, 2);

		assertEquals(
				"The number found was not the largest equal-lenght-divisors palindrome!",
				9009, palindromeResult);
	}

	@Test
	public void test_isEqualLength() {
		assertTrue("Numbers were not of equal length!",
				Challenge004.areEqualLength(123, 456));
	}

	@Test
	public void test_isEqualLength_false() {
		assertFalse("Numbers were not of equal length!",
				Challenge004.areEqualLength(123456, 456));
	}

	@Test
	public void test_isPalindrome() {
		int testPalindrome = 12321;

		boolean result = Challenge004.isPalindrome(testPalindrome);

		assertEquals("failed to correctly determine that " + testPalindrome
				+ "is a palindrome", true, result);
	}

	@Test
	public void test_isPalindrome_false() {
		int testPalindrome = 12333;

		boolean result = Challenge004.isPalindrome(testPalindrome);

		assertEquals("failed to correctly determine that " + testPalindrome
				+ "is NOT a palindrome", false, result);
	}

	@Test
	public void test_isPalindrome_falseMiddle() {
		int testPalindrome = 1234564321;

		boolean result = Challenge004.isPalindrome(testPalindrome);

		assertEquals("failed to correctly determine that " + testPalindrome
				+ "is NOT a palindrome", false, result);
	}

	@Test
	public void test_isPalindrome_huge() {
		int testPalindrome = 1234554321;

		boolean result = Challenge004.isPalindrome(testPalindrome);

		assertEquals("failed to correctly determine that " + testPalindrome
				+ "is a palindrome", true, result);
	}

	@Test
	public void test_isPalindrome_oneOnly() {
		int testPalindrome = 1;

		boolean result = Challenge004.isPalindrome(testPalindrome);

		assertEquals("failed to correctly determine that " + testPalindrome
				+ "is a palindrome", true, result);
	}

	@Test
	public void testDoubleCastIsFlooring() {
		assertEquals(4, (int) 4.666);
	}

	@Test
	public void testIntegerFlooring() {
		assertEquals(2, 5 / 2);
	}

}
