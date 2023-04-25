package Deadlock_Example;

public class Deadlock_Exercise14_5_1 implements Runnable {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Deadlock_Exercise14_5_1 deadlock = new Deadlock_Exercise14_5_1();
        new Thread(deadlock).start();
        new Thread(deadlock).start();
    }

    @Override
    public void run() {
        doTask1();
        doTask2();
    }

    private void doTask1() {
        synchronized (lock1) {
            System.out.println("Doing task 1");
        }
    }

    private void doTask2() {
        synchronized (lock2) {
            System.out.println("Doing task 2");
        }
    }

}
