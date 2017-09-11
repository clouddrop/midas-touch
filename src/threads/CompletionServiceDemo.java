package threads;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//All the future results will be available as f = completionService.take();
// Just create a new CompletionService<String> completionService = new ExecutorCompletionService<>(exec); and call completionService.submit(task);
public class CompletionServiceDemo {

    public void compServDemo(final Executor exec) {

        CompletionService<String> completionService = new ExecutorCompletionService<>(exec);

        for (int i = 0; i < 4; i++) {
            // Callable task that will be submitted to CompletionService.
            Callable<String> task = new Callable<String>() {

                @Override
                public String call() {
                    try {
                        System.out.println("Started " + Thread.currentThread().getName() + " at " + new Date());
                        Thread.sleep(5000);
                        System.out.println("Exiting " + Thread.currentThread().getName() + " at " + new Date());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return Thread.currentThread().getName() + " success!!!";
                }
            };

            // Submitting the task to the CompletionService
            completionService.submit(task);
        }

        // Waiting for the results and printing them
        for (int i = 0; i < 4; i++) {
            Future<String> f;
            try {
                f = completionService.take();
                System.out.println("RESULT=" + f.get() + " at " + new Date());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        CompletionServiceDemo cSD = new CompletionServiceDemo();
        ExecutorService e = Executors.newFixedThreadPool(2);
        cSD.compServDemo(e);

        e.shutdown();
    }
}