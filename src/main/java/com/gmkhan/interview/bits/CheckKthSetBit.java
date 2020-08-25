package com.gmkhan.interview.bits;

import org.junit.Test;

public class CheckKthSetBit {

	@Test
	public void run(){
		int  n = 8;
		int k = 3;
		boolean isSet = isBitSet(n,k);
		System.out.println(isSet);
		System.out.println(isKthBitSet(n,k));
	}

	/**
	 * Using Left Shift Operator
 	 * @param n
	 * @param k
	 * @return
	 */
	private boolean isBitSet(int n, int k){
		int aux = 1<<k;
		int result = n & aux;
		if(result==0){
			return false;
		}
		return true;
	}

	/**
	 * Using Right Shift Operator
	 * @param n
	 * @param k
	 * @return
	 */
	private boolean isKthBitSet(int n,int k){
		n = n>>k;
		return (n & 1) == 1;
	}
}
