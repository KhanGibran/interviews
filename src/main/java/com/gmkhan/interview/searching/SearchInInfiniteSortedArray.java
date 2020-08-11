package com.gmkhan.interview.searching;

import org.junit.Test;

public class SearchInInfiniteSortedArray{

	@Test
	public void run(){
		int arr[] = new int[]{1,10,15,20,40,60,80,100,200,500,1000};
		int x = 100;
		int result = findElement(arr,x);
		System.out.println(result);
		System.out.println(findElementEfficiently(arr,x));
	}

	/**
	 * Naive Approach
	 * @param arr
	 * @param x
	 * @return
	 */
	private int findElement(int[] arr, int x) {
		int i=0;
		while(true){
			if(arr[i]==x){
				return i;
			}
			if(arr[i]>x){
				return -1;
			}
			i++;
		}
	}

	private int findElementEfficiently(int arr[],int x){
		if(arr[0]==x){
			return 0;
		}
		int i=1;
		int prev = -1;
		while(arr[i]<x){
			prev = i;
			i=i*2;
		}
		if(arr[i]==x){
			return i;
		}
		else return iterativeBinarySearch(arr,prev, i-1,x);
	}

	private static int iterativeBinarySearch(int arr[],int leftIndex,int rightIndex,int targetValue){
		while(leftIndex <= rightIndex){
			int middleIndex = leftIndex + (rightIndex-leftIndex)/2;
			if(targetValue == arr[middleIndex])
				return middleIndex;
			else if(targetValue > arr[middleIndex])
				leftIndex = middleIndex+1;
			else
				rightIndex = middleIndex-1;
		}
		return -1;
	}
}
