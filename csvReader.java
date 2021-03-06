import java.io.*;
import java.util.*;


public class csvReader {

  String csvFilename;

    public csvReader(String f) {

        csvFilename = f;

    }

    public String getFilename() {

        return csvFilename;
    }


    public int getLengthOfFile(String f) {
      int rowCount = 0;
      try (Scanner scanner = new Scanner(new File(csvFilename));) {
        scanner.useDelimiter(",").nextLine();
        while (scanner.hasNextLine()) {
          rowCount += 1;
          String line = scanner.nextLine();
          //System.out.println("There are: " + rowCount + " rows");
        }

      } catch (FileNotFoundException e) {
        System.out.println("Error opening file.");
        return rowCount;
      }
      //System.out.println("There are: " + rowCount + " rows");
      return rowCount;

    }

    /*


    */
    public int[] exportVariables() {
	     int i = 0;
       int rowCount;
       rowCount = getLengthOfFile(csvFilename);
       int[] records = new int[rowCount];
       //System.out.println(records.length);
       try (Scanner scanner = new Scanner(new File(csvFilename));) {
          scanner.useDelimiter(",").nextLine();
            while (scanner.hasNextLine()) {
		            //String line = scanner.nextLine();
                records[i] = Integer.valueOf(getRecordFromLine(scanner.nextLine()).get(1));
	              i += 1;
            }
            //System.out.println(records.length);
            return records;
        } catch (FileNotFoundException e) {
          return records;
	     }
    }

    private ArrayList<String> getRecordFromLine(String line) {
      ArrayList<String> values = new ArrayList<String>();
      try (Scanner rowScanner = new Scanner(line)) {
        rowScanner.useDelimiter(",");
        while (rowScanner.hasNext()) {
            values.add(rowScanner.next());
        }

        return values;

      }
    }

    //testing if it prints all of them
    public static void main(String[] args) {
      String file = args[0];
      csvReader reader = new csvReader(file);
      int[] mylist = reader.exportVariables();
      for (int i=0; i<mylist.length; i++){
        System.out.println(mylist[i]);
      }


    }


}
