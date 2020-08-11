package com.gmkhan.interview.backtracking;

import org.junit.Test;

public class StringNBits{

	@Test
	public void run(){
		int n=4;
		printBitString(n,0,"");
	}

	private void printBitString(int n, int index,String current){
		if(index==n){
			System.out.println(current);
			return;
		}
		printBitString(n,index+1,current+"0");
		printBitString(n,index+1,current+"1");
	}
}
