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
  Queue qMess = Queue<Message>(bufferSize);
  maxNumberLost = 0;
  totalNumberLost = 0;

}

public void addMessages(long rate, long currTime) {
  time = currTime;
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
}

public void processMessages(long rate, long currTime) {
  time = currTime;
  messagesProcessed = rate;
  for(int i=0;i<numMessages;i++) {
      Message x = qMess.remove();
      x.setOut(time);
  }
}




public long maxNumberDropped(){

  return maxNumberLost;

}

public long totalNumberDropped() {

  return totalNumberLost;

}





}
