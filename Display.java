import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.String;

public class Display {

  long buffSize;
  long simSpeed;
  String inputFile;
  Clock timer;

  public Display(long bufferSize, long speed, String file) {
    long buffSize = bufferSize;
    long simSpeed = speed;
    String inputFile = file;

    System.out.println(inputFile);
    System.out.println(simSpeed);
    System.out.println(buffSize);

  }
}
