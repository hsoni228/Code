package array;

public class BinarySearch {
	
	public static void main(String[] args) {
		int arr[] = {1,3,4,6,7,8};
		int element = 2;
		
		int index = getIndex(arr, element, 0, arr.length - 1);
		if(index != -1)
			System.out.println("Element found with index " + index);
		else
			System.out.println("Element not found");
	}

	private static int getIndex(int[] arr, int element, int start, int end) {
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		if(arr[mid] == element){
			return mid;
		}
		
		int index = getIndex(arr, element, start, mid - 1);
		if(index != -1)
			return index;
		
		return getIndex(arr, element, mid + 1, end);
	}
}
