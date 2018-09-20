package questions.AshishSwiggy;

public class MergeString {

    public static void main(String[] args) {
        String first = "abc";
        String second = "stuvwx";

        System.out.println(mergeString(first, second));
    }

    private static String mergeString(String first, String second) {

        StringBuilder output = new StringBuilder();

        if(first.equals(""))
            return second;

        if(second.equals(""))
            return first;

        if(first.length() >= second.length()){
            for(int i = 0; i < second.length(); i++){
                output.append(first.charAt(i));
                output.append(second.charAt(i));
            }

            output.append(first.substring(second.length()));
            return output.toString();
        }

        if(first.length() < second.length()){
            for(int i = 0; i < first.length(); i++){
                output.append(first.charAt(i));
                output.append(second.charAt(i));
            }

            output.append(second.substring(first.length()));
            return output.toString();
        }
        return "";
    }
}
