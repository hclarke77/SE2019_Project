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
	       //System.out.println(rList[i]);
	    } else {
	       System.out.println("NEGATIVE RATES!!");
	    }
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

  System.out.println("If this is the only message you see, the Tests all ran without error.");

  }
  
  // Using different data test simulation class
  public void simuTest() {
	  System.out.println("Enter times your want test");
	  Scanner scanner = new Scanner(System.in);
	  int n = scanner.nextInt();
	  
	  int[] bufferSize = new int[n];
	  int[] processorSpeed = new int[n];
	  
	  for(int i = 0; i < n; i++) {
		  System.out.println("Please enter buffer size and processor speed");
		  bufferSize[i] = scanner.nextInt();
		  processorSpeed[i] = scanner.nextInt();
	  }
	  
	  scanner.close();
	  
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
