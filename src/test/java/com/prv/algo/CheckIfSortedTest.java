package com.prv.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckIfSortedTest {

	@Test
	public void test() {
		Integer[] sorted = {1,4,6,8,9,13,15};
		Integer[] notsorted = {2,6,1,8,4,9};
		assertTrue(CheckIfSorted.isArraySorted(sorted));
		assertFalse(CheckIfSorted.isArraySorted(notsorted));
	}

}
