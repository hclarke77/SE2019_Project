import java.io.*;
import java.util.*;
import java.lang.*;

public class Buffer {


long time;
long messagesProcessed;
long numMessages;
long bufferSize;
long numberLost;
long maxNumberLost;
long totalNumberLost;
Queue<Message> qMess;


public Buffer(long size) {

  bufferSize = size;
  Queue<Message> qMess = new LinkedList<Message>();
  System.out.println(qMess);
  maxNumberLost = 0;
  totalNumberLost = 0;

}


public void addMessages(long rate, long currTime) {
  time = currTime;
  System.out.println("Buffer Current Time Is: " + time);
  numMessages = rate;
  numberLost = 0;
  for(int i=0;i<numMessages;i++) {
    System.out.println("Iteration: "+i);
    System.out.println(qMess);
    if (qMess.size() < bufferSize) {
      qMess.add(new Message(time));
      System.out.println("Queue Current Size Is: " + qMess.size());
    }
    else {
      numberLost += 1;
      totalNumberLost += 1;
      if (numberLost >= maxNumberLost) {
        maxNumberLost = numberLost;
      }
    }
  }
}


public void processMessages(long rate, long currTime) {
  time = currTime;
  messagesProcessed = rate;
  System.out.println(qMess.size());
  if (qMess.size() > 0){
    for(int i=0;i<numMessages;i++) {
        Message x = qMess.remove();
        x.setOut(time);
        System.out.println(x.calculateTravel());
    }
  } else {
    System.out.println("No messages to be processed.");
  }

}


public long maxNumberDropped(){

  return maxNumberLost;

}

public long totalNumberDropped() {

  return totalNumberLost;

}


}
