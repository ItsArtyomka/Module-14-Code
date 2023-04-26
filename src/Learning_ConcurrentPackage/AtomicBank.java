package Learning_ConcurrentPackage;

import java.util.concurrent.atomic.AtomicInteger;

// Code for Exercise 14.6.1
// Better version of the original bank code that utilises Atomic Integer class.
public class AtomicBank {

    AtomicInteger money = new AtomicInteger(10000);

    int getMoney() {
        return money.get();
    }

    void take(int money) {
       this.money.addAndGet(-money);
    }

    void repay(int money) {
        this.money.addAndGet(money);
    }

    class AtomicClient extends Thread{
        @Override
        public void run() {
            while(true) {
                if (getMoney() >= 1000) {
                    take(1000);
                    repay(1000);
                }
            }
        }
    }

    public AtomicBank() {
        new AtomicBank.AtomicClient().start();
        new AtomicBank.AtomicClient().start();
        new AtomicBank.AtomicClient().start();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicBank bank = new AtomicBank();
        while(true) {
            System.out.println(bank.money);
            Thread.sleep(1000);
        }
    }

}
