import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SymptomReader {

	public static void main(String[] args) {

		String fileName = "/Users/hermy/Desktop/Git Projects/MyRepo/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
		String sortedList = "sortedSymptoms.txt";
		
		File inputFile = new File(fileName);
		File outputFile = new File(sortedList);
		
		ArrayList<String> result = new ArrayList<String>();

		//Create BufferedReader object to read Symptoms from text file
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			 String line;

			while ((line = br.readLine()) != null) {
				result.add(line);
			}

			//Sort Symptoms in alphabetical order in text file
			Collections.sort(result);

			//Create BufferedWriter Object to write into text file
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

				for (String out : result) {
					writer.write(out + "\n");
					System.out.println(out);
				}
			
			//Deal with exceptions
			} catch (FileNotFoundException e) {
				System.out.println("Can't find File " + inputFile.toString());
			} catch (IOException e) {
				System.out.println("Unable to read File " + inputFile.toString());
			}

		} catch (IOException e) {
			System.out.println("Unable to sort file " + outputFile.toString());
		}

	}

}
