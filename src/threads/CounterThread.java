package threads;

public class CounterThread extends Thread {
    int counter;

    MyThread(String name, int counter) {
        super(name);
        setPriority(Thread.NORM_PRIORITY + 3);
        this.counter = counter;
    }

    public void loop() throws InterruptedException {
        while (this.counter > 0) {
            System.out.println(getName() + " " + this.counter--);
        }
    }

    public void run() {
        System.out.println(getName());
        try {
            loop();
        } catch (InterruptedException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}