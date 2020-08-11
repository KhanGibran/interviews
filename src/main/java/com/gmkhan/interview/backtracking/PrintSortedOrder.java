package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintSortedOrder{

	@Test
	public void run(){
		int[] arr = new int[]{7,5,3,2,2};
		int n = arr.length;
		List<Integer> current = new ArrayList<>();
		printSortedPermutation(arr,n,0,current);
	}

	private void printSortedPermutation(int[] arr, int n, int index,List<Integer> current){
		if(index==n){
			System.out.println(current);
		}

		for(int i=index; i<n; i++){
			if(!current.isEmpty() && arr[i] < current.get(current.size()-1)){
				break;
			}
			current.add(arr[i]);
			swap(arr, index, i);
			printSortedPermutation(arr,n,index+1,current);
			current.remove(current.size()-1);
			swap(arr, i, index);
		}
	}

	private void swap(int[] arr, int index, int i){
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
	}
}
