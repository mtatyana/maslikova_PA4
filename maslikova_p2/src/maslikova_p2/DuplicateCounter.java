package maslikova_p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DuplicateCounter {
	private Map<String, Integer> wordCounter = new HashMap<>();

	public void count(String path) {
		// Use try-with-resources to auto-close and clean up streams
		try (Scanner in = new Scanner(new File(path))) {
			while (in.hasNext()) {
				String word = in.next();
				Integer prev = wordCounter.get(word);
				if (prev == null)
					wordCounter.put(word, 1);
				else
					wordCounter.put(word, prev + 1);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error loading file " + path);
			System.exit(-1);
		}
	}

	public void write(String path) {
		try (PrintStream out = new PrintStream(new FileOutputStream(new File(path)))) {
			for (Entry<String, Integer> s : wordCounter.entrySet())
				out.println(s.getKey() + " " + s.getValue());
		} catch (FileNotFoundException e) {
			System.out.println("Error writing to file " + path);
			System.exit(-1);
		}
	}
}
