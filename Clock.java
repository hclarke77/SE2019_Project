public class Clock {
	
	double starTime;
	double endTime;
	double time;
	double averageTime;
	
	
	//calculate one message time
	public double calcuTime(double starTime, double endTime) 
	{

		time = starTime - endTime;
		
		return time;
	}
	
	
	//calculate average time
	public double calcuAverageTime(double[] arrayTime)
	{
		double totalTime=0;

		for( int i = 0; i < arrayTime.length; i++ )
		{
			totalTime = totalTime + arrayTime[i];
			
		}
		
		averageTime = totalTime / arrayTime.length;
		
		return averageTime;
	}

}
