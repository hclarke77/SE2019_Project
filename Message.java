public class Message {

  double inTime,outTime,travelTime;
  
  public Message() {
    
    }
    
  public double calculateTravel() {
  
    travelTime = out - in;
    return travelTime;
    
}

  public void setIn(double numTime) {
  
    inTime = numTime;
    }
    
  public void setOut(double numTime2) {
  
    outTime = numTime2;
    }
}
    
  