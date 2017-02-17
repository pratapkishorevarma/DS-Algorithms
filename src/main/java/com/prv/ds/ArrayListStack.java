package com.prv.ds;

import java.util.Iterator;

/**
 * Cost of push and pop operations
 *       best    worst   amortized    
 * push   1       N         1
 * pop    1       N         1
 * 
 * Cost of inserting first N items: N + (2 + 4 + 8 + .... + N) ~ 3N
 *                                 array access to push N items + array access for resizing
 *                                 
 * 
 * Memory taken for a stack of N items
 * 
 * 24 bytes for array overhead
 * 8N for items
 * 8 bytes for array reference
 * 4 bytes for top
 * 4 padding
 * ----------------------------
 * 8N + 40 bytes 
 * 
 * @author pvemulam
 *
 * @param <Item>
 */
public class ArrayListStack<Item> implements Iterable<Item>{
	@SuppressWarnings("unchecked")
	private Item[] items = (Item[]) new Object[1];
	private int top = 0;
	
	public void push(Item item){
		if(top == items.length){
			resize(2 * items.length);
		}
		items[top++] = item;
	}
	
	private void resize(int i) {
		Item[] newItems = (Item[]) new Object[i];
		for (int j = 0; j < top; j++) {
			newItems[j] = items[j];
		}
		items = newItems;
	}

	public Item pop(){
		Item item = items[--top];
		items[top] = null;
		if(top > 0 && top == items.length/4)
			resize(items.length/2);
		return item;
	}
	
	public boolean isEmpty(){
		return top == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{

		int i = top;
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return items[--i];
		}
		
	}
	
}
