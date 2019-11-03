package maslikova_p1;

public class Application {
	public static void main(String[] args)
	{
		DuplicateRemover duplirem = new DuplicateRemover();
		duplirem.remove("problem1.txt");
		duplirem.write("unique_words.txt");
	}
}
