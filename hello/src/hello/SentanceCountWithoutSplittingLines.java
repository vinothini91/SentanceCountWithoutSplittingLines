package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SentanceCountWithoutSplittingLines {

	public static void main(String[] args) {
		File file = new File("F:/vino--programs-2021/NoOfSentences.txt");
		Path path = Paths.get(file.toString());
		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			int sentencecount = 0;
			while ((line = reader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					char ch = line.charAt(i);
					if (ch == '.') {
						sentencecount++;
					}
				}

			}
			System.out.println("Total number of sentence:" + sentencecount);
			if (sentencecount == 0)
				System.out.println("File is empty");
			reader.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
