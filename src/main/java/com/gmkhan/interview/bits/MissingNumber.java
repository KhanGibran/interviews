package com.gmkhan.interview.bits;

import org.junit.Test;

public class MissingNumber {

	@Test public void run() {
		int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int result = findMissing(arr, arr.length);
		System.out.println(result);
	}

	private int findMissing(int[] arr, int n) {
		int xor = 0;
		for (int i = 0; i < n; i++) {
			xor = xor ^ arr[i];
		}
		for (int i = 0; i <= n; i++) {
			xor = xor ^ i;
		}
		return xor;
	}
}
