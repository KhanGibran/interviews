package com.gmkhan.interview.searching;

import org.junit.Test;

public class NumberOf1BinarySortedArray{

	@Test
	public void run(){
		int arr[] = new int[]{0,0,0,1,1,1,1,1,1,1};
		int result = findOccurrence(arr,0,arr.length-1);
		System.out.println(arr.length-result);
	}

	private int findOccurrence(int[] arr, int low,int high){
		while(low <= high){
			int middle = low + (high-low)/2;
			if(arr[middle]==0){
				low = middle+1;
			}
			else{
				if(middle == 0 || arr[middle-1]==0){
					return middle;
				}
				else{
					high = middle-1;
				}
			}
		}
		return 0;
	}
}
