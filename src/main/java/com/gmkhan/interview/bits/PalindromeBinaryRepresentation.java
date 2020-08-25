package com.gmkhan.interview.bits;

import org.junit.Test;

public class PalindromeBinaryRepresentation{

	@Test
	public void run(){
		int n = 10000;
		int res = solve(n);
		System.out.println(res);
	}

	private int solve(int A){
		int n=1;
		if(A == 1){
			return n;
		}
		else{
			while (A != 0) {
				if (isBinaryPalindrome(n)) {
					A--;
				}
				n+=2;
			}
		}
		return n-2;
	}

	private boolean isBinaryPalindrome(int n){
		int rightBit = 0;
		int leftBit = (int)(Math.log(n)/Math.log(2));

		while(leftBit > rightBit){
			if(isKthBitSet(leftBit,n) != isKthBitSet(rightBit,n)){
				return false;
			}
			leftBit--;
			rightBit++;
		}
		return true;
	}

	private boolean isKthBitSet(int k, int n){
		int aux = 1<<k;
		return (n & aux) != 0;
	}
}
