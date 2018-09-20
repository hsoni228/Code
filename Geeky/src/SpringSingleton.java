import java.io.Serializable;

public class SpringSingleton implements Serializable, Cloneable{

    private static final SpringSingleton springSingleton = new SpringSingleton();
    private int value;

    private SpringSingleton(){

    }

    public void print(){
        System.out.println("geeks");
    }

    public static SpringSingleton getObject(){
        return springSingleton;
    }

    public static void main(String[] args) {
        SpringSingleton s = SpringSingleton.getObject();
        s.print();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected Object readResolve()
    {
        return springSingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
