import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ReadSymptomFile implements ISymptomsReader {
	
	String fileName = "/Users/hermy/Desktop/Git Projects/MyRepo/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
	String sortedList = "sortedSymptoms.txt";
	
	//File object to read a file (e.g. fileName)
	File inputFile = new File(fileName);
	File outputFile = new File(sortedList);

	@Override
	public ArrayList<String> GetSymptoms() {
		
		
		ArrayList<String> result = new ArrayList<String>();

		//Create BufferedReader object to read Symptoms from text file
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			 String line; //string line; act as a reference point to each line in the file in turn
			 
			//While loop reads the whole file (while the file is not equal to null)
			while ((line = br.readLine()) != null) {
				result.add(line); //result.add adds value to the ArrayList
			}

			//Sort Symptoms in alphabetical order in text file
			Collections.sort(result);

			//Create BufferedWriter Object to write into text file
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

				//Iterates through the ArrayList (for loop here retrieve a String in the list result)
				for (String out : result) {
					writer.write(out + "\n"); //writer calls write method to write result in sortedSymptoms.txt 
					System.out.println(out);
				}
			
			//Deal with exceptions
			} catch (FileNotFoundException e) {
				System.out.println("Can't find File " + inputFile.toString());
			} catch (IOException e) {
				System.out.println("Unable to read File " + inputFile.toString()); // Unable to read: file probably corrupted...
			}

		} catch (IOException e) {
			System.out.println("Unable to sort file " + outputFile.toString());
		}
		
		
		return result;
	}

}

