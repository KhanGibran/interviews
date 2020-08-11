package com.gmkhan.interview.recursion;

import org.junit.Test;

import java.util.*;

public class StringSubsetLexicographicallyDuplicates{

	@Test
	public void run(){
		String str = "BAA";
		List<String> result = new ArrayList<>();
		char[] stringCharacter = str.toCharArray();
		Arrays.sort(stringCharacter);
		String sorted = new String(stringCharacter);
		getSubsetLexicographicallyDuplicates(sorted,str.length(),-1,"",result);
		System.out.println(result);
	}

	private void getSubsetLexicographicallyDuplicates(String str, int n, int index, String current, List<String> result){
		Map<Character,Boolean> visited = new HashMap<>();
		if(index==n){
			return;
		}
		result.add(current);
		for(int i=index+1; i<n; i++){
			if(visited.containsKey(str.charAt(i))){
				if(visited.get(str.charAt(i))){
					continue;
				}
			}
			visited.put(str.charAt(i),true);
			getSubsetLexicographicallyDuplicates(str,n,i,current+str.charAt(i),result);
		}
	}
}
