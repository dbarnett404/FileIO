import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileIO {
    public final static String dataFile = "dataFile.txt";
    public final static String peopleFile = "src\\peopleData.txt";

    /**
     * Uses BufferedWriter to write / save a text file containing the content of the ArrayList
     * TASK: Change this method so that the ArrayList uses the Person class instead of the String Class
     * to save the file
     * @param fileName
     * @param saveData
     */
    public static void saveFileData(String fileName, ArrayList<String> saveData) {
        // Creates a BufferedWriter using try with resources so no need to close the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String s: saveData) {
                // Writes the string to the file
                writer.write(s + System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " "
                    + fileName + " cannot be written to at "
                    + Paths.get("").toAbsolutePath().normalize().toString());
        }
    }

    /**
     * Uses BufferedReader to read a text file and store the content of the file in an ArrayList
     * TASK: Change this method so that it returns an ArrayList of the Person class
     * Use the Constructor new Person(lineStr) so add the String to the Person class
     * @param fileName
     * @return the ArrayList containing the file data
     */
    public static ArrayList<String> readFileData(String fileName) {
        //Create a new ArrayList
        ArrayList<String> fileData = new ArrayList<>();
        // Creates a BufferedReader using try with resources so no need to close the file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String lineStr;
            //While there are lines in the file
            while ((lineStr = reader.readLine()) != null)
                //Add lines to the ArrayList
                fileData.add(lineStr);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + " "
                    + fileName + " not found at "
                    + Paths.get("").toAbsolutePath().normalize().toString());
        } catch (IOException e) {
            System.out.println(e.getMessage() + " "
                    + fileName + " cannot be read at "
                    + Paths.get("").toAbsolutePath().normalize().toString());
        }
        return fileData;
    }
}
