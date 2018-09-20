import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class B extends A {
    public void print(StringBuilder a, AtomicBoolean b){
        StringBuilder append = a.append("hello");

        b.set(true);
//        System.out.println("B");
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("");
        StringBuilder h = s.append("h");
        System.out.println(s==h);
        AtomicBoolean b = new AtomicBoolean(false);
        new B().print(s, b);
        System.out.println(s + " " + b.get());

    }
}
