import java.io.*;
import java.util.*;


public class Buffer {

    int size;
    List<String> rates,times;
    
    
    public Buffer(int s, List<String> r) {
        
        size = s;
        rates = r;     
    }
         
    public List<String> loadTimesBuffer(csvReader reader) {
    
        List<List<String>> times;
        
        times = reader.exportVariables();
        
        List<String> newBuffer = times.get(0);
        
        return newBuffer;
        
        }
    
         
    public List<String> loadRatesBuffer(csvReader reader) {
    
        List<List<String>> rates;
        
        rates = reader.exportVariables();
        
        List<String> newBuffer = rates.get(1);
        
        return newBuffer;
        
        }
}
