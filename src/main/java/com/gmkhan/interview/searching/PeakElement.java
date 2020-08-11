package com.gmkhan.interview.searching;

import org.junit.Test;

public class PeakElement{

	@Test
	public void test(){
		int []arr = new int[]{10,20,15,5,23,90,67};
		int peakElement = getPeakElementNaive(arr);
		System.out.println(peakElement);
		int peakElementEfficiently = getPeakElementEfficiently(arr,arr.length);
		System.out.println(peakElementEfficiently);
	}

	private int getPeakElementEfficiently(int[] arr,int n){
		int low = 0;
		int high = arr.length-1;

		while(low <= high){
			int middle = low + (high-low)/2;

			if((middle==0 || arr[middle] >= arr[middle-1]) && ((middle==n-1) || (arr[middle] >= arr[middle+1]))){
				return arr[middle];
			}
			if(middle > 0 && arr[middle-1] >= arr[middle]){
				high = middle-1;
			}
			else{
				low = middle+1;
			}
		}
		return -1;
	}
	//TODO Majority Element implementation
	private int getPeakElementNaive(int[] arr){
		int n = arr.length;
		if(n==1){
			return arr[0];
		}
		if(arr[0] > arr[1]){
			return arr[0];
		}
		if(arr[n-1] > arr[n-2]){
			return arr[n-1];
		}

		for(int i=1;i<n-1;i++){
			if(arr[i] >= arr[i-1] && arr[i] >= arr[i+1]){
				return arr[i];
			}
		}
		return -1;
	}
}
