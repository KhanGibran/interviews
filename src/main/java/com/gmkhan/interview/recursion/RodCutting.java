package com.gmkhan.interview.recursion;

import org.junit.Test;

public class RodCutting{

	@Test
	public void test(){
		int n = 9;
		int a = 2;
		int b = 2;
		int c = 2;

		int result = maxPieces(n,a,b,c);
		System.out.println(result);
	}

	private int maxPieces(int n, int a, int b, int c){
		if(n==0){
			return 0;
		}
		if(n<0){
			return -1;
		}
		int result = maximum(maxPieces(n-a,a,b,c),maxPieces(n-b,a,b,c),maxPieces(n-c,a,b,c));
		if(result == -1){
			return -1;
		}
		else{
			return result+1;
		}
	}

	private int maximum(int a, int b, int c){
		return Math.max(a,Math.max(b,c));
	}
}
