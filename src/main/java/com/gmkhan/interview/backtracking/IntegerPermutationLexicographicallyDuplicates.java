package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.Arrays;

public class IntegerPermutationLexicographicallyDuplicates{

	@Test
	public void run(){
		int[] arr = {2,1,2};
		Arrays.sort(arr);
		permuteLexicographically(arr,arr.length,0);
	}

	private void permuteLexicographically(int[] arr, int n, int index){
		boolean visited[] = new boolean[10];
		if(index==n){
			printArray(arr);
		}
		for(int i=index; i<n; i++){
			if(!visited[arr[i]]){
			visited[arr[i]] = true;
			leftShift(index,i,arr);
			permuteLexicographically(arr,n,index+1);
			rightShift(index,i,arr);
			}
		}
	}

	private void printArray(int[] arr){
		for(int x:arr){
			System.out.print(x+" ");
		}
		System.out.println();
	}

	/**
	 * Shift character at i to Left
	 * @param index
	 * @param i
	 * @param arr
	 */
	private void leftShift(int index, int i, int[] arr){
		int element = arr[i];
		while(i>index){
			arr[i] = arr[i-1];
			i--;
		}
		arr[index] = element;
	}

	/**
	 * Shift character at index to Right
	 * @param index
	 * @param i
	 * @param arr
	 */
	private void rightShift(int index,int i,int arr[]){
		int element = arr[index];
		while(index<i){
			arr[index] = arr[index+1];
			index++;
		}
		arr[i] = element;
	}
}
