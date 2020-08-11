package com.gmkhan.interview.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IntegerSubset {

	@Test
	public void test(){
		int[] arr = new int[]{1,2,3};
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		generateSubset(arr,arr.length,0,list,result);
		System.out.println(result);
	}

	private void generateSubset(int[] arr, int n, int index,List<Integer> list,List<List<Integer>> result){
		if(index==n){
			List<Integer> temp = new ArrayList<>(list);
			result.add(temp);
			return;
		}
		generateSubset(arr,n,index+1,list,result);
		list.add(arr[index]);
		generateSubset(arr,n,index+1,list,result);
		list.remove(list.size()-1);
	}
}
