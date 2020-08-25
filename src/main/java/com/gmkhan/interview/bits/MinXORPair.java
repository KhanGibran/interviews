package com.gmkhan.interview.bits;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of numbers. Find the pair in array whose XOR is minimum
 */
public class MinXORPair{

	@Test
	public void run(){
		int[] arr = {0,2,5,7};
		int n = arr.length;
		printPair(arr,n);
	}

	private void printPair(int[] arr, int n){
		Arrays.sort(arr);
		int firstNumber = 0;
		int secondNumber = 0;
		int minXOR = Integer.MAX_VALUE;

		for(int i=0; i<n-1; i++){
			int xor = arr[i]^arr[i+1];
			if(xor < minXOR){
				minXOR = xor;
				firstNumber = arr[i];
				secondNumber = arr[i+1];
			}
		}
		System.out.println("Pair with minimum XOR "+minXOR+" is "+firstNumber+" and "+secondNumber);
	}
}
