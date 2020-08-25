package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximalString{

	@Test
	public void run(){
		String str = "254";
		int B = 2;
		String answer = solve(str,B);
		System.out.println(answer);
	}

	private String solve(String str, int b){
		Set<String> result = new HashSet<>();
		solveUtil(str,str.length(),b,0,result);
		int max = Integer.MIN_VALUE;
		for(String st:result){
			int value = Integer.parseInt(st);
			if(value > max){
				max = value;
			}
		}
		return Integer.toString(max);
	}

	private void solveUtil(String str, int n, int b, int index,Set<String> result){
		if(index==n){
			result.add(str);
			return;
		}
		for(int i=index; i<n; i++){
			if(b>0){
				str = swap(str,index,i);
			}
			solveUtil(str,n,b-1,index+1,result);
			if(b>0){
				str = swap(str,i,index);
			}
		}
	}

	private String swap(String str, int index, int i) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[index];
		charArray[index] = temp;
		return String.valueOf(charArray);
	}
}
