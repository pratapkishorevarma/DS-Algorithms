package com.prv.algo;

/**
 * Merge sorting N items takes NlgN compares and 6NlgN array access
 * 
 * C(N) <= C(N/2) + C(N/2) + N
 *                          for merge
 * A(N) <= A(N/2) + A(N/2) + 6N
 * 
 * C(N)/N = C(N/2)/(N/2) + 1
 *        = C(N/4)/(N/4) + 1 + 1
 *        = C(N/N)/(N/N) + ... + 1
 *        = lg N
 * 
 * It takes N extra space for auxiliary array, so not in place algorithm
 * 
 * An algorithm is in place if it takes extra memory < c lgN
 * 
 * Merge sort is stable.
 * Sort is stable if the equal values don't cross each other
 * 
 * @author pvemulam
 *
 */
public class MergeSort {

	private static final int CUTOFF = 3;//7

	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a,aux,0,a.length-1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		
		/* Performance improvement*/
		if(hi-lo < CUTOFF){
			InsertionSort.sort(a);
			return;
		}
		
		if(lo >= hi)
			return;
		int mid = lo + (hi-lo)/2;
		sort(a,aux,lo,mid);
		sort(a,aux,mid+1,hi);
		// Performance improvement
		if(a[mid].compareTo(a[mid+1])<0)
			return;
		merge(a,aux,lo,mid,hi);
		
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assertSorted(a,lo,mid);
		assertSorted(a,mid+1,hi);
		
		for(int i=lo; i<=hi; i++){
			aux[i] = a[i];
		}
		
		int i=lo;
		int j=mid+1;
		for(int k=lo; k <= hi; k++){
			if (i>mid)
			   a[k] = aux[j++];
			else if (j>hi)
			   a[k] = aux[i++];
			else if(aux[j].compareTo(aux[i])<0) // if we do aux[i].compareTo(aux[j])<0. sort becomes unstable.
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
			     
		}
		assertSorted(a,lo,hi);
	}

	private static void assertSorted(Comparable[] a, int lo, int hi) {
		boolean sorted = true;
		for(int i=lo+1; i<=hi; i++){
			if(a[i].compareTo(a[i-1]) <0){
				sorted = false;
				break;
			}
		}
		assert sorted;
	}
}
