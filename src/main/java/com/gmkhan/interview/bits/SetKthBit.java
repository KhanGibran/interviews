package com.gmkhan.interview.bits;

import org.junit.Test;

public class SetKthBit{

	@Test
	public void run(){
		int n = 8;
		int k = 2;
		int result = setKthBit(n,k);
		System.out.println(result);
	}

	private int setKthBit(int n, int k){
		int aux = 1<<k;
		return aux | n;
	}
}
