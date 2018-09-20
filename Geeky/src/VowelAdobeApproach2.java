import java.util.HashSet;
import java.util.Set;

public class VowelAdobeApproach2 {
    public static void main(String[] args) {
        String s = "azab";
        findSubstrings(s);
    }

    // Complete the findSubstrings function below.
    static void findSubstrings(String s) {

        String minHere = "";
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while(i < s.length() && !set.contains(s.charAt(i)))
                i++;

            if(i == s.length())
                break;

            j = i;

            while(j < s.length() && set.contains(s.charAt(j)))
                j++;

            if(j == s.length())
                break;

            if(i == j){
                continue;
            }

            if(minHere.equalsIgnoreCase("")){
                minHere = s.substring(i, j + 1);
            }

            while(i < j){
                if(set.contains(s.charAt(i))){
                    String t = s.substring(i, j + 1);
                    if(minHere.compareToIgnoreCase(t) > 0)
                        minHere = t;
                }

                i++;
            }

        }

        String maxHere = "";

        int index = 0;
        for(int i = s.length() - 1; i >=0; i--){
            if(!set.contains(s.charAt(i))){
                index = i;
                break;
            }
        }

        char arr[] = {'u', 'o', 'i', 'e', 'a'};

        char ch = arr[0];
        int chIndex = s.indexOf(ch, 0);

        for(int i = 1; i < arr.length; i++){
            if(chIndex != -1)
                break;
            ch = arr[i];
            chIndex = s.indexOf(ch, 0);
        }

        while (chIndex < s.length()){
            if(maxHere.equalsIgnoreCase(""))
                maxHere = s.substring(chIndex, index + 1);
            else {
                String t = s.substring(chIndex, index + 1);
                maxHere = maxHere.compareTo(t) > 0 ? maxHere : t;
            }

            int index1 = s.indexOf(ch, chIndex + 1);
            if(index1 == -1)
                break;
            else
                chIndex = index1;
        }

        System.out.println(minHere);
        System.out.println(maxHere);
    }


}
