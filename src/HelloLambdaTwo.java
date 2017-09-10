/**
 * Created by samar.kumar on 15/06/15.
 */
public class HelloLambdaTwo {

    public interface Function {
        Integer compute(Integer first, Integer second);
    }


    public void runLambda(Function func, Integer first, Integer second) {
        System.out.println("function result " + func.compute(first, second));
    }


    public static void main(String args[]) {

        Function addition = (Integer a, Integer b) -> {
            return a + b;
        };
        Function substraction = (Integer a, Integer b) -> {
            return a = b;
        };


        HelloLambdaTwo hl = new HelloLambdaTwo();
        hl.runLambda(addition, 10 , 20);

    }
}
