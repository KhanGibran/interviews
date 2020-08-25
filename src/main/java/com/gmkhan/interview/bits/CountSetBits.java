package com.gmkhan.interview.bits;

import org.junit.Test;

public class CountSetBits {

	@Test
	public void run(){
		int n = 6;
		System.out.println(countSetBits1(n));
		System.out.println(countSetBits2(n));
		System.out.println(kerningamAlgo(n));
	}

	private int kerningamAlgo(int n){
		int res = 0;
		while(n>0){
			n = n&(n-1);
			res++;
		}
		return res;
	}

	private int countSetBits2(int n){
		int res = 0;
		while(n>0){
			if((n & 1) ==1){
				res++;
			}
			n=n>>1;
		}
		return res;
	}

	private int countSetBits1(int n){
		int res = 0;
		while(n>0){
			if(n%2 != 0){
				res++;
			}
			n=n/2;
		}
		return res;
	}
}
