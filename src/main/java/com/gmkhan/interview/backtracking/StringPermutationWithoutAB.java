package com.gmkhan.interview.backtracking;

import org.junit.Test;

public class StringPermutationWithoutAB {
	private final boolean []visited = new boolean[300];

	@Test
	public void run(){
		String str = "ABC";
		printPermutation(str,0,str.length(),"");
	}

	private void printPermutation(String str, int index, int n, String current){
		if(current.contains("AB")){
			return;
		}
		if(index==n){
			System.out.println(current);
			return;
		}
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(!visited[ch]){
				visited[ch] = true;
				printPermutation(str,index+1,n,current+ch);
				visited[ch] = false;
			}
		}
	}
}
