package com.prv.algo;

import java.util.Arrays;

import org.junit.Test;

public class ShuffleTest {

	@Test
	public void test() {
		Integer[] a = {1,2,3,4,5,6,7,8,9,10};
		Shuffle.shuffle(a);
		System.out.println(Arrays.toString(a));
	}

}
