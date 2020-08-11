package com.gmkhan.interview.recursion;

import org.junit.Test;

/**
 * Given an array and a sum S.
 * We need to find out the count of subset of a array whose sum is equal to given sum S.
 */
public class SubsetSumProblem {

	private int answer = 0;

	@Test
	public void test(){
		int arr[] = new int[]{1,2,3,5};
		int sum = 3;
		int result = sumOfSubset(arr,sum,arr.length);
		System.out.println(result);
		subsetSumScaler(arr,arr.length,0,sum);
		System.out.println(answer);
	}

	private int sumOfSubset(int[] arr, int sum,int n){
		if(n==0){
			return sum==0?1:0;
		}
		return sumOfSubset(arr,sum,n-1)+sumOfSubset(arr,sum-arr[n-1],n-1);
	}


	private void subsetSumScaler(int arr[],int n, int currentIndex, int sum ){
		if(currentIndex == n){
			if(sum == 0){
				answer++;
			}
			return;
		}
		subsetSumScaler(arr,n,currentIndex+1,sum-arr[currentIndex]);
		subsetSumScaler(arr,n,currentIndex+1,sum);
	}
	//TODO Josephus Problem
}
