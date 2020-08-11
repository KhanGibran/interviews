package com.gmkhan.interview.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerSubsetDuplicates{

	@Test
	public void run(){
		int[] arr = new int[]{1,2,2};
		Set<List<Integer>> answer = getSubsetDuplicates(arr,arr.length);
		System.out.println(answer);
	}

	private Set<List<Integer>> getSubsetDuplicates(int[] arr, int n){
		List<Integer> current = new ArrayList<>();
		Set<List<Integer>> result = new HashSet<>();
		getSubsetDuplicatesUtil(arr,n,0,current,result);
		return result;
	}

	private void getSubsetDuplicatesUtil(int[] arr, int n, int index,List<Integer> current, Set<List<Integer>> result) {
		if(index == n){
			List<Integer> temp = new ArrayList<>(current);
			result.add(temp);
			return;
		}
		getSubsetDuplicatesUtil(arr,n,index+1,current,result);
		current.add(arr[index]);
		getSubsetDuplicatesUtil(arr,n,index+1,current,result);
		current.remove(current.size()-1);
	}
}
