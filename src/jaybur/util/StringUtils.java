package jaybur.util;

import java.util.concurrent.TimeUnit;

public class StringUtils {

	public static final String EMPTY = "";

	public static String printTime(long millis) {
		if (millis < 1000) {
			return millis + "ms";
		}

		return String.format(
				"%02d:%02d:%02d",
				TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis)
				% TimeUnit.HOURS.toMinutes(1),
				TimeUnit.MILLISECONDS.toSeconds(millis)
				% TimeUnit.MINUTES.toSeconds(1));
	}

}
