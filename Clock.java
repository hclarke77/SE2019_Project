import java.io.*;
import java.util.*;
import java.lang.*;

public class Clock {


	double averageTime;
	double speed;
	List<Double> times;

	public Clock(double s, List<Double> t){

	  speed = s;
	  times = t;

	}

	//Need to be fixed!!!!!

	//calculate one message time
	public void waitFor(Long speedup)
	{

	  for (int i=0; i<times.size(); i++) {

	      //wait(speedup*times.get(i)/1000000000);
	  }
	}

	public Double calcuThroughput()
	{
		double totalTime = 0;

		for( int i = 0; i < times.size(); i++ )
		{
			totalTime = totalTime + times.get(i);

		}

		return totalTime;
	}

	//calculate average time
	public Double calcuLatency()
	{
		double averageTime = calcuThroughput()/times.size();

		return averageTime;
	}

}
