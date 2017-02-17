package com.prv.ds;

/*
 * Class to find out the connectivity between points
 * These points could be mapped to objects for dynamic connectivity problems
 * 
 * Order of array access
 * operation      time
 * --------------------
 * initialization N
 * Union          lg N
 * Find           lg N
 * 
 * Depth of any node is at most lgN. Proof: A tree at least doubles its size when merged. A tree can double at most lg N times.
 * 
 * M union find operations on a set of N objects. worst-case N + M lg* N
 */

public class UnionFind {

	private int[] id;
	private int[] size;
	
	public UnionFind(int n){
		id = new int[n];
		size = new int[n];
		for(int i=0; i<id.length ; i++){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public void union(int a, int b){
		int i = root(a);
		int j = root(b);
		
		if(i == j) return;
		// weighted union
		if(size[i] < size[j]){
			id[i] = j;
			size[j] += size[i];
		}else{
			id[j] = i;
			size[i] += size[j];
		}
	}
	
	public boolean connected(int a, int b){
		return root(a) == root(b);
	}

	private int root(int p) {
		while(p != id[p]){
			// path compression
			id[p] = id[id[p]];
			p = id[p];
		}
		return id[p];
	}
}
