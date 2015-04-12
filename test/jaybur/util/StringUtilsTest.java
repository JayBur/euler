package jaybur.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void test_printTime_h() {

		long msTime = 3600000l;

		String result = StringUtils.printTime(msTime);

		assertEquals("01:00:00", result);
	}

	@Test
	public void test_printTime_m() {

		long msTime = 60000l;

		String result = StringUtils.printTime(msTime);

		assertEquals("00:01:00", result);
	}

	@Test
	public void test_printTime_ms() {

		long msTime = 123l;

		String result = StringUtils.printTime(msTime);

		assertEquals("123ms", result);
	}

	@Test
	public void test_printTime_s() {

		long msTime = 1234l;

		String result = StringUtils.printTime(msTime);

		assertEquals("00:00:01", result);
	}
}
