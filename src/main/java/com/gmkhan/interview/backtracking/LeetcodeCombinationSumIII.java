package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetcodeCombinationSumIII{

	@Test
	public void run(){
		int n = 18;
		int k = 2;
		List<List<Integer>> answer = combinationSum3(k, n);
		System.out.println(answer);
	}

	private List<List<Integer>> combinationSum3(int k, int n){
		int[] arr = new int[9];
		for(int i=0;i<9;i++){
			arr[i] = i+1;
		}
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> current = new ArrayList<>();
		combinationSum3Util(arr,arr.length,-1,k, n,current,result);
		return new ArrayList<>(result);
	}

	private void combinationSum3Util(int[] arr, int n, int index, int k, int target, List<Integer> current, Set<List<Integer>> result){
		if(target < 0){
			return;
		}
		if(k==0){
			if(target==0){
				List<Integer> temp = new ArrayList<>(current);
				result.add(temp);
			}
			return;
		}
		for(int i=index+1; i<n; i++){
			if(target-arr[i] < 0){
				break;
			}
			current.add(arr[i]);
			combinationSum3Util(arr,n,i,k-1,target-arr[i],current,result);
			current.remove(current.size()-1);
		}
	}
}
