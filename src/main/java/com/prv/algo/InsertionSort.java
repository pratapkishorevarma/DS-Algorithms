package com.prv.algo;

/**
 * Insertion sort on a randomly ordered array does N^2/4 exchanges and N^2/4 compares on average.
 * 
 * best case: 0 exchanges and N-1 compares
 * worst case: N^2/2 exchanges and N^2/2 compares
 * 
 * Insertion sort is useful for sorting partially sorted array.
 * In partially sorted array inversions(no of key pairs misplaced) < cN. 
 * for partially sorted array no. of compares = exchanges(=Inversions) + N-1
 * 
 * Insertion sort is stable.
 * @author pvemulam
 *
 */
public class InsertionSort {

	public static void sort(Comparable[] a) {
		for(int i=0; i<a.length; i++){
			for(int j=i; j>0; j--){
				if(a[j].compareTo(a[j-1])<0){
					exchange(a, j, j-1);
				}else{
					break;
				}
			}
		}
		
	}
	
	private static void exchange(Comparable[] a, int i, int min) {
		Comparable swap = a[i];
		a[i] = a[min];
		a[min] = swap;
	}

}
