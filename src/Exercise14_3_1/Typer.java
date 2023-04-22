package Exercise14_3_1;

@SuppressWarnings({"SynchronizeOnNonFinalField", "BusyWait"})
public class Typer extends Thread {
    static Object lock = new Object(); // Shared lock object that is used to synchronize access to the shared message.
    String message;


    public Typer(String message) {
        this.message = message;
    }

    @Override
    public void run(){
        synchronized(lock){
            for(int i = 0; i < message.length(); i++){
                System.out.print(message.charAt(i));
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Typer("Message first. ").start();
        new Typer("Message second.").start();
        // Output: Message first. Message second.
    }
}
