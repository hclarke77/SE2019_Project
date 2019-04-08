import java.io.*;
import java.util.*;
import java.lang.*;

public class Tests {

  public static void main(String[] args) {
  
    //Test Case #1 - wrong file
    Scanner scanner = new Scanner (System.in);
    System.out.println("Enter your File name (must be CSV): ");
    String Filename = scanner.next();
    scanner.close();
    csvReader reader = new csvReader(Filename);
    
    //Test Case #2 - print out rates and make sure positive int
    int[] rList = reader.exportVariables();
    for(int i=0; i<rList.length; i++) {
      if (rList[i]>0) {
	System.out.println(rList[i]);
	} else {
	  System.out.println("NEGATIVE RATES!!");
	  }
	
	
    //Test Case #3 - test with varying parameters   
    try
        {  
         Runtime.getRuntime().exec("java Simulation 400 95"); 
        
         Runtime.getRuntime().exec("java Simulation -400 95"); 
         
         Runtime.getRuntime().exec("java Simulation 400 -95"); 
         
         Runtime.getRuntime().exec("java Simulation -400 -95"); 
         
         Runtime.getRuntime().exec("java Simulation 400j -95"); 
        } 
        catch (Exception e) 
        { 
            System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
            e.printStackTrace(); 
        } 
    
   
	}
    
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  }
  
  
}