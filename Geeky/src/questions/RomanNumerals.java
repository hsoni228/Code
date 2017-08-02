package questions;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by YATRAONLINE\himanshu.soni on 3/8/17.
 */
public class RomanNumerals {
    int number;
    StringBuffer roman;
    Map<Integer, String> romanMap = createMap();

    private Map<Integer,String> createMap() {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1,"I");
        romanMap.put(5,"V");
        romanMap.put(10,"X");
        romanMap.put(50,"L");
        romanMap.put(100,"C");
        romanMap.put(500,"D");
        romanMap.put(1000,"M");
        return romanMap;
    }

    private RomanNumerals(int number){
        this.number = number;
        this.roman = new StringBuffer();
    }

    public static void main(String[] args) {
        int number = 2349;
        RomanNumerals roman = new RomanNumerals(number);
        roman.convertNumberToRoman();
        roman.printRomanNumber();
    }

    private void printRomanNumber() {
        System.out.println(roman);
    }

    private void convertNumberToRoman() {
        int place = 1, digit, num = number;
        while(num != 0) {
            digit = num % 10;
            String romanValue = getRomanValue(digit, place);
            roman.insert(0, romanValue);
            place *= 10;
            num /= 10;
        }
    }

    private String getRomanValue(int digit, int place) {
        String value = "";
        if(digit == 4){
            value = romanMap.get(place) + romanMap.get(5 * place);
            return value;
        }else if(digit == 9){
            value = romanMap.get(place) + romanMap.get(10 * place);
            return value;
        }else{
            if(romanMap.containsKey(digit * place))
                return romanMap.get(digit * place);

            if(digit > 5){
                value = romanMap.get(5 * place);
                digit -= 5;
            }

            while(digit != 0){
                value += romanMap.get(place);
                digit--;
            }
            return value;
        }
    }
}
