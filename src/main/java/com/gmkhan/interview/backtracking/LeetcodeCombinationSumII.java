package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.*;

/**
 * Interview bit Combination Sum II
 * May only be used once in the combination
 */
public class LeetcodeCombinationSumII {

	@Test
	public void run(){
		int []candidates = new int[]{10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> answer = combinationSum2(candidates,target);
		System.out.println(answer);
	}

	private List<List<Integer>> combinationSum2(int[] candidates, int target){
		Arrays.sort(candidates);
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> current = new ArrayList<>();
//		combinationSumUtil(candidates, candidates.length, target,0,current,result);
		combinationSumUtil2(candidates, candidates.length, target,0,current,result);
		return new ArrayList<>(result);
	}

	/**
	 * Normal Approach with recursion
	 * Gives TLE for larger inputs
	 * @param candidates
	 * @param n
	 * @param target
	 * @param index
	 * @param current
	 * @param result
	 */
	private void combinationSumUtil(int[] candidates, int n,int target, int index, List<Integer> current, Set<List<Integer>> result){
		if(index == n){
			if(target==0){
				List<Integer> temp = new ArrayList<>(current);
				result.add(temp);
				System.out.println(temp);
			}
			return;
		}
		combinationSumUtil(candidates,n,target,index+1,current,result);
		current.add(candidates[index]);
		combinationSumUtil(candidates,n,target-candidates[index],index+1,current,result);
		current.remove(current.size()-1);
	}

	/**
	 * Using Loop and recursion
	 * @param arr
	 */
	private void combinationSumUtil2(int[] arr,int n,int target,int index,List<Integer> current, Set<List<Integer>> myAnswer)
	{

		if(target < 0){
			return;
		}
		else if(target==0){
			myAnswer.add(new ArrayList<>(current));
		}
		else{
			//Target is greater that zero
			for(int i=index; i<n; i++){
				if(i>index && arr[i-1] == arr[i]){
					continue;
				}
				if(target-arr[i] <0 ){
					break;
				}
				current.add(arr[i]);
				combinationSumUtil2(arr,n,target-arr[i],i+1,current,myAnswer);
				current.remove(current.size()-1);
			}
		}
	}
}
