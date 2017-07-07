package sorting;

public class QuickSort {
	
	public static void main(String[] args) {
		int array[] = {7,2,9,8,5,3};
		int start = 0, end = array.length - 1;
		print(array);
		quickSort(start, end, end, array);
		print(array);
	}

	private static void print(int[] array) {
		System.out.println("Printing array - ");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static void quickSort(int start, int pivot, int end, int[] array) {
		
		if(start >= end)
			return;
		
		int i = start - 1;
		
		for(int j = start; j <= end - 1; j++)
			if(array[j] < array[pivot]){
				i++;
				swap(array, i, j);
			}
		swap(array, i+1, end);
		pivot = i + 1;
		quickSort(start, i, pivot - 1, array);
		quickSort(pivot + 1, end, end, array);
	}

	private static void swap(int[] array, int i, int j) {
		if(i == j)
			return;
		array[i] = array[i] ^ array[j];
		array[j] = array[j] ^ array[i];
		array[i] = array[j] ^ array[i];
	}
}
