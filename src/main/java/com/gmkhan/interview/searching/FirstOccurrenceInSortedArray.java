package com.gmkhan.interview.searching;

import org.junit.Test;

public class FirstOccurrenceInSortedArray {

	@Test
	public void test(){
		int[] arr = new int[]{1,10,10,10,20,20,40};
		int x = 40;
		int result = findFirstOccurrenceRecursively(arr,0,arr.length-1,x);
		System.out.println(findFirstOccurrenceIteratively(arr,0,arr.length-1,x));
		System.out.println(result);
	}

	private int findFirstOccurrenceIteratively(int[] arr,int low,int high,int x){
		while(low <= high){
			int middle = low + (high-low)/2;
			if(x > arr[middle]){
				low = middle+1;
			}
			else if(x < arr[middle]){
				high = middle-1;
			}
			else{
				if(middle == 0 || arr[middle] != arr[middle-1]){
					return middle;
				}
				else{
					high = middle-1;
				}
			}
		}
		return -1;
	}

	private int findFirstOccurrenceRecursively(int[] arr, int low, int high, int x){
		if(low<=high){
			int middle = low + (high-low)/2;
			if(x > arr[middle]){
				return findFirstOccurrenceRecursively(arr,middle+1,high,x);
			}
			else if(x < arr[middle]){
				return findFirstOccurrenceRecursively(arr,low,middle-1,x);
			}
			else{
				if(middle == 0 || arr[middle-1] != arr[middle]){
					return middle;
				}
				else{
					return findFirstOccurrenceRecursively(arr,low,middle-1,x);
				}
			}
		}
		return -1;
	}
}
