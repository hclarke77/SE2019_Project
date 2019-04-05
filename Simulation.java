import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulation {

  public static void main(String[] args) {
    //input parameters
	  long bufferSize = Long.valueOf(args[0]);
	  double processSpeed = Double.valueOf(args[1]);
    long microProcessSpeed = java.lang.Math.round(processSpeed * .000001);

    Buffer inputThread = new Buffer(bufferSize);

	  //Asks user for file name they wish to simulate
	  Scanner scanner = new Scanner (System.in);
	  System.out.println("Enter your File name (must be CSV): ");
	  String Filename = scanner.next();
    scanner.close();

	  //Calls csv Reader on user's File
	  csvReader reader = new csvReader(Filename);

    //stores list of rates - one minute after another
	  List<Integer> ratesList = reader.exportVariables();

    long currTime = 0;
    int listIndex = 0;
    long minuteDivide = 6 * 10^9;
    int averageLatency;
    long currentSecRate = Long.valueOf(ratesList.get(listIndex));
    long currentMicroRate = currentSecRate / 1000000;
    //in time this will all go in clock class - once i figure it out
    long microRemainderRate = currentSecRate % 1000000;

    while (true) {
      //currTime = microsecond
      if (currTime % minuteDivide == 0) {
        currentSecRate = Long.valueOf(ratesList.get(listIndex));
        currentMicroRate = java.lang.Math.round(currentSecRate * .000001);
        listIndex += 1;
      }

      if (currTime % 1 == 0)
      {
        inputThread.addMessages(20, currTime);
        inputThread.processMessages(microProcessSpeed, currTime);
        System.out.println(currentMicroRate);
        System.out.println(microRemainderRate);
      }

      currTime += 1;

    }

  }

}





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
