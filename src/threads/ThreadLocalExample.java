package threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by samar.kumar on 5/25/17.
 */
public class ThreadLocalExample implements Runnable{

    List<String> threadLocalString ;
    public ThreadLocalExample(ThreadLocal<List<String>> something){
        threadLocalString = something.get();
    }
    @Override
    public void run() {
        while (true) {
            threadLocalString.set(0,  Thread.currentThread().getName());
            System.out.println("hello" + Thread.currentThread().getName() + "value :" + threadLocalString);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        ThreadLocal<List<String>> threadLocal = new ThreadLocal<List<String>>();
        List<String > sharedList = new ArrayList<String>();
        sharedList.add("FirstThread");
        threadLocal.set(sharedList);

        es.execute(new ThreadLocalExample(threadLocal));
        sharedList.add("SecondThread");
        es.execute(new ThreadLocalExample(threadLocal));
        es.execute(new ThreadLocalExample(threadLocal));
        es.execute(new ThreadLocalExample(threadLocal));
        es.execute(new ThreadLocalExample(threadLocal));
        es.execute(new ThreadLocalExample(threadLocal));
        es.execute(new ThreadLocalExample(threadLocal));




    }
}
