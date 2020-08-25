package com.gmkhan.interview.bits;

import org.junit.Test;

public class ReverseBits{

	@Test
	public void run(){
		int n = 3;
		long result = reverseBits(n);
		System.out.println(result);
	}

	private long reverseBits(long n){
		long decimal = 0;
		long base = 1;
		for(long i=31; i>=0; i--){
			long aux = 1<<i;
			if((n & aux)!=0){
				decimal = decimal+base;
			}
			base = base*2;
		}
		return decimal;
	}
}
