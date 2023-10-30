package DStest01;

import java.util.Arrays;

public class Sort {
	public static void main(String [] args) {
		//Selection Sort
		int[] array = {1,12,101,21,51,23,36};
		
		//selectionSort(array);
		
		for(int i : array) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//InsertionSort
		
		//insertionSort(array);
		for(int i : array)
			System.out.print(i + " ");
		
		System.out.println();
		
		// Bubble Sort
		
		//bubbleSort(array);
		
		for(int i : array)
			System.out.print(i + " ");
		
		System.out.println();
		
		mergeSort(array);
		
		for(int i : array)
			System.out.print(i + " ");
		
		
		
		
		
		
	}
	//Selection Sort Kısmı Burada 
	
	// En büyük olan Elemanı alıp arrayin son elemanı yapıyor ve bu şekildde bir sıralama gerçekleştiriyor
	// n elemanlı bir array için bu işlem n-1 kez tekrarlanıyor
	// Toplam 3*(n-1) yer değştirme var
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
	//Insertion Sort Kısmı Burada 
	
	// Sırayla her iki indisi dolasıp küçük olanı solda bırakıyor
	// n elemanlı bir array için bu işlem n-1 kez tekrarlanıyor
	// En iyi durumda yer değiştirme sayısı 2*(n-1) / Karşılaştırma sayısı n-1 == O(n)
	// En kotü durumda yer değiştirme sayısı 2*(n-1) + n*(n-1)/2 / Karşılaştırma sayısı n*(n-1)/2 == O(n^2)
	
	public static void insertionSort(int[] theArray) {
		 	for (int unsorted = 1; unsorted < theArray.length; ++unsorted) {
		 		int nextItem = theArray[unsorted];
		 		int loc = unsorted;
		 		
		 		for (;(loc > 0) && (theArray[loc-1] > nextItem); --loc)
		 			theArray[loc] = theArray[loc-1];
		 			theArray[loc] = nextItem;
		 }
	 }
	
	//Bubble Sort Kısmı Burada
	
	// Dizi sıralı ve sırasız olarak iki kısma ayrılır || En büyük eleman bir sola doğru hareket  
	// n elemanlık bir dizi için, bubble sort diziyi sıralamak için maksimum n-1 geçişe ihtiyaç duyar || 
	// En kotü durumda iç dongü n -1 defa çalışır, yer değiştirme sayısı 3*n*(n-1)/2 / Karşılaştırma sayısı n*(n-1)/2 == O(n^2)
	// En iyi durumda zaten artan sırada dizili, yer değiştirme 0, karşılaştırma n-1 == O(n)
	
	public static void bubbleSort(int[] theArray) {
	    boolean sorted = false;
	    int n = theArray.length;

	    for (int pass = 1; pass < n && !sorted; pass++) {
	        sorted = true;

	        for (int index = 0; index < n - pass; index++) { // n-pass'a kadar olan elemanlar üzerinde işlem yapılmalı
	            int nextIndex = index + 1;

	            if (theArray[index] > theArray[nextIndex]) {
	                int temp = theArray[index];
	                theArray[index] = theArray[nextIndex];
	                theArray[nextIndex] = temp;
	                sorted = false;
	            }
	        }
	    }
	}
	
	//Merge Sort kısmı burada
	
	// Diğeri QuickSort || Bol ve Fethet || Diziyi iki parçaya bol, her bir parçayı kendi içinde diz, sıralanmış parçaları tek bir sıralı diziye birleştir. 
	// Yineleme alt dizilerin uzunluğu 1 olunca dibe vurmuş olur.
	// Yineleme bağıntısı T(N) = 2T (N/2) + O(N),, toplam O(nlgn)
	// m terim için || 
	// En kotü durumda kar
	
	public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array, mid, array.length);
            mergeSort(leftArray);
            mergeSort(rightArray);
            merge(array, leftArray, rightArray);
        }
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
	

}

