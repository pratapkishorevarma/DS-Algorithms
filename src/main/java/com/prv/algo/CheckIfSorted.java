package com.prv.algo;

public class CheckIfSorted {

	public static boolean isArraySorted(Comparable a[]){
		for (int i=1; i<a.length; i++) {
			if(a[i].compareTo(a[i-1]) <0){
				return false;
			}
		}
		return true;
	}
}
