import java.io.*;
import java.util.*;



public class csvReader {


    public csvReader(String f) {
    
        csvFilename = f;
    
    }
    
    public String getFilename() {
    
        return csvFilename;
    }
    
    
    public List<List<String>> exportVariables() {           
            
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(csvFilename));) {
            while (scanner.hasNextLine()) {
		//String line = scanner.nextLine();
                records.add(getRecordFromLine(scanner.nextLine()));
                
            }
            
            return records;
        } catch (FileNotFoundException e) {
        
        return records;
	}
    }
    
    private List<String> getRecordFromLine(String line) {
    List<String> values = new ArrayList<String>();
    try (Scanner rowScanner = new Scanner(line)) {
        rowScanner.useDelimiter(",");
        while (rowScanner.hasNext()) {
            values.add(rowScanner.next());
        }
        
        return values;
        
    }   
    
}


String csvFilename;

    
        
}
