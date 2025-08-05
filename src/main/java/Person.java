import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private static transient int nextId = 1;
    public int id;
    private final String name;

    public Person(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
