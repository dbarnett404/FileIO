import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> allPeople = new ArrayList<>();
        //Use the new readFileData you have made to read the file FileIO.peopleFile to populate the ArrayList
        //Print out the ArrayList
        //allPeople = FileIO.readFileData(FileIO.peopleFile);
        for (Person p: allPeople) {
            System.out.println(p);
        }
    }
}
