package com.gmkhan.interview.bits;

import org.junit.Test;

public class TwoOddOccurringNumber {

	@Test public void run() {
		int[] arr = { 3, 4, 3, 4, 5, 4, 4, 6, 7, 7 };
		int n = arr.length;
		findTwoOddGFG(arr, n);
		findTwoOddScaler(arr,n);
	}

	private void findTwoOddScaler(int[] arr, int n){
		int xor = 0;
		for(int i=0; i<n; i++){
			xor = xor ^ arr[i];
		}
		int pos = 0;
		int aux = 1;
		for(int i=0; i<32; i++){
			if((xor & aux) != 0){
				break;
			}
			else{
				pos++;
			}
			aux = aux<<1;
		}
		int num = 1<<pos;

		int num1 = 0;
		int num2 = 0;

		for(int i=0; i<n; i++){
			if((num & arr[i]) != 0){
				num1 = num1 ^ arr[i];
			}
			else{
				num2 = num2 ^ arr[i];
			}
		}
		System.out.println(num1);
		System.out.println(num2);
	}

	private void findTwoOddGFG(int[] arr, int n) {
		int xor = 0;
		int res1 = 0;
		int res2 = 0;
		for (int i = 0; i < n; i++) {
			xor = xor ^ arr[i];
		}
		int sn = xor & ~(xor - 1);
		for (int i = 0; i < n; i++) {
			if ((sn & arr[i]) != 0) {
				res1 = res1 ^ arr[i];
			} else {
				res2 = res2 ^ arr[i];
			}
		}
		System.out.println(res1);
		System.out.println(res2);
	}
}
