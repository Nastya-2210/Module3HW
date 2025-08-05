import java.io.*;
import java.util.List;

public class ReadingObject {
    public static void main(String[] args) {
        try {
            List<Person> people = readPeopleFromFile("test");
            System.out.println("Data read from file:");
            people.forEach(System.out::println);
        } catch (FileStorageException e) {
            System.err.println("Failed to read data: " + e.getMessage());
        }
    }

    public static List<Person> readPeopleFromFile(String filename) throws FileStorageException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileStorageException("File not found: " + filename, null);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            List<Person> people = (List<Person>) ois.readObject();
            return people;
        } catch (IOException | ClassNotFoundException e) {
            throw new FileStorageException("Error reading from file " + filename, e);
        }
    }
    }
