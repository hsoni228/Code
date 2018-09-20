package threading;

public class NewThread extends Thread {

    @Override
    public void run() {
        System.out.println("here" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new NewThread().start();
    }
}
