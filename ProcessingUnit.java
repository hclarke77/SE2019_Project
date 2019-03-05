import java.io.*;
import java.util.*;

public class ProcessingUnit {

    List<Double> rates;
    double speed;
    Buffer buffer;
    
    public ProcessingUnit(double s, Buffer b) {
    
        speed = s;
        buffer = b;
        
        }
        
     public List<Double> processRates() {
     
        List<Double> rateTimes = new ArrayList<>();
        
        
        List<String> numRates = buffer.loadRatesBuffer();
        
        for (int i = 1;  i < numRates.size(); i++) {
        
            //double place = Integer.valueOf(i);
            
            double rate = Double.parseDouble(numRates.get(i));
            
           // double calc = place*rate;
            
            rateTimes.add(rate*60);
            
            }
            
        return rateTimes;
        
        }
        


}
