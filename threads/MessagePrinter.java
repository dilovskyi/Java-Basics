package threads;

class MessagePrinter implements Runnable {
    private final String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        // Die Logik: Ausgabe der Nachricht
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}