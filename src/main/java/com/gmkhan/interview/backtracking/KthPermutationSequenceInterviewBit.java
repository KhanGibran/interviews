package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequenceInterviewBit{
	private int count = 0;

	@Test
	public void run(){
		int n = 11;
		int k = 2;
		String answer = getPermutation(n,k);
		System.out.println(answer);
	}

	private String getPermutation(int n, int k) {
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = i+1;
		}
		List<String> result = new ArrayList<>();
		permute(arr,n,k,0,result);
		return result.get(0);
	}

	private void permute(int[] arr, int n, int k, int index, List<String> result){
		if(index==n){
			count++;
			if(count==k){
				String current = convertToString(arr);
				result.add(current);
			}
			return;
		}
		for(int i=index; i<n; i++){
			if(count >= k){
				break;
			}
			leftShift(index,i,arr);
			permute(arr,n,k,index+1,result);
			rightShift(index,i,arr);
		}
	}

	private String convertToString(int[] arr){
		String result = "";
		for (int j : arr) {
			result = result + j;
		}
		return result;
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
	private void rightShift(int index,int i, int[] arr){
		int element = arr[index];
		while(index<i){
			arr[index] = arr[index+1];
			index++;
		}
		arr[i] = element;
	}

}
