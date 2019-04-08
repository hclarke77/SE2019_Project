import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulation {

  public static void main(String[] args) {
    //input parameters
	  long bufferSize = Long.valueOf(args[0]);
	  long processSpeed = Long.valueOf(args[1]);
    long microProcessSpeed = (long) processSpeed / 1000000;
    long microRemainderProcess = (long)processSpeed % 1000000;
    System.out.println("Micro Remainder: " + microRemainderProcess);
    System.out.println("Micro Process Speed: " + microProcessSpeed);
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

    while (listIndex < 25) { // ratesList.length) {
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
    System.out.println("Average Latency: " + avLatency + " seconds");
    System.out.println("Total Messages Lost: " + inputThread.totalNumberDropped());
    System.out.println("Max Messages Lost: " + inputThread.maxNumberDropped());
    //System.out.println("Messages Left: " + inputThread.qMess.size());
  }

}



//Unneeded code below
/*
    /*testing if it got all values
	  for (int i=0; i<vars.size();i++) {
	    System.out.println(vars.get(i));
	  }

    //list to store messages.
    List<Message> listMessage = new ArrayList<>(bufferSize);
    //need to figure out loss rate from this.

    //initialize clock object
    Clock simulClock = new Clock();

    //ill work on this part - Romeo
    new Timer().scheduleAtFixedRate(currentRate = simulateMinute.runSimulation(), .5, 1);

    //start of simulation
    while(!listMessage.isEmpty()){
      int z=0;
      int messagesCreated = listMessage.get(z);
      if (messagesCreated < 1000000) {
        int messagesPerMilli
      }
      int messagesPerNano = ((messagesCreated / 1000000) + (messagesCreated % 1000000));
      z = z++;

      for (int j=0; j<1000000; j++) {

  	     for (int i=0; i < messagesCreated; i++) {

  	        listMessage.add(new Message());
  	     }
         clock.wa
      }

      /*

      if travelArray.size() % 2 == 1 {
        index = travelArray.size() // 2 + 1;
      } else {
        index = travelArray.size() / 2;
      }

  	  //calculate total travel
  	  double totalTime;
  	  for(int j=0; j < ListTimesRates.size(); j++) {

  	    double travel = listMessage.get(j).calculateTravel;

  	    totalTime += travel;

      }

      /* DO NOT NEED AT THE MOMENT.
  	  //ProccesingUnit(double speed, Buffer B)
  	  ProcessingUnit rateProcessor = new ProcessingUnit(2,ListTimesRates);
  	  List<Double> dubs = rateProcessor.processRates();
            Clock ctimes = new Clock(1,dubs);
            //Long waitTime = 1000000000;
            //ctimes.waitFor(waitTime);
            System.out.println("Latency: ");
            System.out.println(ctimes.calcuLatency().toString());
            System.out.println("Throughput: ");
  	  System.out.println(ctimes.calcuThroughput().toString());*/
