package com.gmkhan.interview.searching;

import org.junit.Test;

public class LastOccurrenceInSortedArray{

	@Test
	public void run(){
		int[] arr = new int[]{1,10,10,10,20,20,40};
		int x = 5;
		int result = findLastOccurrenceRecursively(arr,0,arr.length-1,arr.length,x);
		System.out.println(findLastOccurrenceIteratively(arr,0,arr.length-1,arr.length,x));
		System.out.println(result);
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
	private int findLastOccurrenceRecursively(int[] arr, int low, int high, int n, int x){
		if(low <= high){
			int middle = low + (high-low)/2;
			if(x > arr[middle]){
				return findLastOccurrenceRecursively(arr,middle+1,high,n,x);
			}
			else if(x < arr[middle]){
				return findLastOccurrenceRecursively(arr,low,middle-1,n,x);
			}
			else{
				if(middle==n-1 || arr[middle] != arr[middle+1]){
					return middle;
				}
				else{
					return findLastOccurrenceRecursively(arr,middle+1,high,n,x);
				}
			}
		}
		else{
			return -1;
		}
	}
}
