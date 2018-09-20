package questions;

public class RainWater {
    public int getTotalRainWater(int a[]){
        int totalWater = 0;

        int leftArray[] = new int[a.length];
        int rightArray[] = new int[a.length];

        leftArray[0] = 0;
        rightArray[a.length - 1] = 0;

        int left = a[0];
        int right = a[a.length - 1];

        for(int i = 1; i < a.length; i++){
            leftArray[i] = left;
            rightArray[a.length - 1 - i] = right;

            left = Math.max(a[i], left);
            right =  Math.max(a[a.length - 1 - i], right);
        }

        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();

        for(int i = 0; i < a.length; i++)
            System.out.print(leftArray[i] + " ");

        System.out.println();

        for(int i = 0; i < a.length; i++)
            System.out.print(rightArray[i] + " ");

        System.out.println();

        for(int i = 0; i < a.length; i++){
            int min = Math.min(leftArray[i], rightArray[i]);
            if(min - a[i] > 0)
                totalWater += min - a[i];
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 0, 0, 4, 1, 2};
        int totalWater = new RainWater().getTotalRainWater(a);
        System.out.println("Total Water Collected - " + totalWater);
    }
}
