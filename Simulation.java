import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulation {


  public static void main(String[] args) {
	  //Asks user for file name they wish to simulate
	  Scanner scanner = new Scanner (System.in);
	  System.out.println("Enter your File name: ");  
	  String Filename = scanner.next();
	  
	  //Calls csv Reader on user's File
	  csvReader reader = new csvReader(Filename);
	  
	  //Gets the date and time values from the csv File
	  Buffer ListTimesRates = new Buffer(reader);
	  List<String> ltimes = ListTimesRates.loadTimesBuffer(reader, Filename);
	  //Gets the rate values from the csv File
	  List<String> lrates = ListTimesRates.loadRatesBuffer(reader, Filename);
	  
	  //ProccesingUnit(double speed, Buffer B, csvReader c)
	 // ProcessingUnit rateProcessor = new ProcessingUnit(2.00,ListRates,reader);
	  //rateProcessor.processRates(2.00,ListRates,reader);
	  
	  
	  for (int i = 1; i < ListTimesRates.getSize(lrates); i++) {
	  
            System.out.println(ListTimesRates.getRate(lrates,i));
            
            
        }
    }
}

