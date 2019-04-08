import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Random;

public class Latency {
    int[] arr;
    int buffSize;
    int count;
    //Creates a Latency object with an array of size buffSize
    public Latency(int buff) throws IOException{
        arr = new int[buff];
        buffSize = buff;
        count = 0;
    }

    //Adds message_lat to array. If array is full, push array to 'out.txt' file and clear array
    public void addLat(int message_lat) throws IOException {
        BufferedWriter BuffedOut = null;
        arr[count] = message_lat;
        count++;

        try {
            BuffedOut =  new BufferedWriter(new FileWriter("out.txt",true));

            if (count == buffSize) {
                //System.out.println("Array full");
                //System.out.println("Before Sorting: " + Arrays.toString(arr));
                mergeSort(arr,count);
                //System.out.println("After Sorting: " + Arrays.toString(arr));
                String StrArray = Arrays.toString(arr);
                StrArray = StrArray.replace("[","");
                StrArray = StrArray.replace("]","");
                BuffedOut.write(StrArray);
                BuffedOut.newLine();
                arr = new int[buffSize];
                count = 0;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (BuffedOut != null) {
                    BuffedOut.close();
                }
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

    //Reads the file 'out.txt' line by line putting it in a List<Integer>
    //then once the file is finished reading, converts the list to an array
    //and calls mergeSort. Puts output in 'SortedOut.txt'
    public void LatReader()  throws IOException{
        File file = new File("out.txt");
        FileWriter out = new FileWriter("SortedOut.txt");
        BufferedReader Buffread = null;
        String sCurrentLine;
        List<Integer> finalList = new LinkedList<Integer>();;
        try {
            Buffread = new BufferedReader(new FileReader(file));
            while ((sCurrentLine = Buffread.readLine()) != null) {
                String[] Linearr = sCurrentLine.split(", ");
                int size = Linearr.length;
                int [] tmp = new int[size];
                for(int i=0; i<size; i++) {
                    tmp[i] = Integer.parseInt(Linearr[i]);
                    finalList.add(tmp[i]);
                }
            }

            int[] finalarr = finalList.stream().mapToInt(Integer::intValue).toArray();
            int half = finalarr.length/2;
            int seventyfive = half + half/2;
            double ninty = finalarr.length/1.111;
            double nintynine = finalarr.length/1.0001;
            System.out.println("Fifty percent: " + finalarr[half]);
            System.out.println("Seventy-Five percent: " + finalarr[seventyfive]);
            System.out.println("Ninty percent: " + finalarr[(int) ninty]);
            System.out.println("Ninty-nine percent: " + finalarr[(int) nintynine]);
            mergeSort(finalarr,finalarr.length);
            out.write(Arrays.toString(finalarr));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if (Buffread != null) {
                Buffread.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }

    //Sorts an array of ints of length 'n' by recursion calling
    //and calling 'merge' to merge multiple sorted arrays
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    //Merges multiple arrays of ints
    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /*public static void main(String[] args) throws IOException {
        Latency lat = new Latency(20);
        for (int i = 0; i < 20; i++) {
            Random rand = new Random();
            int value = rand.nextInt(100);
            lat.addLat(value);
        }
        System.out.println("Starting LatReader: ");
        File out = new File("out.txt");
        lat.LatReader();
    }*/
}
