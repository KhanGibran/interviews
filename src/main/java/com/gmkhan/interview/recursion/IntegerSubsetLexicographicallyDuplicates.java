package com.gmkhan.interview.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IntegerSubsetLexicographicallyDuplicates{

	@Test
	public void run(){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		ArrayList<ArrayList<Integer>> answer = subsetsWithDup(list);
		System.out.println(answer);
	}

	private ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> list){
		Collections.sort(list);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> current = new ArrayList<>();
		subsetLexicographicallyDuplicates(list,list.size(),-1,current,result);
		return result;
	}

	private void subsetLexicographicallyDuplicates(ArrayList<Integer> list, int n, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
		Map<Integer,Boolean> map = new HashMap<>();
		if(index==n){
			return;
		}
		ArrayList<Integer> temp = new ArrayList<>(current);
		result.add(temp);
		for(int i=index+1; i<n; i++){
			if(map.containsKey(list.get(i))){
				if(map.get(list.get(i))){
					continue;
				}
			}
			map.put(list.get(i),true);
			current.add(list.get(i));
			subsetLexicographicallyDuplicates(list,n,i,current,result);
			current.remove(current.size()-1);

		}
	}
}
