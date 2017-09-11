package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by samar.kumar on 9/11/17.
 */
public class CallBackMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        CallingBackWorker worker = new CallingBackWorker(new CalledBack());

        final Future future = es.submit(worker);
        System.out.println("...try to do something while the work is being done....");
        System.out.println("...and more ....");
        System.out.println(" End work" + new java.util.Date());
        es.shutdown();

    }
}

interface CallbackInterface {

    public void returnResult(String result);
}

class CalledBack implements CallbackInterface {
    Object result;

    public void returnResult(String result) {
        System.out.println("Result Received in callback" + result);
        this.result = result;
    }


}

class CallingBackWorker implements Callable {
    private CallbackInterface callback;

    public CallingBackWorker(CallbackInterface callback) {
        this.callback = callback;
    }

    public Object call() {

        //new SlowWorker().doWork();

        callback.returnResult(" Task Completed ");
        return null;
    }


    public CallbackInterface getEmployer() {
        return callback;
    }
}
