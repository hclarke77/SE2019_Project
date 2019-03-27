import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulation {


  public static void main(String[] args) {

    //input parameters
	  int bufferSize = args[0];
	  double processSpeed = args[1];

	  //Asks user for file name they wish to simulate
	  Scanner scanner = new Scanner (System.in);
	  System.out.println("Enter your File name: ");
	  String Filename = scanner.next();

	  //Calls csv Reader on user's File
	  csvReader reader = new csvReader(Filename);

    //stores list of rates - one minute after another
	  List<Integer> ratesList = reader.exportVariables();

    /*testing if it got all values
	  for (int i=0; i<vars.size();i++) {
	    System.out.println(vars.get(i));
	  }*/

    //list to store messages.
    List<Message> listMessage = new ArrayList<>(bufferSize);
    //need to figure out loss rate from this.

    //start of simulation
    while()
	  for (int i=0; i < listMessage.get(z); i++) {
	    listMessage.add(new Message());
	  }

    long simStartTime = System.nanoTime();

    /*

    if travelArray.size() % 2 == 1 {
      index = travelArray.size() // 2 + 1;
    } else {
      index = travelArray.size() / 2;
    }

    */

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
}
}
