package array;

public class NoAndReverse {
    public static void main(String[] args) {
        int n = 444;

        for(int i = 1; i < n; i++){
            int a = n - i;
            int b = reverse(a);

            if(b == i)
                System.out.println(a + " " + i);
        }
    }

    private static int reverse(int a) {
        int t = 0;
        while (a != 0){
            t = t * 10;
            t = t + (a%10);
            a = a / 10;
        }

        return t;
    }
}
