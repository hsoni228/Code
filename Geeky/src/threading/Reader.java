package threading;

import java.util.List;

public class Reader extends Thread{
    List<String> list;

    public Reader(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {

    }
}
