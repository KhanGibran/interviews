package com.gmkhan.interview.bits;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PairXor{

	@Test
	public void run(){
		int[] arr = {5,10,4,15,7,6};
		int n = arr.length;
		int k = 5;
		printPair(arr,n,k);
	}

	private void printPair(int[] arr, int n, int k){
		Map<Integer,Boolean> map = new HashMap<>();
		for(int x:arr){
			int temp = x^k;
			if(map.containsKey(temp)){
				System.out.println("Pair found "+x+" and "+temp);
			}
			else{
				map.put(x,true);
			}
		}
	}
}
