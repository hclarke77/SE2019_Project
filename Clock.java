import java.io.*;
import java.util.*;
import java.lang.*;

public class Clock {

	long startTime;
	long currTime;
	long endTime;

	public Clock(){

	  startTime = 0;
	  currTime = 0;
	  endTime = 0;
	}

	public long StartTime(){
		startTime = System.nanoTime();
		return startTime;
	}

	public long CurrentTime(){
		currTime = System.nanoTime();
		return currTime;
	}

	public long EndTime(){
		endTime = System.nanoTime();
		return endTime;
		}
}
