package com.prv.algo;

/**
 * Heap Sort takes <2N compares and exchanges for heap construction
 *          and < 2NlgN compares and exchanges for sort
 * 
 * Worst case and average case time is 2NlgN and NlgN best case time
 * 
 * Heap sort works good for worst case scenario
 * but:
 *    inner loog longer than quicksort's
 *    makes poor use of cache memory as it can access array elements which are far
 *    not stable
 *    
 * 
 * 
 * @author pvemulam
 *
 */
public class HeapSort {

	public static void sort(Comparable[] a){
		int N = a.length -1;
		for (int k = N/2; k >= 1; k--) {
			sink(a,k,N);
		}
		
		while(N>1){
			exch(a,1,N--);
			sink(a,1,N);
		}
	}

	private static void sink(Comparable[] a, int k, int n) {
		
		while(2*k <= n){
			int j = 2*k;
			if(j<n && less(a,j,j+1)) j++;
			if(! less(a,k,j)) break;
			exch(a,k,j);
			k=j;
		}
	}

	private static void exch(Comparable[] a, int k, int j) {
		Comparable tmp = a[k];
		a[k] = a[j];
		a[j] = tmp;	
	}

	private static boolean less(Comparable[]a, int j, int i) {
		return a[j].compareTo(a[i])<0;
	}
}
