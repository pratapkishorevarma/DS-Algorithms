package com.prv.ds;
import org.junit.Test;


public class PQTest {

	@Test
	public void test() {
		MaxPriorityQueue<String> mpq = new MaxPriorityQueue<String>();
		mpq.inert("E");
		mpq.inert("S");
		mpq.inert("F");
		mpq.inert("T");
		mpq.inert("K");
		mpq.inert("D");
		mpq.inert("G");
		mpq.inert("L");
		System.out.println(mpq);
		mpq.delMax();
		System.out.println(mpq);
		mpq.delMax();
		mpq.delMax();
		mpq.delMax();
		mpq.delMax();
		System.out.println(mpq);
	}
}
