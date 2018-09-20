package threading;

public class Semaphore {

    int count = 0;
    int bound;

    public Semaphore(int bound){
        this.bound = bound;
    }

    public synchronized void take() throws InterruptedException {
        while (count == bound)
            wait();
        count++;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (count == 0)
            wait();
        count--;
        notify();
    }

}
