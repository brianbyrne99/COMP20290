
public class Sorts {

	public static void main(String[] args) {
		
		//following arrays are implemented to make sure arrays are the same for fair analysis
		int[] array = {3,4,1,5,2};
		int[] array1 = {3,4,1,5,2};
		int[] array2 = {3,4,1,5,2};
		int[] array3 = {30,40,10,50,20};
	    int[] array4 = {30,40,10,50,20};
	    int[] array5 = {30,40,10,50,20};
	    int[] array6 = {300,400,100,500,200};
        int[] array7 = {300,400,100,500,200};
        int[] array8 = {300,400,100,500,200};
        int[] array9 = {300000,400000,100000,500000,200000};
        int[] array10 = {300000,400000,100000,500000,200000};
        int[] array11 = {300000,400000,100000,500000,200000};
        int[] array12 = {3,4,1,5,2};
        int[] array13 = {30,40,10,50,20};
	    int[] array14 = {300,400,100,500,200};
        int[] array15 = {300000,400000,100000,500000,200000};
        int[] array16 = {3,4,1,5,2};
        int[] array17 = {30,40,10,50,20};
	    int[] array18 = {300,400,100,500,200};
        int[] array19 = {300000,400000,100000,500000,200000};
        int[] array20 = {3,4,1,5,2};
        int[] array21 = {30,40,10,50,20};
	    int[] array22 = {300,400,100,500,200};
        int[] array23 = {300000,400000,100000,500000,200000};
        
        
        System.out.println("");
		SelectionSort(array);
		InsertionSort(array1);
		SillySort(array2);
	
		System.out.println("\nSorting integers x10");
		SelectionSort(array3);
		InsertionSort(array4);
		SillySort(array5);
		
		System.out.println("\nSorting integers x100");
		SelectionSort(array6);
		InsertionSort(array7);
		SillySort(array8);
		
		System.out.println("\nSorting integers x100000");
		SelectionSort(array9);
		InsertionSort(array10);
		SillySort(array11);
		
		System.out.println("\nMerge Sort Analysis");
		long start = System.nanoTime();
		mergeSort(array12, array12.length);	
		System.out.println("Time taken to complete Merge Sort: "+(System.nanoTime()-start)+" Nanoseconds");	
		start = System.nanoTime();
		mergeSort(array13, array13.length);	
		System.out.println("Time taken to complete Merge Sort: "+(System.nanoTime()-start)+" Nanoseconds");	
		start = System.nanoTime();
		mergeSort(array14, array14.length);	
		System.out.println("Time taken to complete Merge Sort: "+(System.nanoTime()-start)+" Nanoseconds");	
		start = System.nanoTime();
		mergeSort(array15, array15.length);	
		System.out.println("Time taken to complete Merge Sort: "+(System.nanoTime()-start)+" Nanoseconds");
		
		
		System.out.println("\nEnhanced Merge Sort Analysis");
		start = System.nanoTime();
		mergeSort(array20, array20.length);	
		System.out.println("Time taken to complete Enhanced Merge Sort: "+(System.nanoTime()-start)+" Nanoseconds");		
		start = System.nanoTime();
		mergeSort(array21, array21.length);	
		System.out.println("Time taken to complete Enhanced Merge Sort: "+(System.nanoTime()-start)+" Nanoseconds");		
		start = System.nanoTime();
		mergeSort(array22, array22.length);	
		System.out.println("Time taken to complete Enhanced Merge Sort: "+(System.nanoTime()-start)+" Nanoseconds");		
		start = System.nanoTime();
		mergeSort(array23, array23.length);	
		System.out.println("Time taken to complete Enhanced Merge Sort: "+(System.nanoTime()-start)+" Nanoseconds");
		
		
		System.out.println("\nQuick Sort Analysis");
		start = System.nanoTime();
		quickSort(array16,0,array16.length-1);
		System.out.println("Time taken to complete Quick Sort: "+(System.nanoTime()-start)+" Nanoseconds");
		
		start = System.nanoTime();
		quickSort(array17,0,array17.length-1);
		System.out.println("Time taken to complete Quick Sort: "+(System.nanoTime()-start)+" Nanoseconds");
		
		start = System.nanoTime();
		quickSort(array18,0,array18.length-1);
		System.out.println("Time taken to complete Quick Sort: "+(System.nanoTime()-start)+" Nanoseconds");
		
		start = System.nanoTime();
		quickSort(array19,0,array19.length-1);
		System.out.println("Time taken to complete Quick Sort: "+(System.nanoTime()-start)+" Nanoseconds");
        
		
	}
	
	//Function to print out elements of the array
	public static void printArray(int[]arr)
	{
		System.out.print("Sorted Array: ");
		for (int element: arr) {
            System.out.print(element+" ");
        }
		System.out.print("\n");
	}
	
	public static void SelectionSort(int[] arr)
	{
		long start = System.nanoTime();
		int mindex,temp;
		for(int i=0;i<arr.length-1;i++)
		{
			mindex=i;
			for(int j=i+1;j<arr.length;j++) {     //finds the minimum element and swaps it with the first element
				if(arr[mindex] > arr[j])
				{
					mindex=j;
				}

				    temp = arr[mindex];
		            arr[mindex] = arr[i];
		            arr[i] = temp;
			}
		}
		System.out.println("Time taken to complete Selection Sort: "+(System.nanoTime()-start)+" Nanoseconds");
		printArray(arr);
	}
	
	public static void InsertionSort(int[] arr)
	{
		long start = System.nanoTime();
		int temp,j;
		for(int i=1;i<arr.length;i++) {
			temp = arr[i];
			j=i-1;                              //moves elements greater than temp 1 index forward
			
			while(j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j=j-1;
				arr[j+1] = temp;
			}
		}
		System.out.println("Time taken to complete Insertion Sort: "+(System.nanoTime()-start)+" Nanoseconds");
		printArray(arr);
	}
	
	//My own Stalin Sort Algorithm
	public static void SillySort(int[] arr)
	{
		long start = System.nanoTime();      //Just a rubbish sort algorithm that sets all out of order to 
		int[] temp= new int[arr.length];     //null!
		int x = 1;
		temp[0]= arr[0];
		for(int i=0;i<arr.length;i++) {
			if(temp[x-1] < arr[i])
			{
				temp[x]=arr[i];
				x++;
			}
		}
		System.out.println("Time taken to complete Stalin Sort: "+(System.nanoTime()-start)+" Nanoseconds");
		printArray(temp);
	}
	
	//MergeSort
	public static void mergeSort(int[] array, int n) {
		if (n < 2)
		return;
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for (int i = 0; i < mid; i++) {
		 left[i] = array[i];
		 }
		
		for (int i = mid; i < n; i++) {       //splits the list in two so the smaller lists and sorts them 
		 right[i - mid] = array[i];
		 }
		
		
		 mergeSort(left, mid);                           //recursive call that sorts each new sub-array
		 mergeSort(right, n - mid);
		 merge(array, left, right, mid, n - mid);       //merges the sub-arrays together into a final sorted array
		 
		 printArray(array);
		 }
	
	public static void merge(int[] arr, int[] left, int[] right, int l, int r) {
		int i = 0, j = 0, k = 0;
		
		while (i < l && j < r) {		
		 if (left[i] <= right[j])
			arr[k++] = left[i++];                    //merges the two sorted lists
		else                                         //into a combined sorted list
		 arr[k++] = right[j++];
		 }
		while (i < l)
		 arr[k++] = left[i++];
		
		while (j < r)
		 arr[k++] = right[j++];
		}
	
	public static void enhancedMergeSort(int[] arr, int hi) {
		int cutOff=10;
		if (hi < 2)
			return;
		if (hi <= cutOff) {
			InsertionSort(arr);   //uses insertion sort for smaller data sets
			return;
		}
		
		int mid = hi / 2;                   //we use our insertion sort to handle small sub-arrays
		int[] l = new int[mid];              //this reduces running time
		int[] r = new int[hi - mid];
		System.arraycopy(arr, 0, l, 0, mid);
		
		
		if (hi - mid >= 0) System.arraycopy(arr, mid, r, 0, hi - mid);
		mergeSort(l, mid);
		mergeSort(r, hi-(mid+1));
		if ((arr[mid+1] >= arr[mid])) 
			return;       //Stops merging when array is fully sorted
		
		merge(arr, l, r, mid, hi - mid);
		
		printArray(arr);
	}
	
	
	public static void quickSort(int[] arr, int first, int last) {
		if(first<last) {
			int index=partition(arr,first,last);          
			
			//constantly sorting the array recursively before and after 
			quickSort(arr,first,index-1);
			quickSort(arr,index+1,last);
		}
		printArray(arr);
	}
	
	public static int partition(int arr[], int first, int last) {
		int pivot=arr[last];                 //the last element is the pivot
		int temp;
		int index =first-1;
		
		for(int j=first;j<last;j++) {
			if(arr[j]<=pivot) {            //if the current element is larger than the pivot they swap places
				index++;
				temp=arr[index];
				arr[index]=arr[j];
				arr[j]=temp;				
			}	
		}
		temp=arr[index+1];
		arr[index+1]=arr[last];
		arr[last]=temp;             //update the pivot
		
		
		return index+1;
	}
	

	
}
