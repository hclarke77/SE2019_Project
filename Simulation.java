import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.String;

public class Simulation {

  long buffSize;
  long simSpeed;
  String inputFile;
  Clock timer;

  public Simulation(long bufferSize, long speed, String file) {
    long buffSize = bufferSize;
    long simSpeed = speed;
    String inputFile = file;

    System.out.println(inputFile);
    System.out.println(simSpeed);
    System.out.println(buffSize);

  }

  public runSimulation() {

  }

  public static void main(String[] args) {
    //testing the parameter grabbing
    Simulation romeo = new Simulation(1000, 10, "romeoisthebest");
  }




}
