import java.io.*;
import java.util.*;


public class Buffer {

    csvReader rates,times;
    
    
    public Buffer(csvReader r) {
        
        rates = r;     
    }
         
    public List<String> loadTimesBuffer(csvReader reader) {
    
        List<List<String>> times;
        
        List<String> newBuffer = new ArrayList<>();
        
        times = reader.exportVariables();
        
        for(int i =1; i < times.size(); i++){
        
			List<String> free = times.get(i);
			
			newBuffer.add(free.get(0));
		}
        
        return newBuffer;
        
        }
    
         
    public List<String> loadRatesBuffer(csvReader reader) {
    
        List<List<String>> rates;
        
        List<String> newBuffer = new ArrayList<>();
        
        rates = reader.exportVariables();
        
        for(int i =1; i < rates.size(); i++){
        
			List<String> free = rates.get(i);
			
			newBuffer.add(free.get(1));
		}

        
        return newBuffer;
        
        }
}
