import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulation {


  public static void main(String[] args) {
	  //Asks user for file name they wish to simulate
	  Scanner scanner = new Scanner (System.in);
	  System.out.print("Enter your File name: ");  
	  String Filename = scanner.next();
	  
	  //Calls csv Reader on user's File
	  csvReader(Filename) = reader;
	  reader.exportVariables();
		
  }




}
