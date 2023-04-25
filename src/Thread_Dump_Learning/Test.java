package Thread_Dump_Learning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("Convert2MethodRef")
public class Test {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    // Two private methods that will be used to create Deadlock.
    private void doWork1(){
        synchronized (lock1){
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
            synchronized (lock2){
                System.out.println("Working on job 1");
            }
        }
    }

    private void doWork2(){
        synchronized (lock2){
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
            synchronized (lock1){
                System.out.println("Working on job 2");
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        // Used this to show how to inspect thread dump and how to use it.
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(() -> test.doWork1());
        service.execute(() -> test.doWork2());
        service.shutdown();
    }
}
