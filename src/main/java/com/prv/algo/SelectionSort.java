package com.prv.algo;

/**
 * Selection sort takes (N-1)+(N-2)+...+1+0 ~ N^2/2 compares and N exchanges
 * It takes N^2 compares even if array is sorted
 * best and worst case scenarios are equal
 * 
 * @author pvemulam
 *
 */
public class SelectionSort {

	public static void sort(Comparable[] a){
		for(int i=0; i<a.length; i++){
			int min = i;
			for(int j=i+1; j<a.length; j++){
				if(a[j].compareTo(a[min]) < 0){
					min = j;
				}
			}
			exchange(a, i, min);
		}
	}

	private static void exchange(Comparable[] a, int i, int min) {
		Comparable swap = a[i];
		a[i] = a[min];
		a[min] = swap;
	}
}
