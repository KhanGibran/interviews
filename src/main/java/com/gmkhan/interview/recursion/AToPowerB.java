package com.gmkhan.interview.recursion;

import org.junit.Test;

public class AToPowerB{

	@Test
	public void test(){
		int a = 2;
		int b = 6;
		int result = pow(a,b);
		System.out.println(result);
		System.out.println(optimizedPow(2,6));
	}

	private int pow(int a, int b){
		if(b==0){
			return 1;
		}
		else{
			return a*pow(a,b-1);
		}
	}

	private int optimizedPow(int a,int b){
		if(b==1){
			return a;
		}
		int x = optimizedPow(a,b/2);
		if(b%2==0){
			return x*x;
		}
		else{
			return a*x*x;
		}
	}
}
