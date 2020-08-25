package com.gmkhan.interview.bits;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array A of size N.
 *
 * You need to find the value obtained by XOR-ing the contiguous sub-arrays,
 * followed by XOR-ing the values thus obtained. Determine and return this value.
 */
public class XORSubArray {

	@Test
	public void run(){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		int result = solve(list);
		System.out.println(result);
	}

	private int solve(ArrayList<Integer> A){
		if(A.size() % 2 == 0){
			return 0;
		}
		else{
			int xor = 0;
			for(int i=0; i<A.size(); i=i+2){
				xor = xor ^ A.get(i);
			}
			return xor;
		}
	}
}
