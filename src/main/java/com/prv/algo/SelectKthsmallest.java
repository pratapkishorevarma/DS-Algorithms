package com.prv.algo;

public class SelectKthsmallest {

	public static Comparable select(Comparable[] a, int k){
		int N = a.length;
		Shuffle.shuffle(a);
		int lo=0, hi = N-1;
		while(true){
			int j = partition(a, lo, hi);
			if(j==k) break;
			else if (j>k)
				hi = j-1;
			else
				lo = j+1;
		}
		return a[k];
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
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable s = a[i];
		a[i] = a[j];
		a[j] = s;
	}

	private static boolean less(Comparable comparable, Comparable comparable2) {
		return comparable.compareTo(comparable2)<0;
	}
	
}
