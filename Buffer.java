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
  qMess = new LinkedList<Message>();
  //qMess.add(new Message(size));
  maxNumberLost = 0;
  totalNumberLost = 0;

}


public void addMessages(long rate, long currTime) {
  time = currTime;
  System.out.println("Buffer Current Time Is: " + time);
  numMessages = rate;
  numberLost = 0;
  for(int i=0;i<numMessages;i++) {
    if (qMess.size() < bufferSize) {
      qMess.add(new Message(time));
    }
    else {
      numberLost += 1;
      totalNumberLost += 1;
      if (numberLost >= maxNumberLost) {
        maxNumberLost = numberLost;
      }
    }
  }
  System.out.println("Queue Current Size Is: " + qMess.size());
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

/*public boolean isEmpty() {

  if (qMess.size() > 0) {
  return false;
  } else {
  return true;
  }
}
*/

public long maxNumberDropped(){

  return maxNumberLost;

}

public long totalNumberDropped() {

  return totalNumberLost;

}


}
