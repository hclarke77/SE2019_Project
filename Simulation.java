import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulation {


  public static void main(String[] args) {
  
	  int bufferSize = args[0];
	  double processSpeed = args[1];
	  //Asks user for file name they wish to simulate
	  Scanner scanner = new Scanner (System.in);
	  System.out.println("Enter your File name: ");
	  String Filename = scanner.next();

	  //Calls csv Reader on user's File
	  csvReader reader = new csvReader(Filename);
	  List<List<String>> vars = reader.exportVariables();

	 /* for (int i=0; i<vars.size();i++) {

	    System.out.println(vars.get(i));

	  }
	  */
	  //Gets the date and time values from the csv File
	  Buffer ListTimesRates = new Buffer(vars);
	  //Gets the rate values from the csv File
	  List<String> lrates = ListTimesRates.loadRatesBuffer();
	  List<Message> listMessage = new ArrayList<>();
	 
	 //create messages
	  for (int i=0; i < ListTimesRates.getSize(); i++) {
	  
	    listMessage.add(new Message());
	    
	    }
	  
	  //calculate total travel
	  double totalTime; 
	  for(int j=0; j < ListTimesRates.getSize(); j++) {
	  
	    double travel = listMessage[j];
	    
	    totalTime += travel;
	    }
	    
	    
	    
	    

	  //ProccesingUnit(double speed, Buffer B)
	  ProcessingUnit rateProcessor = new ProcessingUnit(2,ListTimesRates);
	  List<Double> dubs = rateProcessor.processRates();
          Clock ctimes = new Clock(1,dubs);
          //Long waitTime = 1000000000;
          //ctimes.waitFor(waitTime);
          System.out.println("Latency: ");
          System.out.println(ctimes.calcuLatency().toString());
          System.out.println("Throughput: ");
	  System.out.println(ctimes.calcuThroughput().toString());
}
}
