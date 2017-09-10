import java.util.Random;

/**
 * Created by samar.kumar on 14/10/15.
 */
public class TestClass {

    public static void main(String[] args) {

        Random r = new Random();


        for (int i = 0; i <= 10; i++) {
            System.out.println("random number " + r.nextInt(4));
        }

        TestClass testClass = new TestClass();
        testClass.checkFinally();

    }

    void checkFinally() {

        try {
            System.out.print("Before Return");
            return;
        } catch (Exception ex) {

        } finally {
            System.out.print("finally");
        }

    }

}
