
public class prac {

	public static void mergeSort(int[] array, int n) {
		if (n < 2)
		return;
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for (int i = 0; i < mid; i++) {
		 left[i] = array[i];
		 }
		
		for (int i = mid; i < n; i++) {
		 right[i - mid] = array[i];
		 }
		
		
		 mergeSort(left, mid);
		 mergeSort(right, n - mid);
		 merge(array, left, right, mid, n - mid);
		 
		 Sorts.printArray(array);
		 }
	
	public static void merge(int[] arr, int[] left, int[] right, int l, int r) {
		int i = 0, j = 0, k = 0;
		
		while (i < l && j < r) {		
		 if (left[i] <= right[j])
			arr[k++] = left[i++];
		else
		 arr[k++] = right[j++];
		 }
		while (i < l)
		 arr[k++] = left[i++];
		
		while (j < r)
		 arr[k++] = right[j++];
		}
}
