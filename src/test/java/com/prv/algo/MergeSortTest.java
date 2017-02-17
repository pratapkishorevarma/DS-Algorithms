package com.prv.algo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void test() {
		Integer[] a = {5,3,9,2,8,4,6};
		Integer[] b = {2,3,4,5,6,8,9};
		MergeSort.sort(a);
		assertTrue(Arrays.equals(a, b));
	}

	@Test
	public void testBottomupMerge() {
		Integer[] a = {5,3,9,2,8,4,6,1};
		Integer[] b = {1,2,3,4,5,6,8,9};
		BottomupMergeSort.sort(a);
		assertTrue(Arrays.equals(a, b));
	}
}
