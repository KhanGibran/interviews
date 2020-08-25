package com.gmkhan.interview.bits;

import org.junit.Test;

public class HammingDistance {

	@Test
	public void run(){
		int x = 1;
		int y = 4;
		int hammingDistance = getHammingDistance(x,y);
		System.out.println(hammingDistance);
	}

	private int getHammingDistance(int x, int y){
		int xor = x^y;
		int count = 0;
		while(xor > 0){
			xor = xor & (xor-1);
			count++;
		}
		return count;
	}
}
