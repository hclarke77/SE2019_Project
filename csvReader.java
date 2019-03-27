import java.io.*;
import java.util.*;

public class csvReader {


    public csvReader(String f) {
    
        csvFilename = f;
    
    }
    
    public String getFilename() {
    
        return csvFilename;
    }
    
    
    public List<Integer> exportVariables() {           
            
        List<Integer> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(csvFilename));) {
            while (scanner.hasNextLine()) {
		//String line = scanner.nextLine();
                records.add(Integer.valueOf(getRecordFromLine(scanner.nextLine()).get(1)));
                
            }
            
            return records;
        } catch (FileNotFoundException e) {
        
        System.out.println(records.get(0));
        
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
