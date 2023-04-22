package Strange_Bank_Problem;

/* Created a system where:
 * A Bank class, which has an integer variable money.
 * And Client class, a subclass of Thread class,
 * in which infinite loop takes $1000 loan from bank (decrease money) and immediately returns (increase money).
 */

@SuppressWarnings({"BusyWait", "InfiniteLoopStatement", "SynchronizeOnNonFinalField", "SameParameterValue", "FieldMayBeFinal", "unused"})
public class Bank {

    private int money = 10000;
    private Object lock = new Object();

    int getMoney() {
        return money;
    }

    void take(int money) {
        synchronized (lock) {
            this.money -= money;
        }
    }

    void repay(int money) {
        synchronized (lock) {
            this.money += money;
        }
    }

    class Client extends Thread{
        @Override
        public void run() {
            while(true) {
                take(1000);
                repay(1000);
            }
        }
    }

    public Bank() {
        new Client().start();
        new Client().start();
        new Client().start();
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while(true) {
            System.out.println(bank.money);
            Thread.sleep(1000);
        }
    }

}
