package com.gmkhan.interview.recursion;

import org.junit.Test;

//Subset can have repetitive elements
public class SubsetSumRepetitive {

	private int answer = 0;
	@Test
	public void run(){
		int arr [] = new int[]{1,2,3};
		int sum = 6;
		subsetSumRepetitive(arr,arr.length,0,sum);
		System.out.println(answer);
	}

	private void subsetSumRepetitive(int[] arr, int n, int currentIndex, int sum) {
		if(currentIndex==n){
			if(sum==0){
				answer++;
			}
			return;
		}
		if(sum == 0){
			answer++;
			return;
		}
		if(sum < 0){
			return;
		}
		subsetSumRepetitive(arr,n,currentIndex+1,sum);
		subsetSumRepetitive(arr,n,currentIndex,sum-arr[currentIndex]);
	}
}
