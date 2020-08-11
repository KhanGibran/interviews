package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerPermutationDuplicates {

	@Test
	public void run(){
		int[] arr = {1,2,2};
		List<List<Integer>> answer = permute(arr);
		System.out.println(answer);
	}

	private List<List<Integer>> permute(int[] arr){
		List<List<Integer>> result = new ArrayList<>();
		permuteUtil(arr,arr.length,0,result);
		return result;
	}

	private void permuteUtil(int[] arr, int n,int index,List<List<Integer>> result){
		boolean[] visited = new boolean[11];
		if(index==n){
			List<Integer> temp = Arrays.stream(arr).boxed().collect(Collectors.toList());
			result.add(temp);
			return;
		}
		for(int i=index; i<n; i++){
			if(!visited[arr[i]]){
				visited[arr[i]] = true;
				arr = swap(arr,index,i);
				permuteUtil(arr,n,index+1,result);
				arr = swap(arr,i,index);
			}
		}
	}

	private int[] swap(int[] arr,int index, int i){
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
		return arr;
	}
}
