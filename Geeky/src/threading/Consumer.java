package threading;

public class Consumer extends Thread {

    Semaphore semaphore;

    public Consumer(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            while (true) {
                semaphore.release();
                System.out.println("Item consumed " + semaphore.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
