package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.Arrays;

public class StringPermutationLexicographically{

	@Test
	public void run(){
		String str = "bac";
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		permuteLexicographically(charArray, charArray.length,0);
	}

	private void permuteLexicographically(char[] charArray, int n,int index){
		if(index==n){
			printArray(charArray);
			return;
		}
		for(int i=index; i<charArray.length; i++){
			leftShift(index,i,charArray);
			permuteLexicographically(charArray,n,index+1);
			rightShift(index,i,charArray);
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
