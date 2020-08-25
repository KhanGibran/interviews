package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequenceLeetcode {

	private int count = 0;

	@Test
	public void run(){
		int n = 9;
		int k = 2;
		String answer = getPermutation(n,k);
		System.out.println(answer);
	}
	private String getPermutation(int n, int k){
		char[] arr = new char[n];
		for(int i=0; i<9;i++){
			char ch = (char)(i+1+48);
			arr[i] = ch;
		}
		List<String> result = new ArrayList<>();
		permute(arr,n,k,0,result);
		return result.get(0);
	}

	private void permute(char[] arr, int n, int k, int index, List<String> result) {
		if(index==n){
			count++;
			if(count==k){
				String str = new String(arr);
				result.add(str);
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

	/**
	 * Shift character at i to Left
	 * @param index
	 * @param i
	 * @param arr
	 */
	private void leftShift(int index, int i, char[] arr){
		char element = arr[i];
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
	private void rightShift(int index,int i, char[] arr){
		char element = arr[index];
		while(index<i){
			arr[index] = arr[index+1];
			index++;
		}
		arr[i] = element;
	}
}
