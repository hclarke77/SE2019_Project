import java.io.*;
import java.util.*;
import java.lang.*;

public class Clock {

	long startTime;
	long counter;
	long currTime;
	long endTime;
	long microSecondsPassed=0;
	long secondsPassed;
	long minutesPassed;

	public Clock(){
	  startTime = 0;
		//take simulation class as object
	}

	public void runClock() {
		currTime = startTime;
		while (True) {
			currTime = currTime+1;
			if (currTime%1000 == 0) {
				microSecondsPassed += 1;
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
