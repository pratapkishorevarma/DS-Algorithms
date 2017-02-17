package com.prv.algo;

/**
 * Suitable when duplicate keys exists
 * @author pvemulam
 *
 */
public class ThreeWayQuickSort {

	public static void sort(Comparable[] a){
		sort(a,0,a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return;
		int lt=lo, gt =hi, i=lo;
		Comparable p = a[lo];
		while(i<=gt){
			int cmp = a[i].compareTo(p);
			if(cmp<0)
				exchange(a,lt++,i++);
			else if(cmp>0)
				exchange(a,i,gt--);
			else
				i++;
		}
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable s = a[i];
		a[i] = a[j];
		a[j] = s;
		
	}
}
