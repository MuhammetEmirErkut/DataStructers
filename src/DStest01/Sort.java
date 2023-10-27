package DStest01;

public class Sort {
	public static void main(String [] args) {
		//Selection Sort
		int[] array = {1,12,101,21,51,23,36};
		
		//selectionSort(array);
		
		for(int i : array) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		//
		insertionSort(array);
		for(int i : array)
			System.out.print(i + " ");
		
		
		
	}
	//Selection Sort Kısmı Burada 
	
	//En büyük olan Elemanı alıp arrayin son elemanı yapıyor ve bu şekildde bir sıralama gerçekleştiriyor
	// n elemanlı bir array için bu işlem n-1 kez tekrarlanıyor
	public static void selectionSort(int[] theArray) {
		for(int last = theArray.length-1; last >= 1; --last) {
			int largest = indexOfLargest(theArray, last+1);
			
			int temp = theArray[largest];
			theArray[largest] = theArray[last];
			theArray[last] = temp;
		}
	}

	private static int indexOfLargest(int[] theArray, int size) {
		int indexSoFar = 0;
		
		for(int currentIndex=1; currentIndex < size; ++currentIndex) {
			if (theArray[currentIndex] > theArray[indexSoFar])
				indexSoFar = currentIndex;
		}
		
		return indexSoFar;
	}
	//
	
	public static void insertionSort(int[] theArray) {
		 	for (int unsorted = 1; unsorted < theArray.length; ++unsorted) {
		 		int nextItem = theArray[unsorted];
		 		int loc = unsorted;
		 		
		 		for (;(loc > 0) && (theArray[loc-1] > nextItem); --loc)
		 			theArray[loc] = theArray[loc-1];
		 			theArray[loc] = nextItem;
		 }
	 }

}

