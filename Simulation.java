import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulation {

  public static void main(String[] args) {
    //input parameters
	  long bufferSize = Long.valueOf(args[0]);
	  long processSpeed = Long.valueOf(args[1]);
    char typeOfSimulation = args[2].charAt(0);

    //System.out.println("Micro Remainder: " + microRemainderProcess);
    //System.out.println("Micro Process Speed: " + microProcessSpeed);
    //System.out.println("Calculated Process Speed: " + (processSpeed / 1000000));


    Buffer inputThread = new Buffer(bufferSize);
    //System.out.println(inputThread.qMess);


	  //Asks user for file name they wish to simulate
	  Scanner scanner = new Scanner (System.in);
	  System.out.println("Enter your File name (must be CSV): ");
	  String Filename = scanner.next();
    scanner.close();

	  //Calls csv Reader on user's File
	  csvReader reader = new csvReader(Filename);

    //stores list of rates - one minute after another
    int[] ratesList = reader.exportVariables();

    if (typeOfSimulation == 'm' || typeOfSimulation == 'M'){

      long microProcessSpeed = (long) processSpeed / 1000000;
      long microRemainderProcess = (long)processSpeed % 1000000;

      System.out.println("The Simulation will run for " + ratesList.length +" minutes based on the CSV File Length given\n");

      //System.out.println(ratesList.length);
      long currTime = 0;
      int listIndex = 0;
      long minuteDivide = (60000000);
      long secondsCompleted = 0;
      long minutesCompleted=0;
      long currentSecRate = 0; //= Long.valueOf(ratesList.get(listIndex));
      long currentMicroRate = 0; //= currentSecRate / 1000000;
      //in time this will all go in clock class - once i figure it out
      long microRemainderRate = 0;
      long microSecondNumber = 0;
      float avThroughput;
      float avLatency;

      //for (int j=0; j<300000000; j++) {

      while (listIndex < ratesList.length) {
        //currTime = microsecond
        if (currTime % minuteDivide == 0) {
          currentSecRate = Long.valueOf(ratesList[listIndex]);
          currentMicroRate = currentSecRate / 1000000;
          microRemainderRate = currentSecRate % 1000000;
          listIndex += 1;
          System.out.println("Minutes Completed: " + minutesCompleted);
          minutesCompleted += 1;
        }

        if (currTime % 1000000 == 0){
          //System.out.println("Seconds Completed: " + secondsCompleted);
          secondsCompleted += 1;
          microSecondNumber = 0;
        }

        if (currTime % 1 == 0)
        {
          if (microSecondNumber < microRemainderRate){
            //System.out.println("System Current Time: " + currTime);
            inputThread.addMessages((currentMicroRate+1), currTime);
            if (microSecondNumber < microRemainderProcess) {
              inputThread.processMessages((microProcessSpeed+1), currTime);
            } else {
              inputThread.processMessages(microProcessSpeed, currTime);
            }
            //inputThread.processMessages(microProcessSpeed, currTime);
            //System.out.println("Current Micro Rate: " + currentMicroRate);
            //System.out.println("Current Remainder Rate: " + microRemainderRate);
          } else {
            //System.out.println("System Current Time: " + currTime);
            inputThread.addMessages(currentMicroRate, currTime);
            if (microSecondNumber < microRemainderProcess) {
              inputThread.processMessages((microProcessSpeed+1), currTime);
            } else {
              inputThread.processMessages(microProcessSpeed, currTime);
            }
            //inputThread.processMessages(microProcessSpeed, currTime);
            //System.out.println("Current Micro Rate: " + currentMicroRate);
            //System.out.println("Current Remainder Rate: " + microRemainderRate);
          }


          microSecondNumber+= 1;
        }
    	  currTime += 1;
        if (minutesCompleted > ratesList.length+1)
        {
          break;
        }
      }
      //second while loop to empty queue after first while loop runs through all time
      if (inputThread.qMess.size() != 0) {
        System.out.println("Finishing Emptying Queue of " + inputThread.qMess.size() +" Messages");
      }
      while (inputThread.qMess.size() != 0) {
        if (currTime % 1000000 == 0){
          //System.out.println("Seconds Completed: " + secondsCompleted);
          secondsCompleted += 1;
          microSecondNumber = 0;
        }

        if (microSecondNumber < microRemainderProcess) {
          inputThread.processMessages((microProcessSpeed+1), currTime);
        } else {
          inputThread.processMessages(microProcessSpeed, currTime);
        }

        microSecondNumber+= 1;
        currTime += 1;

      }

      long totalMessagesUsed = inputThread.countMessages();
      inputThread.callLatReader();
      avThroughput = (float)totalMessagesUsed / secondsCompleted;
      avLatency = inputThread.averageLatency()/1000000;
      System.out.println("Average Throughput: " + avThroughput);
      System.out.println("Average Latency: " + avLatency + " seconds\n");
      System.out.println("Total Messages Lost: " + inputThread.totalNumberDropped());
      System.out.println("Max Messages Lost: " + inputThread.maxNumberDropped());
      //System.out.println("Messages Left: " + inputThread.qMess.size());

    } else if (typeOfSimulation == 'u' || typeOfSimulation == 'U') {

      System.out.println("The Simulation will run for " + ratesList.length +" microseconds based on the CSV File Length given\n");
      long microProcessSpeed = (long) processSpeed;
      long currTime = 0;
      int listIndex = 0;
      long secondsCompleted = 0;
      long currentMicroRate = 0;
      //in time this will all go in clock class - once i figure it out
      long microSecondNumber = 0;
      float avThroughput;
      float avLatency;

      while (listIndex < ratesList.length) {
        //currTime = microsecond
        if (currTime % 1000000 == 0){
          //System.out.println("Seconds Completed: " + secondsCompleted);
          secondsCompleted += 1;
          microSecondNumber = 0;
        }

        if (currTime % 1 == 0)
        {
          currentMicroRate = Long.valueOf(ratesList[listIndex]);
          listIndex += 1;
          System.out.println("Microseconds Completed: " + microSecondNumber);
          inputThread.addMessages(currentMicroRate, currTime);
          inputThread.processMessages(microProcessSpeed, currTime);
          microSecondNumber+= 1;
        }
    	  currTime += 1;
        if (microSecondNumber > ratesList.length+1)
        {
          break;
        }
      }
      //second while loop to empty queue after first while loop runs through all time
      if (inputThread.qMess.size() != 0) {
        System.out.println("Finishing Emptying Queue of " + inputThread.qMess.size() +" Messages");
      }
      while (inputThread.qMess.size() != 0) {
        if (currTime % 1000000 == 0){
          System.out.println("Seconds Completed: " + secondsCompleted);
          secondsCompleted += 1;
        }

        inputThread.processMessages(microProcessSpeed, currTime);

        microSecondNumber+= 1;
        currTime += 1;

      }

      long totalMessagesUsed = inputThread.countMessages();
      inputThread.callLatReader();
      avThroughput = (float)totalMessagesUsed / secondsCompleted;
      avLatency = inputThread.averageLatency()/1000000;
      System.out.println("Average Throughput: " + avThroughput);
      System.out.println("Average Latency: " + avLatency + " seconds\n");
      System.out.println("Total Messages Lost: " + inputThread.totalNumberDropped());
      System.out.println("Max Messages Lost: " + inputThread.maxNumberDropped());
      //System.out.println("Messages Left: " + inputThread.qMess.size());




    } else {
      System.out.println("Please enter U (Microsecond) or M (Minute) to tell the simulation the type of input file rates.");
    }
	File file = new File("out.txt");
		if(file.delete()){
		    System.out.println("file.txt File deleted from Project root directory");
		}else System.out.println("File file.txt doesn't exist in the project root directory");
        
	File file2 = new File("SortedOut.txt");
		if(file2.delete()){
			System.out.println("file.txt File deleted from Project root directory");
		}else System.out.println("File file.txt doesn't exist in the project root directory");
  }

}
