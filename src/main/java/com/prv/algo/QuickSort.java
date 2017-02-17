package com.prv.algo;

/**
 * Quick sorting N items takes 2NlgN compares and 1/3 NlgN exchanges in average case
 * 
 * in best case NlgN compares and 1/2 N^2 compares in worst case
 * 
 * Quick sort is in place algorithm
 * 
 * An algorithm is in place if it takes extra memory < c lgN
 * 
 * Quick sort is not stable.
 * Sort is stable if the equal values don't cross each other
 * 
 * @author pvemulam
 *
 */
public class QuickSort {

	public static void sort(Comparable[] a) {
		Shuffle.shuffle(a);
		sort(a,0,a.length -1);
	}

	@SuppressWarnings("unchecked")
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		// improvement
		//int m = medianof3(a, lo, lo + (hi-lo)/2, hi)
		//exchange(a, lo, m)
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i=lo, j=hi+1;
		while(true){
			while(less(a[++i],a[lo]))
				if(i==hi)
					break;
			while(less(a[lo],a[--j]))
				if(j==lo)
					break;
			if(i>=j){
				break;				
			}
			
			exchange(a,i,j);
		}
		
		exchange(a,lo,j);
		return j;	
	}

	private static boolean less(Comparable comparable, Comparable comparable2) {
		return comparable.compareTo(comparable2)<0;
	}
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable s = a[i];
		a[i] = a[j];
		a[j] = s;
		
	}

	
}
