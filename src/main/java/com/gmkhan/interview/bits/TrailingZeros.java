package com.gmkhan.interview.bits;

import org.junit.Test;

public class TrailingZeros{

	@Test
	public void run(){
		int n = 18;
		int result = getTrailingZeros(n);
		System.out.println(result);
	}

	private int getTrailingZeros(int n){
		int count = 0;
		while(n > 0){
			if((n & 1)==0){
				count++;
			}
			else{
				break;
			}
			n = n>>1;
		}
		return count;
	}
}
