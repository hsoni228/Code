package threading;

public class Producer extends Thread {

    Semaphore semaphore;

    public Producer(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Item produced " + semaphore.count);
                semaphore.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
