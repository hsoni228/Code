package threading;

import java.util.List;

public class Writer extends Thread{

    List<String> list;

    public Writer(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            System.out.println("Writing");
        }
    }
}
