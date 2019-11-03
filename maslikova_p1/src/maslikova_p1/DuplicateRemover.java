package maslikova_p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
	private Set<String> uniqueWords;

	public void remove(String dataFile) {
		uniqueWords = new HashSet<>();
		//Use try-with-resources to auto-close and clean up streams
		try (Scanner in = new Scanner(new File(dataFile))) {
			while(in.hasNext())
				uniqueWords.add(in.next());
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error loading file " + dataFile);
			System.exit(-1);
		}
	}

	public void write(String outpath) {
		//Use try-with-resources to auto-close and clean up streams
		try (PrintStream out = new PrintStream(new FileOutputStream(new File(outpath)))){
			for(String s : uniqueWords)
				out.println(s);
		} catch (FileNotFoundException e) {
			System.out.println("Error writing to file " + outpath);
			System.exit(-1);
		}
	}
}
