/**
 * Created by samar.kumar on 11/06/15.
 */
public class HelloLambda {

    interface FunctionMaths {

        Integer math(Integer a, Integer b);

    }

    void calculate(Integer a, Integer b , FunctionMaths operator){
        System.out.print(operator.math(a, b));
    }


    public static void main(String args[]){
        FunctionMaths addition = (a, b ) ->  { return  a + b ;};
        FunctionMaths subtraction = (a, b ) ->  { return  a - b ;};


        HelloLambda hl = new HelloLambda();
        hl.calculate(10, 20 , addition);
        hl.calculate(20,5, subtraction);

    }
}
