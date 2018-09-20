public class Test extends Thread{

    static String a = "himanshu";
    void print() throws InterruptedException {
        synchronized (a){
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

    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        Test p = new Test();

        t.start();
//        Thread.sleep(3000);
        System.out.println("started");
        Test.a = "himani";

        p.start();
    }
}
