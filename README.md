# SE2019_Project

This Github is for the Software Engineering 2019 Spring Project

Build Instructions:

javac *.java

Run Instructions:

java Simulation bufferSize processorSpeed typeOfFile numThreads

*When prompted for csvFile enter 'FeedRates.csv'*

bufferSize: How many messages the input thread can hold
processorSpeed: Depending on the input for typeOfFile- either number of messages processed per minute or per microsecond
typeOfFile: either 'U'(microsecond) or 'M'(minute) - tells the simulation to get new rates every microsecond from the inputted CSV or every minute
numThreads: How many threads to run the simulation

SHA Hash to Grade:

f8874356cd0a7ccf04e5724ecb5d54e93c55f570
