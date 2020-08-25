package com.gmkhan.interview.bits;

import org.junit.Test;

public class TotalHammingDistance{

	@Test
	public void run(){
		int[] arr = {4, 14, 2};
		int n = arr.length;
		int result = getTotalHammingDistance(arr,n);
		System.out.println(result);
	}

	private int getTotalHammingDistance(int[] arr, int n){
		int hammingDistance = 0;
		int aux = 1;
		for(int i=0; i<32; i++){
			int countZero = 0;
			int countOne = 0;
			for(int j=0; j<n; j++){
				if((aux & arr[j])==0){
					countZero++;
				}
				else{
					countOne++;
				}
			}
			aux = aux<<1;
			hammingDistance = hammingDistance + (2*countOne*countZero);
		}
		return hammingDistance;
	}
}
