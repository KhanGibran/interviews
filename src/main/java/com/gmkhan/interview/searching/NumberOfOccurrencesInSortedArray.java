package com.gmkhan.interview.searching;

import org.junit.Test;

public class NumberOfOccurrencesInSortedArray{

	@Test
	public void run(){
		int[] arr = new int[]{1,10,10,10,20,20,40};
		int x = 20;
		int result = findNumberOfOccurrences(arr,arr.length,x);
		System.out.println(result);
	}

	private int findNumberOfOccurrences(int[] arr, int n, int x) {
		int first = findFirstOccurrenceIteratively(arr,0,n-1,x);
		if(first == -1){
			return 0;
		}
		else{
			return findLastOccurrenceIteratively(arr,0,n-1,n,x)-first+1;
		}
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

	private int findLastOccurrenceIteratively(int[] arr, int low, int high, int n, int x){
		while(low <= high){
			int middle = low + (high-low)/2;
			if(x > arr[middle]){
				low = middle+1;
			}
			else if(x < arr[middle]){
				high = middle-1;
			}
			else{
				if(middle==n-1 || arr[middle] != arr[middle+1]){
					return middle;
				}
				else{
					low = middle+1;
				}
			}
		}
		return -1;
	}
}
