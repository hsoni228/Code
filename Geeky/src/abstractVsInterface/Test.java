package abstractVsInterface;

public class Test {
    int a = 0;

    public static void main(String[] args) {
        Object a = new Object();
        int h;
        System.out.println((h = a.hashCode()) ^ (h >>> 16));
    }
}
