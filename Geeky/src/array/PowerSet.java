package array;

import java.util.*;

public class PowerSet {

    public static void main(String[] args) {
        int arr[] = new int[15];

        for(int i = 1; i <= 15; i++ )
            arr[i-1] = i;
        printPowerSet(arr);
    }

    private static void printPowerSet(int[] arr) {
        Map<Integer, List<List<Integer>>> powerMap = new HashMap<>();

        powerMap.put(0, null);
        List<List<Integer>> arrayList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            arrayList.add(list);
        }

        powerMap.put(1, arrayList);

        for(int i = 2; i <= arr.length; i++){
            List<List<Integer>> powerSetList = powerMap.get(i - 1);
            List<List<Integer>> list = new ArrayList<>();
            for(List<Integer> s : powerSetList){
                int lastIndex = s.get(s.size() - 1);
                if(lastIndex != arr.length - 1){
                    for(int k = lastIndex + 1; k < arr.length; k++){
                        List<Integer> l = new ArrayList<>(s);
                        l.add(k);
                        list.add(l);
                    }
                }
            }

            powerMap.put(i, list);
        }

        for(Integer i : powerMap.keySet()){
            System.out.println(powerMap.get(i));
        }
    }
}
