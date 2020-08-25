package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis{

	@Test
	public void run(){
		int n= 2;
		List<String> answer = generateParenthesis(n);
		System.out.println(answer);
	}

	private List<String> generateParenthesis(int n){
		List<String> result = new ArrayList<>();
		int totalElements = 2*n;
		generatePermutationsUtil(n,totalElements,0,0,"",result);
		return result;
	}

	private void generatePermutationsUtil(int n, int totalElements,int open,int close, String current,List<String> result){
		if(current.length()==totalElements){
			result.add(current);
			return;
		}
		if(open < n){
			generatePermutationsUtil(n,totalElements,open+1,close,current+"(",result);
		}
		if(close < open){
			generatePermutationsUtil(n,totalElements,open,close+1,current+")",result);
		}
	}
}
