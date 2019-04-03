public class Message {

  long inTime,outTime,travelTime;

  public Message(long in) {
    inTime = in;
  }

  public double calculateTravel() {

    travelTime = outTime - inTime;
    return travelTime;

  }

  public void setIn(long numTime) {

    inTime = numTime;

  }

  public void setOut(long numTime2) {

    outTime = numTime2;

  }

}
