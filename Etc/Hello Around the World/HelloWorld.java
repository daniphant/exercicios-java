import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HelloWorld {
	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader("hello_unicode.txt"))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
