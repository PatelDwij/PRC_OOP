
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
    }
}

public class SaveLoad {

    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Dwij", "abc123"),
            new Student(2, "Rahul", "xyz456")
        };

        // Save objects to a file
        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                         new FileOutputStream("students.dat"))) {

            out.writeObject(students);
            System.out.println("Objects saved successfully.");

        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
            System.out.println("25CE077 - Dwij");
            return;
        }

        // Load objects into a new array
        try (ObjectInputStream in =
                     new ObjectInputStream(
                         new FileInputStream("students.dat"))) {

            Student[] loaded =
                    (Student[]) in.readObject();

            System.out.println("\nLoaded objects:");

            for (Student s : loaded) {
                s.display();
                System.out.println();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load error: " + e.getMessage());
        }

        System.out.println("25CE077 - Dwij");
    }
}
