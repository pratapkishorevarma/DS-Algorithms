package com.prv.ds;

import java.util.Arrays;

/**
 * Binary Heap: A complete binary tree which is heap ordered(parent node larger than the children)
 * 
 * insert takes 1 + lgN compares at most
 * delMax takes 2lgN compares
 * 
 * 
 * @author pvemulam
 *
 * @param <Key>
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {

	@SuppressWarnings("unchecked")
	private Key[] pq = (Key[]) new Comparable[2];
	private int last = 0;
	
	public boolean isEmpty(){
		return last == 0;
	}
	
	public void inert(Key key){
		int N = pq.length;
		if(last == N-1)
			resize(2 * N);
		
		pq[++last] = key;
		swim(last);
	}
	
	private void swim(int k) {
		while(k>1 && less(k/2,k)){
			exch(k/2,k);
			k = k/2;
		}
	}
	
	public Key delMax(){
		Key max = pq[1];
		exch(1,last--);
		sink(1);
		pq[last+1] = null;
		if(last < pq.length/4)
			resize(pq.length/2);
		return max;
	}

	private void sink(int k) {
		while(2*k <= last){
			int j = 2*k;
			if(j<last && less(j,j+1)) j++;
			if(! less(k,j)) break;
			exch(k,j);
			k=j;
		}
	}

	private void exch(int i, int k) {
		Key tmp = pq[i];
		pq[i] = pq[k];
		pq[k] = tmp;
	}

	private boolean less(int i, int k) {
		return pq[i].compareTo(pq[k])<0;
	}

	private void resize(int s) {
		Key[] newPQ = (Key[]) new Comparable[s];
		for (int i = 1; i <= last; i++) {
			newPQ[i] = pq[i];
		}
		this.pq = newPQ;
	}

	@Override
	public String toString() {
		return "MaxPriorityQueue [pq=" + Arrays.toString(pq) + "]";
	}
	
	
	
}
