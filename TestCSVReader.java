import java.io.*;
import java.util.*;
import java.lang.*;

public class TestCSVReader {

  public static void main(String[] args) {



    //Asks user for file name they wish to simulate
    Scanner scanner = new Scanner (System.in);
    System.out.println("Enter your File name (must be CSV): ");
    String Filename = scanner.next();
    scanner.close();

    //Calls csv Reader on user's File
    csvReader reader = new csvReader(Filename);

    //stores list of rates - one minute after another
    int[] ratesList = reader.exportVariables();
    System.out.println(ratesList.length);
    for (int i=0; i<ratesList.length; i++){
      System.out.println(ratesList[i]);
    }

    }
  }
