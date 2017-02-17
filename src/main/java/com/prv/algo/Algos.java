package com.prv.algo;

import java.util.Arrays;
import java.util.Random;

public class Algos {

	public static void main(String[] args){
		Integer[] unsorted = {5,3,7,9,1,34,75,23,10};
		Integer[] sorted = {1,3,5,7,9,10,23,34,75};
		System.out.println(checkIfSorted(sorted));
		System.out.println(checkIfSorted(unsorted));
		System.out.println(select(unsorted, 3));
		//selectionSort(unsorted);
		//insertionSort(unsorted);
		//mergeSort(unsorted);
		//quickSort(unsorted);
		bottomUpMergeSort(unsorted);
		System.out.println(Arrays.equals(sorted, unsorted));
		
	}
	//selection
	
	public static void selectionSort(Comparable[] a){
		int N = a.length;
		
		for(int i=0; i<N ; i++){
			int min =i;
			for(int j=i+1; j<N; j++){
				if(less(a[j],a[min]))
					min = j;
			}
			exchange(a,i,min);
		}
	}
	
	public static void insertionSort(Comparable[] a){
		int N = a.length;
		
		for(int i=0; i<N; i++){
			for(int j=i; j>0; j--){
				if(less(a[j],a[j-1]))
					exchange(a,j,j-1);
				else
					break;
			}
		}
	}
	
	public static void quickSort(Comparable[] a){
		shuffle(a);
		quickSort(a, 0, a.length-1);
	}
	
	private static void quickSort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int j = partition(a, lo, hi);
		quickSort(a, lo, j-1);
		quickSort(a, j+1, hi);
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
	
	public static Comparable select(Comparable[] a, int k){
		int N = a.length;
		shuffle(a);
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
	
	public static void bottomUpMergeSort(Comparable[] a){
		int N = a.length;
		Comparable[] aux = new Comparable[a.length];
		for(int sz =1; sz<N; sz += sz){
			for(int lo=0; lo < N - sz ; lo += sz+sz){
				merge(a, aux, lo, lo + sz -1, Math.min(lo+sz+sz-1, N-1));
			}
		}
	}

	public static void mergeSort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		mergeSort(a,aux,0,a.length-1);
	}
	
	private static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if(lo>=hi) return;
		int mid = lo + (hi - lo)/2;
		mergeSort(a,aux,lo,mid);
		mergeSort(a,aux,mid+1,hi);
		merge(a,aux,lo,mid,hi);
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo,	int mid, int hi) {
		for(int i=lo; i<=hi; i++){
			aux[i] = a[i];
		}
		
		int i=lo, j=mid+1;
		for(int k = lo; k<=hi; k++){
			if (i>mid)
				a[k] = aux[j++];
			else if (j>hi)
				a[k] = aux[i++];
		    else if(less(aux[j],aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	public static boolean checkIfSorted(Comparable[] a){
		for(int i=1; i<a.length; i++){
			if(less(a[i],a[i-1]))
				return false;
		}
		return true;
	}
	
	public static void shuffle(Comparable[] a){
		Random r = new Random();
		for(int i=0; i<a.length; i++){
			int j = r.nextInt(i+1);
			exchange(a, i, j);
		}
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
