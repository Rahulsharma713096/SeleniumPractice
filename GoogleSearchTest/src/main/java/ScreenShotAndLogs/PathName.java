package ScreenShotAndLogs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PathName {
	public static String getPath() {
		String path = System.getProperty("user.dir") + "\\src\\LogsAndScreenShots";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH-mm-ss_dd_MM_YYYY");
		LocalDateTime now = LocalDateTime.now();
		String p1 = dtf.format(now);
		path += "\\" + p1;
		return path;
	}
}
