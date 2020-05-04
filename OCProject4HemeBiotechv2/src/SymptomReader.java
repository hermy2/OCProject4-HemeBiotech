public class SymptomReader  {

	public static void main(String[] args) {
		ReadSymptomFile symptomFile = new ReadSymptomFile();
		
		ISymptomsReader symptomReader = new ReadSymptomFile();
		symptomReader.GetSymptoms();
    
	}

	
}	