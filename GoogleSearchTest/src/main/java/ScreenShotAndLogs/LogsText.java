package ScreenShotAndLogs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogsText {
	public static void CreateLogFile(String text) {
		String dest = PathName.getPath() + ".txt";
		Path path = Paths.get(dest);
		try {
			Files.writeString(path, text, StandardCharsets.UTF_8);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return;
	}
}
