import java.io.*;
import java.util.*;
import java.lang.*;

public class Buffer {

    List<List<String>> ratesTimes;
    int size;

    public Buffer(List<List<String>> r, int s) {

        ratesTimes = r;
        size = s;
        
    }

    public List<String> loadTimesBuffer() {

        List<String> times = new ArrayList<>();

        int size = ratesTimes.size();

        for (int i = 1; i < size; i++) {

          times.add(ratesTimes.get(i).get(0));

         }

	      return times;

    }


    public List<String> loadRatesBuffer() {

        List<String> rates = new ArrayList<>();

        int size = ratesTimes.size();

        for (int i = 1; i < size; i++) {

	        rates.add(ratesTimes.get(i).get(1));
	      }

        return rates;


    }



    public int getSize(List<String> listRates) {

        int cnt = listRates.size();

        return cnt;

    }


    public String getRate(List<String> listRates, int index) {


        String retString = listRates.get(index);

        return retString;

    }



}
