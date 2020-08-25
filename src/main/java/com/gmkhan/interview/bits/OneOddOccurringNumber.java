package com.gmkhan.interview.bits;

import org.junit.Test;

public class OneOddOccurringNumber {

	@Test
	public void run(){
		int[] arr = {8,7,7,8,8};
		int n = arr.length;
		int result = findOneOdd(arr,n);
		System.out.println(result);
	}

	private int findOneOdd(int[] arr, int n){
		int xor = 0;
		for(int i=0; i<n; i++){
			xor=xor^arr[i];
		}
		return xor;
	}
}
