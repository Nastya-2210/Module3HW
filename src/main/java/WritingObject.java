import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WritingObject {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Bob"));
        people.add(new Person("Kate"));
        people.add(new Person("Tom"));

        try {
            writePeopleToFile(people, "test");
            System.out.println("Data successfully written to file");
        } catch (FileStorageException e) {
            System.err.println("Failed to write data: " + e.getMessage());
        }
    }

    public static void writePeopleToFile(List<Person> people, String filename) throws FileStorageException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
        } catch (IOException e) {
            throw new FileStorageException("Error writing to file " + filename, e);
        }
    }
}
