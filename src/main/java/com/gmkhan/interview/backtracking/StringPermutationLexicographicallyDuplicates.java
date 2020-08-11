package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.Arrays;

public class StringPermutationLexicographicallyDuplicates {

	@Test
	public void run(){
		String str = "abb";
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		permuteLexicographicallyDuplicates(charArray, charArray.length,0);
	}

	private void permuteLexicographicallyDuplicates(char[] charArray, int n, int index){
		boolean[] visited = new boolean[26];
		if(index==n){
			printArray(charArray);
			return;
		}
		for(int i=index; i<charArray.length; i++){
			char ch = charArray[i];
			if(!visited[ch-97]){
				visited[ch-97] = true;
				leftShift(index,i,charArray);
				permuteLexicographicallyDuplicates(charArray,n,index+1);
				rightShift(index,i,charArray);
			}
		}
	}

	/**
	 * Shift character at i to Left
	 * @param index
	 * @param i
	 * @param charArray
	 */
	private void leftShift(int index, int i, char[] charArray){
		char element = charArray[i];
		while(i>index){
			charArray[i] = charArray[i-1];
			i--;
		}
		charArray[index] = element;
	}

	/**
	 * Shift character at index to Right
	 * @param index
	 * @param i
	 * @param charArray
	 */
	private void rightShift(int index,int i,char charArray[]){
		char element = charArray[index];
		while(index<i){
			charArray[index] = charArray[index+1];
			index++;
		}
		charArray[i] = element;
	}

	private void printArray(char[] charArray){
		for (char c : charArray) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
}
