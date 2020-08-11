package com.gmkhan.interview.backtracking;

import org.junit.Test;

public class StringCombinations {

	@Test
	public void run(){
		int k = 4;
		char[] ch = new char[]{'a','b','c','d','e'};
		printCombination(ch,ch.length,k,-1,"");
	}

	private void printCombination(char[] ch, int n, int k,int index, String current) {
		if (k == 0) {
			System.out.println(current);
			return;
		}
		for (int i = index + 1; i < n; i++) {
			printCombination(ch, n, k - 1, i, current + ch[i]);
		}
	}
}
