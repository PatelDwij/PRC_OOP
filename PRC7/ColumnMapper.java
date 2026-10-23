
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {

    @Column(name = "student_name")
    String name;

    @Column(name = "student_age")
    int age;

    @Column(name = "student_email")
    String email;

    public String toString() {
        return name + ", " + age + ", " + email;
    }
}

public class ColumnMapper {

    static Student mapStudent(
            String[] header, String[] data)
            throws Exception {

        Student student = new Student();
        Class<?> cls = student.getClass();

        for (Field field : cls.getDeclaredFields()) {

            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }

            Column column = field.getAnnotation(Column.class);
            String columnName = column.name();

            int index = -1;

            for (int i = 0; i < header.length; i++) {
                if (header[i].equals(columnName)) {
                    index = i;
                    break;
                }
            }

            // Skip missing columns
            if (index == -1 || index >= data.length) {
                continue;
            }

            field.setAccessible(true);
            String value = data[index];

            if (field.getType() == String.class) {
                field.set(student, value);
            } else if (field.getType() == int.class) {
                field.setInt(student, Integer.parseInt(value));
            }
        }

        return student;
    }

    public static void main(String[] args)
            throws Exception {

        String[] header = {
            "student_email", "student_name", "student_age"
        };

        String[] data = {
            "dwij@example.com", "Dwij", "20"
        };

        Student s = mapStudent(header, data);

        System.out.println(s);

        System.out.println("25CE077 - Dwij");
    }
}
