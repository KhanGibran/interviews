package com.gmkhan.interview.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSubsetLexicographically {

	@Test
	public void run(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		ArrayList<ArrayList<Integer>> answer = subsets(list);
		System.out.println(answer);
	}

	private ArrayList<ArrayList<Integer>> subsets(List<Integer> list){
		Collections.sort(list);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		subSetUtil(list,list.size(),current,result,-1);
		return result;
	}

	private void subSetUtil(List<Integer> list, int n, List<Integer> current, ArrayList<ArrayList<Integer>> result, int index){
		if(index == n){
			return;
		}
		List<Integer> arrayList = new ArrayList<>(current);
		result.add((ArrayList<Integer>) arrayList);
		for(int i=index+1; i<n; i++){
			current.add(list.get(i));
			subSetUtil(list,n,current,result,i);
			current.remove(current.size()-1);
		}
	}
}
