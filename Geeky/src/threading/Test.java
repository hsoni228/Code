package threading;

import java.util.*;

public class Test implements TestInterface {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "himanshu");
        hashMap.put(4, "kartik");
        hashMap.put(3, "atul");
        hashMap.put(2, "ankush");

        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }

        System.out.println(hashMap);
        Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
        List<Map.Entry<Integer, String>> list = new ArrayList<>(entrySet);

        Comparator<Map.Entry<Integer, String>> comparator = new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return 0;
            }
        };

        Collections.sort(list, (e1, e2) -> {
            return e1.getKey().compareTo(e2.getKey());
        });

        System.out.println(list);
    }
}
