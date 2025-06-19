package threads;

public class ThreadsMain {
    public static void main(String[] args) throws InterruptedException {

        // Logik-Objekte
        Runnable helloTask = new MessagePrinter("Hallo, Welt!");
        Runnable byeTask = new MessagePrinter("Tschüss!");
        // Threads steuern die Ausführung, Logik bleibt unverändert
        Thread t1 = new Thread(helloTask, "Thread-1");
        Thread t2 = new Thread(byeTask, "Thread-2");

        CounterThread myT1 = new CounterThread("my thread 1", 1000);
        myT1.start();

        CounterThread myT2 = new CounterThread("my thread 2", 1000);
        myT2.start();

        CounterThread myT3 = new CounterThread("Daemon thread", 500);
        // Low priority. Thread darf abgebrochen werden.
        myT3.setDaemon(true);
        myT3.start();

        int counter = 10;
        while (counter > 0) {
            System.out.println("Main method " + counter--);
            // Thread.yield();
        }

        Thread mainThread = Thread.currentThread();
        mainThread.join();
    }
}
