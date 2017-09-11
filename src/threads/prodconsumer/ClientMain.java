package threads.prodconsumer;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by samar.kumar on 9/11/17.
 */
public class ClientMain {

    public static void main(String[] args) {

        LinkedList<Integer> queue = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition fullCondition = lock.newCondition();
        Condition emptyCondition = lock.newCondition();
        int CAPACITY = 10;


        Thread producer = new Thread(new Producer(queue, lock, fullCondition, emptyCondition, CAPACITY));
        producer.setName("Producer");
        Thread consumer = new Thread(new Consumer (queue, lock, fullCondition, emptyCondition, CAPACITY));
        consumer.setName("Consumer");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.shutdown();


    }


}


class Producer implements Runnable {

    private LinkedList<Integer> queue;
    private ReentrantLock lock;
    private Condition fullCondition ;
    private Condition emptyCondition;
    private int CAPACITY ;

    public Producer(LinkedList<Integer> queue,ReentrantLock lock ,
                    Condition fullCondition,
                    Condition emptyCondition ,int CAPACITY) {
        this.queue = queue;
        this.lock = lock;
        this.fullCondition = fullCondition ;
        this.emptyCondition = emptyCondition ;
        this.CAPACITY = CAPACITY;
    }

    @Override
    public void run() {
        int index = 0;

        while (true) {

            lock.lock();
            boolean tryInsert = true;
            while (tryInsert){
                if (queue.size() == CAPACITY){
                    try {
                        System.out.println(Thread.currentThread().getName()  + "CAPACITY FULL WAITING");
                        fullCondition.await();
                        System.out.println(Thread.currentThread().getName()  + "CAPACITY CLEARED");
                    }catch(Exception ex){
                        throw new RuntimeException(ex);
                    }


                }else{
                    queue.add(++index);
                    emptyCondition.signal();
                }
                try {
                    Thread.sleep(10);
                }catch(Exception ex ){
                    throw new RuntimeException(ex);
                }
            }
            lock.unlock();


        }
    }
}



class Consumer implements Runnable {

    private LinkedList<Integer> queue;
    private ReentrantLock lock;
    private Condition fullCondition ;
    private Condition emptyCondition;
    private int CAPACITY ;

    public Consumer(LinkedList<Integer> queue,ReentrantLock lock ,
                    Condition fullCondition,
                    Condition emptyCondition ,int CAPACITY) {
        this.queue = queue;
        this.lock = lock;
        this.fullCondition = fullCondition ;
        this.emptyCondition = emptyCondition ;
        this.CAPACITY = CAPACITY;
    }

    @Override
    public void run() {

        while (true) {


            lock.lock();
            boolean tryRemoval = true;
            while (tryRemoval){
                if (queue.size() == 0){
                    try {
                        System.out.println(Thread.currentThread().getName()  + "CAPACITY EMPTY");
                        emptyCondition.await();
                        System.out.println(Thread.currentThread().getName()  + "CAPACITY NOT EMPTY");
                    }catch(Exception ex){
                        throw new RuntimeException(ex);
                    }


                }else{
                    System.out.println(Thread.currentThread().getName() +"READING FROM QUEUE" + queue.remove());
                    fullCondition.signal();

                }

                try {
                    Thread.sleep(100);
                }catch(Exception ex ){
                    throw new RuntimeException(ex);
                }
            }

            lock.unlock();

        }
    }
}