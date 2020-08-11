package com.gmkhan.interview.recursion;

import org.junit.Test;

import java.util.Arrays;

public class StringSubsetLexicographically {

	@Test public void test() {
		char[] charsArray = new char[] { 'b', 'c', 'a' };
		Arrays.sort(charsArray);
		printSubsetLexicographically(charsArray, charsArray.length, -1, "");
	}

	private void printSubsetLexicographically(char[] charsArray, int n, int index, String current) {
		if (index == n) {
			return;
		}
		System.out.println(current);
		for (int i = index + 1; i < n; i++) {
			printSubsetLexicographically(charsArray, n, i, current + charsArray[i]);
		}
	}
}
