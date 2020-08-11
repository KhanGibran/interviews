package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Interview bit Combination Sum
 * Unlimited number of times
 */
public class LeetcodeCombinationSumI {

	@Test
	public void run(){
		int[] candidates = new int[]{8, 10, 6, 11, 1, 16, 8};
		int target = 28;
		List<List<Integer>> answer = combinationSum(candidates,target);
		System.out.println(answer);
	}

	private List<List<Integer>> combinationSum(int[] candidates, int target){
		List<Integer> currentCombination = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		combinationSumUtil(candidates,candidates.length,target,0,currentCombination,result);
		return result;
	}

	private void combinationSumUtil(int[] candidates, int n, int target,int currentIndex, List<Integer> current, List<List<Integer>> result){
		if(currentIndex==n){
			if(target==0){
				List<Integer> temp = new ArrayList<>(current);
				result.add(temp);
			}
			return;
		}
		if(target==0){
			List<Integer> temp = new ArrayList<>(current);
			result.add(temp);
			return;
		}
		if(target<0){
			return;
		}
		combinationSumUtil(candidates,n,target,currentIndex+1,current,result);
		current.add(candidates[currentIndex]);
		combinationSumUtil(candidates,n,target-candidates[currentIndex],currentIndex,current,result);
		current.remove(current.size()-1);
	}
}
