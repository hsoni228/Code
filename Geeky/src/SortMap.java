import java.util.*;

public class SortMap extends ListTest{
    final public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(41,5);
        map.put(17,9);
        map.put(32,0);

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(entrySet);
        Set<Integer> s = new TreeSet<>();
        for(Integer i : map.keySet()){
            System.out.println(i);
        }

    }
}
