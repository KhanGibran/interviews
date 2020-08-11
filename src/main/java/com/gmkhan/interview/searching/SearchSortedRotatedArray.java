package com.gmkhan.interview.searching;

import org.junit.Test;

/**
 * Array should have distinct element
 */
public class SearchSortedRotatedArray{

	@Test
	public void run(){
		int []arr = new int[]{10,20,30,40,50,8,9,9};
		int x = 30;
		int pivotIndex = getPivotIndex(arr);
		int searchElementFirst = iterativeBinarySearch(arr,0,pivotIndex-1,x);
		if(searchElementFirst != -1){
			System.out.println(searchElementFirst);
		}
		else{
			System.out.println(iterativeBinarySearch(arr,pivotIndex+1,arr.length-1,x));
		}
		System.out.println(search(arr,x));
	}

	private int getPivotIndex(int[] arr){
		int low = 0;
		int high = arr.length-1;

		while(low <= high){
			int middle = low+(high-low)/2;
			if(arr[middle-1] > arr[middle] && arr[middle+1] >= arr[middle]){
				return middle;
			}
			if(arr[low] < arr[middle]){
				low = middle+1;
			}
			else{
				high = middle-1;
			}
		}
		return -1;
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

	private int search(int []arr,int x){
		int low = 0;
		int high = arr.length-1;

		while(low <= high){
			int middle = low + (high-low)/2;
			if(arr[middle] == x){
				return middle;
			}

			else if(arr[low] < arr[middle]){
				// Left half is sorted
				if(x >= arr[low] && x<arr[middle]){
					high = middle-1;
				}
				else{
					low = middle+1;
				}
			}
			else{
				// Right half is sorted
				if(x > arr[middle] && x<=arr[high]){
					low = middle+1;
				}
				else{
					high = middle-1;
				}
			}
		}
		return -1;
	}
}
