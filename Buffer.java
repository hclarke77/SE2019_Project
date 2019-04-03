import java.io.*;
import java.util.*;
import java.lang.*;

public class Buffer {

long time;
long messagesProcessed;
long numMessages;
long bufferSize;
Queue<Message> qMess;

public Buffer(long size) {

  Queue qMess = Queue<Message>(bufferSize);

}

public void addMessages(long rate, long currTime) {
  time = currTime;
  numMessages = rate;
  for(int i=0;i<numMessages;i++) {
    qMess.add(new Message(time));

  }
}

public void processMessages(long rate, long currTime) {
  time = currTime;
  numMessages = rate;










}



public int numberDropped() {

  int dropped;
  dropped =

}





}
