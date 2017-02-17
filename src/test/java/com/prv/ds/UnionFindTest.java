package com.prv.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnionFindTest {

	@Test
	public void test() {
		UnionFind uf = new UnionFind(10);
		
		uf.union(3, 8);
		uf.union(8, 9);
		assertTrue(uf.connected(3, 9));
		uf.union(3, 4);
		uf.union(1, 6);
		uf.union(5, 0);
		uf.union(5, 6);
		assertTrue(uf.connected(1, 5));
		assertFalse(uf.connected(3, 6));
	}

}
