package com.gmkhan.interview.bits;

import org.junit.Test;

/**
 * Leetcode problem 1486
 */
public class XOROperation{

	@Test
	public void run(){
		int n = 10;
		int start = 5;
		int result = xorOperation(n,start);
		System.out.println(result);
	}

	private int xorOperation(int n, int start){
		int result = 0;
		for(int i=0; i<n; i++){
			int temp = start+(2*i);
			result = result^temp;
		}
		return result;
	}
}
