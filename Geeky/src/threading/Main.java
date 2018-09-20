package threading;

import java.lang.ref.WeakReference;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(5);

        Producer producer = new Producer(s);
        Consumer consumer = new Consumer(s);

        consumer.start();
        producer.start();

//        Thread t = new Thread(() -> {
//            try {
//                Thread.sleep(20000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("here");
//        });
//
////        t.start();
////        Thread.currentThread().interrupt();
//        System.out.println("hmm");
//        String st = new String("shshs");
//        st = null;
//        System.gc();
//
//        WeakReference<String> w = new WeakReference<>(new String());
//        Comparator<Integer> c = (a, b) -> {
//          return a.compareTo(b);
//        };
//        Comparator<Integer> c = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("done");
    }
}
