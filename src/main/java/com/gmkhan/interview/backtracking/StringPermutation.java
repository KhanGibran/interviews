package com.gmkhan.interview.backtracking;

import org.junit.Test;

public class StringPermutation {

	@Test
	public void test(){
		String str = "ABC";
		printPermutation(str,0);
	}

	/**
	 * Using Backtracking
	 * @param str
	 * @param index
	 */
	private void printPermutation(String str,int index){
		if(index == str.length()){
			System.out.println(str);
		}
		for(int i=index; i<str.length(); i++){
			str = swap(str,index,i);
			printPermutation(str,index+1);
			str = swap(str,i,index);
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
