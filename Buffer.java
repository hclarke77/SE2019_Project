import java.io.*;
import java.util.*;
import java.lang.*;

public class Buffer {


long time;
long messagesProcessed;
long numMessages;
long bufferSize;
int averageLat;
long totalMessages;
long numberLost;
long maxNumberLost;
long totalNumberLost;
Queue<Message> qMess;
//public static Latency lat;

public Buffer(long size) {

  bufferSize = size;
  qMess = new LinkedList<Message>();
  //qMess.add(new Message(size));
  maxNumberLost = 0;
  totalNumberLost = 0;
  totalMessages = 0;
  //lat = new Latency((int) bufferSize);

}


public void addMessages(long rate, long currTime) {
  time = currTime;
  //System.out.println("Buffer Current Time Is: " + time);
  numMessages = rate;
  numberLost = 0;
  if (numMessages > 10){
    System.out.println("Incoming Rate: " + numMessages + "\nCurrent Buff Size: " + qMess.size());
  }
  for(int i=0;i<numMessages;i++) {
    if (qMess.size() < bufferSize) {
      qMess.add(new Message(time));
      totalMessages += 1;
    }
    else {
      //System.out.println("Losing Messages");
      numberLost += 1;
      totalNumberLost += 1;
      if (numberLost >= maxNumberLost) {
        maxNumberLost = numberLost;
      }
    }
  }
  //System.out.println("Queue Current Size Is: " + qMess.size());
}


public void processMessages(long rate, long currTime) {
  time = currTime;
  messagesProcessed = rate;
  //System.out.println(qMess.size());
  for(int i=0;i<messagesProcessed;i++) {
    if (qMess.size() > 0){
      Message x = qMess.remove();
      x.setOut(time);
      averageLat += x.calculateTravel();
      //lat.addLat( ( (int) x.calculateTravel() ) );
    }
  }

}

/*public boolean isEmpty() {

  if (qMess.size() > 0) {
  return false;
  } else {
  return true;
  }
}
*/
public static void callLatReader() {
  //lat.LatReader();
}

public float averageLatency() {

  return (float)averageLat / totalMessages;
}

public long countMessages() {
  return  totalMessages;
}

public long maxNumberDropped(){

  return maxNumberLost;

}

public long totalNumberDropped() {

  return totalNumberLost;

}


}
