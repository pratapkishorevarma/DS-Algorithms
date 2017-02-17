package com.prv.algo;

import java.util.Random;

public class Shuffle {

	public static void shuffle(Object[] a) {
		Random gen = new Random();
		for(int i=0; i<a.length; i++){
			int r = gen.nextInt(i+1);
			exchange(a, i, r);
		}
		
	}
	
	private static void exchange(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
