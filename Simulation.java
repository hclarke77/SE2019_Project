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
	  Buffer ListTimes = new Buffer(reader);
	  ListTimes.loadTimesBuffer(reader);
	  
	  //Gets the rate values from the csv File
	  Buffer ListRates = new Buffer(reader);
	  ListRates.loadRatesBuffer(reader);
	  
	  //ProccesingUnit(double speed, Buffer B)
	  
		
  }

}
