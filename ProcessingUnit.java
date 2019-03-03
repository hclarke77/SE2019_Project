import java.io.*;
import java.util.*;

public class ProcessingUnit {

    List<Double> rates;
    double speed;
    Buffer buffer;
    csvReader reader;
    
    public ProcessingUnit(double s, Buffer b, csvReader c) {
    
        speed = s;
        buffer = b;
        reader = c;
        
        }
        
     public List<Double> processRates(double processorSpeed, Buffer rateBuffer, csvReader rateReader) {
     
        List<Double> rateTimes = new ArrayList<>();
        
        List<String> numRates = rateBuffer.loadRatesBuffer(rateReader);
        
        for (int i = 0;  i < rateBuffer.getSize(numRates)-1; i++) {
        
            int mult = i+1;
        
            double place = Integer.valueOf(mult);
            
            double rate = rateBuffer.getRate(numRates, i);
            
            double calc = place*rate;
            
            rateTimes.add(calc);
            
            }
            
        return rateTimes;
        
        }
        


}
