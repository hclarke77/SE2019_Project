import java.io.*;
import java.util.*;
import java.lang.*;

public class Buffer {

    csvReader rates,times;
    int size;
    
    public Buffer(csvReader r) {
        
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
        
        
    public int getSize(List<String> listRates) {
    
        int cnt = listRates.size();
        
        return cnt;
        
        }
        
        
    public double getRate(List<String> listRates, int index) {
    
        String retString = listRates.get(index);
        
        double value = Double.parseDouble(retString);
        
        return value;
        
        }
        
}
