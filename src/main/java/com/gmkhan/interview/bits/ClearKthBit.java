package com.gmkhan.interview.bits;

import org.junit.Test;

/**
 * Clearing the bit means making a bit from 1 to 0 && from 0 to 0
 */
public class ClearKthBit{

	@Test
	public void run(){
		int n = 219;
		int k = 3;
		int result = clearKthBit(n,3);
		System.out.println(result);
	}

	private int clearKthBit(int n, int k){
		int mask = getMask(k);
		return (mask & n);
	}

	private int getMask(int k){
		int mask = 1<<k;
		return ~mask;
	}
}
