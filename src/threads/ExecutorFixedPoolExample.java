package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by samar.kumar on 9/11/17.
 */
public class ExecutorFixedPoolExample {

    private final int THREADS = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor = Executors.newFixedThreadPool(THREADS);


    public static void main(String[] args) throws Exception {


        ExecutorFixedPoolExample e = new ExecutorFixedPoolExample();
        System.out.println(e.invokeApi());
        e.executor.shutdown();;
    }

    public Integer invokeApi() throws Exception{

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            public Integer call() {

                try{
                    Thread.sleep(10000);
                }catch (Exception ex){
                    throw new RuntimeException(ex);
                }

                return 1;
            }
        });

        Future<Integer> future2 = executor.submit(new Callable<Integer>() {
            public Integer call() {

                try{
                    Thread.sleep(10000);
                }catch (Exception ex){
                    throw new RuntimeException(ex);
                }

                return 2;
            }
        });

        return  future.get() + future2.get();
        // do stuff with result
    }


}
