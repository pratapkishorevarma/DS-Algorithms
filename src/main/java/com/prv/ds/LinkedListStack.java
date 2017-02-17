package com.prv.ds;

import java.util.Iterator;

/**
 * Both the push and pop operations take constant time. Use this stack if you need guaranteed constant time 
 * for push and pop operations
 * 
 * Memory taken for each node
 * 16 bytes for object overhead
 * 8 bytes for inner class overhead
 * 8 bytes for item
 * 8 bytes for next node
 * ------------------------------
 * 40 bytes
 * ------------------------------
 * 40N bytes for N stack items
 * 
 * @author pvemulam
 *
 * @param <Item>
 */
public class LinkedListStack<Item> implements Iterable<Item>{
	
	private class Node{
		Item item;
		Node next;
	}
	private Node first = null;
	
	public void push(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public Item pop(){
		Item elem = first.item;
		first = first.next;
		return elem;
	}
	
	public boolean isEmpty(){
		return first == null;
	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{

		Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
}
