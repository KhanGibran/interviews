package com.gmkhan.interview.searching;

import org.junit.Test;

public class SquareRootOfNumber{

	private int answer = -1;
	@Test
	public void run(){
		int x = 40;
		System.out.println(squrtIterative(40));
		System.out.println(squrtRecursive(1,40,x));
	}

	private int squrtIterative(int n){
		int low = 1;
		int high = n;
		int ans = -1;
		while(low <= high){
			int middle = low + (high-low)/2;
			if(middle * middle == n){
				return middle;
			}
			if(middle * middle > n){
				high = middle-1;
			}
			else{
				low = middle+1;
				ans = middle;
			}
		}
		return ans;
	}

	private int squrtRecursive(int low, int high,int x){
		if(low <= high){
			int middle = low+(high-low)/2;
			if(middle*middle == x){
				return middle;
			}
			if(middle * middle > x){
				return squrtRecursive(low,middle-1,x);
			}
			else{
				answer = middle;
				return squrtRecursive(middle+1,high,x);
			}
		}
		return this.answer;
	}
}
