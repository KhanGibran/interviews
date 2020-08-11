package com.gmkhan.interview.backtracking;

import org.junit.Test;

public class StringPermutationDuplicates {

	private final boolean[] visited = new boolean[26];

	@Test
	public void run(){
		String str = "abb";
		permute(str,0);
	}

	private void permute(String str, int index){
		boolean[] visited = new boolean[26];
		if(index == str.length()){
			System.out.println(str);
			return;
		}
		for(int i=index; i<str.length(); i++){
			char ch = str.charAt(i);
			if(!visited[ch-97]){
				visited[ch-97] = true;
				str = swap(str,index,i);
				permute(str,index+1);
				str = swap(str,i,index);
			}
		}
	}

	private String swap(String str, int index, int i){
		char[] ch = str.toCharArray();
		char temp = ch[index];
		ch[index] = ch[i];
		ch[i] = temp;
		return String.valueOf(ch);
	}

}
