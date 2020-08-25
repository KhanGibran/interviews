package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterPhone {
	private final List<String> phone = new ArrayList<String>(
			Arrays.asList("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));

	@Test
	public void run(){
		String digits = "2";
		List<String> answer = letterCombinations(digits);
		System.out.println(answer);
	}

	private List<String> letterCombinations(String digits){
		List<String> result = new ArrayList<>();
		if(digits.equals("")){
			return result;
		}
		letterCombinationsUtil(digits,digits.length(),0,"",result);
		return result;
	}

	private void letterCombinationsUtil(String digits, int n,int index,String current, List<String> result){
		if(index == n){
			System.out.println(current);
			result.add(current);
			return;
		}
		String currentString = phone.get(digits.charAt(index)-48);
		for(int i=0; i<currentString.length();i++){
			letterCombinationsUtil(digits,n,index+1,current+currentString.charAt(i),result);
		}
	}
}
