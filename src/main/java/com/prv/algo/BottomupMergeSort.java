package com.prv.algo;

/**
 * Non recursive merge sort and 10% slower than recursive merge
 * @author pvemulam
 *
 */
public class BottomupMergeSort {

	public static void sort(Comparable[] a) {
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		
		for(int sz=1; sz<N; sz = sz+sz)
			for(int lo =0; lo<N-sz;lo += sz+sz)
				merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
	}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		for(int i=0; i<=hi; i++){
			aux[i] = a[i];
		}
		
		int i=lo;
		int j=mid+1;
		for(int k=lo; k<=hi; k++){
			if(i>mid)
				a[k] = aux[j++];
			else if(j>hi)
				a[k] = aux[i++];
			else if(aux[j].compareTo(aux[i])<0) // if we do aux[i].compareTo(aux[j])<0. sort becomes unstable.
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

}
