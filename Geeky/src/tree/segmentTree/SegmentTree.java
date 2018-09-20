package tree.segmentTree;

public class SegmentTree {

    int segmentTreeArr[];

    public static void main(String[] args) {
        SegmentTree st = new SegmentTree();
        int arr[] = {2, 5, 1, 4, 9, 3};
        st.createTree(arr);
        System.out.println("Range Queries");

        st.findMinInRange(2, 5, arr);
        st.findMinInRange(3, 5, arr);
        st.findMinInRange(4, 5, arr);
        st.findMinInRange(0, 0, arr);
        st.findMinInRange(-100, 200, arr);
    }

    private void findMinInRange(int qs, int qe, int[] arr) {
        int min = findMin(qs, qe, 0 , arr.length - 1, 0);
        System.out.println("Minimum element in range: " + qs + " - " + qe + " is " + min);
    }

    private int findMin(int qs, int qe, int ss, int se, int index) {
        if(qe < ss || qs > se)
            return Integer.MAX_VALUE;

        if(qs <= ss && qe >= se)
            return segmentTreeArr[index];

        int mid = (ss + se) / 2;
        return Math.min(findMin(qs, qe, ss, mid, 2 * index + 1),
                findMin(qs, qe, mid + 1, se, 2 * index + 2));
    }

    private void createTree(int[] arr) {
        int n = arr.length;
        int height = (int) Math.ceil(Math.log(n)/Math.log(2));

        int maxElements = (int) Math.pow(2, height + 1) - 1;

        segmentTreeArr = new int[maxElements];

        constructTree(arr, 0, n - 1, 0);

        System.out.println("Segment Tree of size: " + segmentTreeArr.length + " is - ");
        for(int i = 0; i < segmentTreeArr.length; i++)
            System.out.print(segmentTreeArr[i] + " ");
        System.out.println();
    }

    private int constructTree(int[] arr, int start, int end, int index) {
        if(start == end) {
            segmentTreeArr[index] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;
        int minLeft = constructTree(arr, start, mid, 2*index + 1);
        int minRight = constructTree(arr, mid + 1, end, 2*index + 2);

        segmentTreeArr[index] = Math.min(minLeft, minRight);
        return segmentTreeArr[index];
    }
}
