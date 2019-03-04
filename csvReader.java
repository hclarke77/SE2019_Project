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
    
    
/*	List<List<String>> records = new ArrayList<>();
	try {
        BufferedReader br = new BufferedReader(new FileReader(csvFilename));
        String line = br.readLine();
        
            while (line != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
                    }
                    
        
            return records;
         
        }   catch (FileNotFoundException e) {
        
                System.out.println("FileNotFoundException occurred");
                
                return records;
        }   catch (IOException e) { 
        
                System.out.println("IOException occurred");
                
                return records;
            }*/
            
            
            
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(csvFilename));) {
            while (scanner.hasNextLine()) {
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
