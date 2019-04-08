import java.io.*;
import java.util.*;
import java.lang.*;

public class Clock {

	long startTime;
	long counter;
	long currTime=0;
	long endTime;
	long secondsPassed=0;
	long minutesPassed=0;

	public Clock(){
	  startTime = 0;
		//take simulation class as object
	}

	public void stopClock() {

	}
	public void runClock() {
		currTime = startTime;
		while (true) {
			currTime = currTime+1;
			if (currTime%1 == 0) {
				this.notify();

			};
			if (currTime % 1000000 == 0) {
				secondsPassed += 1;

			};
			 if (currTime % 60000000 == 0) {
				minutesPassed += 1;
				this.notifyAll();

			};

		}
	}

	public long currentTime(){
		return currTime;
	}

}
