package com.gmkhan.interview.bits;

import org.junit.Test;

public class PowerOfTwo{

	@Test
	public void run(){
		int n = 6;
		System.out.println(isPowerOfTwo(n));
	}

	private boolean isPowerOfTwo(int n){
		if(n==0){
			return false;
		}
		else{
			return (((n&(n-1))==0));
		}
	}
}
