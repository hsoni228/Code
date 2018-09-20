package threading;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName() + "Thread started");
    }
}
