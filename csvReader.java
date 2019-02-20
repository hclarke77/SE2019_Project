import java.io.*;
import java.util.*;

public class csvReader {


    public csvReader(String f) {
    
	csvFilename = f;
    
    }
    
    public List<List<String>> exportVariables() {
    
    
	List<List<String>> records = new ArrayList<>();
	try (BufferedReader br = new BufferedReader(new FileReader(csvFilename))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		String[] values = line.split(",");
		records.add(Arrays.asList(values));
	    }
	  
	  
	    return records;
	
	}
	
	catch (FileNotFoundException e) {
	
	    System.out.println("FileNotFoundException occurred");
	    
	    return records;
	}
	
	catch (IOException e) { 
	
	    System.out.println("IoException occurred");
	    
	    return records;
	}	    
	    
    }
    
public String csvFilename;

    
        
}