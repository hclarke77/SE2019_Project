import java.io.*;
import java.util.*;
import java.lang.*;

public class simulateMinute extends TimerTask {

  List<Integer> ratesOfMessages;
  double processorSpeed;
  int bufferSize;

  public simulateMinute(int buff, double proSpeed, List<Integer> speeds) {
    bufferSize = buff;
    processorSpeed = proSpeed;
    ratesOfMessages = speeds;
  }
  public void run() {
    System.out.println("This will print every minute");
  }

  public int runSimulation(int index) {
    return ratesOfMessages.get(index);
  }




}
