import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SymptomCounter extends SymptomReader {

	public static void main(String[] args) {

		//Use a hashmap to store words
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String result = "sortedSymptoms.txt";

		File textFile = new File(result);

		//Count the number of Symptoms using Scanner
		Scanner in;
		try {

			in = new Scanner(textFile);

			while (in.hasNext()) {
				String word = in.next();
				if (map.containsKey(word)) {
					// increase count to 1
					int count = map.get(word) + 1;
					map.put(word, count);
				} else {
					map.put(word, 1);
				}
			}
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Call the function sortedMap
		sortedMap(map);
	}

	public static void sortedMap(Map<String, Integer> map) {

		String resultOut = "resultOut.txt";

		File file = new File(resultOut);

		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {

			//Use TreeMap to sort Map in a natural order (Alphabetically)
			TreeMap<String, Integer> treemap = new TreeMap<String, Integer>();

			//Copy all data from hashMap into TreeMap
			treemap.putAll(map);

			//loop through sorted Map
			for (Map.Entry<String, Integer> entry : treemap.entrySet()) {

				String key = entry.getKey();
				int value = entry.getValue();
				br.write(key + "=" + value + "\n");
				System.out.println(entry.getKey() + "=" + entry.getValue());

			}

		} catch (IOException e) {
			System.out.println("Unable to read file " + file.toString());
		}

	}
}
