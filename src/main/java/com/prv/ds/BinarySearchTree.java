package com.prv.ds;

import java.util.Iterator;

/**
 * Binary Search Tree: A binary tree in symmetric order
 * (all keys in left tree are smaller and all keys in right tree are larger)
 * 
 * Compares for get 1+depth of node
 * 
 * 
 * @author pvemulam
 *
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private class Node{
		Key key;
		Value value;
		Node left, right;
		int size;

		public Node(Key key, Value value, int s) {
			this.key = key;
			this.value = value;
			this.size = s;
		}
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public Value get(Key key){
		Node x = root;
		while(x != null){
			int cmp = key.compareTo(x.key);
			if(cmp < 0)
				x = x.left;
			else if(cmp > 0)
				x = x.right;
			else
				return x.value;
		}
		return null;
	}
	
	public void put(Key key, Value value){
		root = put(root,key,value);
	}
	
	private Node put(Node x, Key key, Value value) {
		if(x == null) return new Node(key,value,1);
		int cmp = key.compareTo(x.key);
		
		if(cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.value = value;
		
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}

	private int size(Node y) {
	    if(y == null) 
	    	return 0;
	    else
	    	return  1 + size(y.left) + size(y.right);
	}

	public int size(){
		return size(root);
	}

	public Key min() {
		Node x = root;
		while(x != null){
			if(x.left == null) 
				return x.key;
			else
				x=x.left;
		}
		return null;
	}

	public Key max() {
		Node x = root;
		while(x != null){
			if(x.right == null) 
				return x.key;
			else
				x=x.right;
		}
		return null;
	}
	
	public Key floor(Key key){
		Node x = floor(root, key);
		if(x != null)
			return x.key;
		else
			return null;
	}

	private Node floor(Node x, Key key) {
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		
		if(cmp < 0)
			return floor(x.left, key);
		else if(cmp > 0){
			Node t = floor(x.right, key);
			if(t != null)
				return t;
			else 
				return x;
		}
		else
			return x;
	}
	
	public Key ceiling(Key key){
		Node x = ceiling(root,key);
		if(x != null)
			return x.key;
		else
			return null;
	}

	private Node ceiling(Node x, Key key) {
		if(x == null)
			return null;
		
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp > 0) return ceiling(x.right, key);
		
		Node t = ceiling(x.left, key);
		if(t != null)
			return t;
		else
			return x;
	}
	
	public int rank(Key key){
		return rank(root, key);
	}

	private int rank(Node x, Key key) {
		if(x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if(cmp == 0)
			return size(x.left);
		else if(cmp < 0)
			return rank(x.left, key);
		else
			return 1 + size(x.left) + rank(x.right, key);
	}
}
