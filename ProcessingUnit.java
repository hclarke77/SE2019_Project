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
        
     public List<Double> processRates(double processorSpeed, Buffer rateBuffer, csvReader rateReader, String Filename) {
     
        List<Double> rateTimes = new ArrayList<>();
        
        List<String> numRates = rateBuffer.loadRatesBuffer(rateReader, Filename);
        
        for (int i = 1;  i < rateBuffer.getSize(numRates); i++) {
        
            double place = Integer.valueOf(i);
            
            double rate = Double.parseDouble(rateBuffer.getRate(numRates, i));
            
            double calc = place*rate;
            
            rateTimes.add(calc);
            
            }
            
        return rateTimes;
        
        }
        


}
