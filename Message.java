public class Message {

  double inTime,outTime,travelTime;

  public Message() {

    }

  public double calculateTravel() {

    travelTime = outTime - inTime;
    return travelTime;

}

  public void setIn(double numTime) {

    inTime = numTime;
    }

  public void setOut(double numTime2) {

    outTime = numTime2;
    }
}
