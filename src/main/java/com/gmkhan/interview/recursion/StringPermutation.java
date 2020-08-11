package com.gmkhan.interview.recursion;

import org.junit.Test;

public class StringPermutation{

	private final boolean []visited = new boolean[300];

	@Test
	public void test(){
		String str = "ABC";
		String curr = "";
		printStringPermutation(str,curr,str.length());
	}

	private void printStringPermutation(String str, String current, int n){
		if(current.length()==n){
			System.out.println(current);
			return;
		}
		for(int i=0; i<n;i++){
			char ch = str.charAt(i);
			if(!visited[ch]){
				visited[ch] = true;
				printStringPermutation(str,current+ch,n);
				visited[ch] = false;
			}
		}
	}
}
