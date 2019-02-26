import java.io.*;
import java.util.*;
import java.lang.*;

public class Clock {
	
	/*Returns the current value of the system timer, in nanoseconds
      System.out.print("time in nanoseconds = ");
      System.out.println(System.nanoTime());*/
	long StartTime;
	long EndTime;
	long TimeSum = 0;
	long Avg;
	
//Calculates the difference between the start time and the end time of a message
	public long TimeDiff(long STime, long ETime) {
		long TotalTime = ETime - STime;
		return TotalTime;
	}
	
//Caclulates the average time from an array of time differences
	public long avgTime (int[] ArrTimes){
		for (int i = 0; i < ArrTimes.length; i++){
			TimeSum = TimeSum + ArrTimes[i];
			Avg = TimeSum / i;
		}
		return Avg;
	}
}
