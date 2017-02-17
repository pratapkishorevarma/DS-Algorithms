package com.prv.ds;

import java.util.Scanner;

/**
 * Applications of stack
 *   Execute subroutines
 *   undo in word processor
 *   back button in browser
 * This class demonstrates how operations are performed using 2 stack algorithm
 *    
 * Another example is reverse sequence of strings from input
 * @author pvemulam
 *
 */
public class TwoStackAlgoForOperations {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

        ArrayListStack<String> ops = new ArrayListStack<String>();
        LinkedListStack<Double> vals = new LinkedListStack<Double>();
		System.out.println("Enter expression to evaluate: ");
		if(s.hasNext()){
			String expression = s.next();
			 String[] split = expression.split("");
			for (String c : split) {
			    if(c.equals("(")){
			    	
			    }else if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
					ops.push(c);
				}else if(c.equals(")")){
					String op = ops.pop();
					if(op.equals("+")){ vals.push(vals.pop() + vals.pop());}
					if(op.equals("-")){ vals.push(vals.pop() - vals.pop());}
					if(op.equals("*")){ vals.push(vals.pop() * vals.pop());}
					if(op.equals("/")){ vals.push(vals.pop() / vals.pop());}
				}else{
					vals.push(Double.valueOf(new String(c)));
				}
			}
			System.out.println("Expression value: " + vals.pop());
		}
		s.close();
		}
	}
