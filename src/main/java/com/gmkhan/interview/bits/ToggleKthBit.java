package com.gmkhan.interview.bits;

import org.junit.Test;

public class ToggleKthBit{

	@Test
	public void run(){
		int n = 57;
		int k = 3;
		int result = toggleKthBit(n,k);
		System.out.println(result);
	}

	private int toggleKthBit(int n, int k){
		int aux = 1<<k;
		return (aux^n);
	}
}
