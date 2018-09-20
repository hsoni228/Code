public class Test1 extends Thread{

    final String b = new String("himanshu");
    void print() throws InterruptedException {
        synchronized (b){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("Done " + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        try {
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test1 p = new Test1();

        p.start();
    }
}
