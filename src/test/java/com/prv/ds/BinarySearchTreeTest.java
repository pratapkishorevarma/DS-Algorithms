package com.prv.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testBST() {
		BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
		assertTrue(bst.isEmpty());
		bst.put("P", 1);
		bst.put("K", 10);
		bst.put("F", 6);
		bst.put("S", 3);
		bst.put("U", 8);
		bst.put("M", 2);
		bst.put("I", 5);
		assertEquals(7, bst.size());
		assertEquals(new Integer(8), bst.get("U"));
		assertEquals("F", bst.min());
		assertEquals("U", bst.max());
		assertEquals("M", bst.floor("O"));
		assertEquals("M", bst.ceiling("L"));
	}

}
