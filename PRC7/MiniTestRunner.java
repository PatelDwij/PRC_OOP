
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTests {

    @Run
    public void testAddition() {
        System.out.println("Addition test passed");
    }

    @Run
    public void testSubtraction() {
        System.out.println("Subtraction test passed");
    }

    public void normalMethod() {
        System.out.println("This method will not run");
    }
}

public class MiniTestRunner {

    public static void main(String[] args)
            throws Exception {

        MyTests test = new MyTests();
        int count = 0;

        for (Method method :
                test.getClass().getDeclaredMethods()) {

            if (method.isAnnotationPresent(Run.class)
                    && method.getParameterCount() == 0) {

                method.invoke(test);
                count++;
            }
        }

        System.out.println("Total tests run: " + count);

        System.out.println("25CE077 - Dwij");
    }
}
