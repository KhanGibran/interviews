package com.gmkhan.interview.bits;

import org.junit.Test;

public class PowerOfFour{

	@Test
	public void run(){
		int n = 6;
		System.out.println(isPowerOfFour(n));
	}

	private boolean isPowerOfFour(int n){
		if(n<=0){
			return false;
		}
		boolean isTwoPower = false;

		if((n&n-1)==0){
			isTwoPower = true;
		}

		if(isTwoPower){
			int count = 0;
			while(n>1){
				n = n>>1;
				count++;
			}
			return ((count&1)==0);
		}
		else{
			return false;
		}
	}
}
