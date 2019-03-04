import java.io.*;
import java.util.*;
import java.lang.*;

public class Buffer {

    csvReader ratesTimes;
    int size;
    
    public Buffer(csvReader r) {     
    
        ratesTimes = r;
    }
         
    public List<String> loadTimesBuffer() {
    
        List<List<String>> times = ratesTimes.exportVariables();
        
        List<String> newBuffer = times.get(0);
        
        return newBuffer;
        
        }
    
         
    public List<String> loadRatesBuffer() {
    
        List<List<String>> rates;
        
        rates = ratesTimes.exportVariables();
        
        List<String> newBuffer = rates.get(1);
        
        return newBuffer;
        
        }
        
        
    public int getSize(List<String> listRates) {
    
        int cnt = listRates.size();
        
        return cnt;
        
        }
        
        
    public String getRate(List<String> listRates, int index) {
    
        
        String retString = listRates.get(index);
        
        return retString;
        
        }
        
}
