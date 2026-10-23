
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    @MaxLength(20)
    String name;

    @NotBlank
    @MaxLength(30)
    String email;

    SignupForm(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class FormValidator {

    static List<String> validate(Object obj)
            throws IllegalAccessException {

        List<String> errors = new ArrayList<>();

        Class<?> cls = obj.getClass();

        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotBlank.class)) {
                if (value == null ||
                    value.toString().trim().isEmpty()) {
                    errors.add(field.getName()
                            + " cannot be blank");
                }
            }

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength max =
                        field.getAnnotation(MaxLength.class);

                if (value != null &&
                    value.toString().length() > max.value()) {
                    errors.add(field.getName()
                            + " exceeds maximum length "
                            + max.value());
                }
            }
        }

        return errors;
    }

    public static void main(String[] args)
            throws IllegalAccessException {

        SignupForm form = new SignupForm(
                "", "verylongemailaddress@example.com");

        List<String> errors = validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }

        System.out.println("25CE077 - Dwij");
    }
}
