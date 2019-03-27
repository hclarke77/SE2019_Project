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


    public List<Integer> exportVariables() {

        List<Integer> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(csvFilename));) {
          scanner.useDelimiter(",").nextLine();
            while (scanner.hasNextLine()) {
		            //String line = scanner.nextLine();
                records.add(Integer.valueOf(getRecordFromLine(scanner.nextLine()).get(1)));

            }

            return records;
        } catch (FileNotFoundException e) {
          for (int i=0; i<records.size(); i++) {
            System.out.println(records.get(0));
          }

          return records;
	     }
    }

    private List<String> getRecordFromLine(String line) {
      List<String> values = new ArrayList<String>();
      try (Scanner rowScanner = new Scanner(line)) {
        rowScanner.useDelimiter(",");
        while (rowScanner.hasNext()) {
            values.add(rowScanner.next());
        }

        return values;

      }
    }

    public static void main(String[] args) {
      String file = args[0];
      csvReader reader = new csvReader(file);
      reader.exportVariables();

    }


}
