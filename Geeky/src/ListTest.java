import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        Long lo = null;
        Map<String, Long> st = new HashMap<>();

        System.out.println(st.getOrDefault(lo, 0L).intValue());
        List<String> l = new ArrayList<>();
        l.add("himanshu");
        l.add("tapasya");
        l.add("raju");
        l.add("kartik");

        for(String s : l){
            if(s.equals("raju")){
                l.set(2, "rajkumar");
            }
            System.out.println(s);
        }
        Iterator itr = l.iterator();

        while (itr.hasNext()){
            String s = (String) itr.next();
            System.out.println(s);
            if(s.equals("raju"))
                itr.remove();
        }

        System.out.println(l);
    }

}
