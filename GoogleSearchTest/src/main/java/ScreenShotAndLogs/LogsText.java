package ScreenShotAndLogs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class LogsText {
	public static void CreateLogFile(String text) {
		String dest = PathName.getPath() + ".txt";
		Path path = Paths.get(dest);
		try {
			File myObje = new File("Path");
			myObje.createNewFile();
			Files.writeString(path, text, StandardCharsets.UTF_8);
		} catch (IOException ex) {
			try {
				Random rand = new Random();

				FileWriter myWriter = new FileWriter(rand.nextDouble() + ".text");
				myWriter.write(text);
				myWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return;
	}
}
