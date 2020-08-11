package com.gmkhan.interview.searching;

import org.junit.Test;

public class MajorityElementUnsortedArray {

	@Test
	public void run(){
		int []arr = new int[]{8,8,6,6,6,4,6};
		int getMajorityElement = findByMooreVoting(arr,arr.length);
		System.out.println(getMajorityElement);
	}

	private int findByMooreVoting(int[] arr, int n){
		int candidate = 0;
		int count = 1;
		for(int i=1;i<n;i++){
			if(arr[i]==arr[candidate]){
				count++;
			}
			else{
				count--;
			}
			if(count == 0){
				candidate = i;
				count = 1;
			}
		}

		int countF = 0;
		for (int j : arr) {
			if (j == arr[candidate]) {
				countF++;
			}
		}
		if(countF > n/2){
			return arr[candidate];
		}
		else{
			return -1;
		}
	}
}
