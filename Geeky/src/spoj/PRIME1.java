package spoj;

import java.util.*;

public class PRIME1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- != 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int arr[] = new int[(m - n) + 1];
            int sqrt = (int) Math.ceil(Math.sqrt(m));

            for (int i = 2; i <= sqrt; i++) {
                int k = (n % i) == 0 ? (n / i) : (n / i) + 1;

                int j = k * i;
                if (i == j && arr[j - n] != -1)
                    k++;

                while (k * i <= m) {
                    arr[k * i - n] = -1;
                    k++;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if ((i+n) != 1 && arr[i] == 0)
                    System.out.println(i + n);
            }
        }
    }
}
