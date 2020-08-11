package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Interview bit Combinations
 * K
 * N
 */
public class InterviewbitCombinations {

	@Test
	public void run(){
		int n = 4;
		int k = 2;
		List<List<Integer>> answer = combine(n,k);
		System.out.println(answer);
	}

	private List<List<Integer>> combine(int n, int k){
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=i+1;
		}
		List<Integer> current = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		combineUtil(arr,arr.length,k,-1,current,result);
		return result;
	}

	private void combineUtil(int[] arr, int n,int k, int index, List<Integer> current, List<List<Integer>> result){
		if(k==0){
			ArrayList<Integer> temp = new ArrayList<>(current);
			result.add(temp);
			return;
		}
		for(int i=index+1; i<n; i++){
			current.add(arr[i]);
			combineUtil(arr,n,k-1,i,current,result);
			current.remove(current.size()-1);
		}
	}
}
