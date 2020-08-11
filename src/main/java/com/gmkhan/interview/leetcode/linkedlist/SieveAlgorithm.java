package com.gmkhan.interview.leetcode.linkedlist;

public class SieveAlgorithm {

	@org.junit.Test
	public void test(){
		sieve(100);
	}

	private void sieve(int n){

		boolean[] primeArray = new boolean[n+1];
		for(int i=0; i<n;i++){
			primeArray[i] = true;
		}

		for(int p=2; p*p<=100;p++){
			if(primeArray[p]){
				for(int i=p*p; i<=n;i=i+p){
					primeArray[i] = false;
				}
			}
		}

		for(int i=2;i<=n;i++){
			if(primeArray[i]){
				System.out.print(i+" ");
			}
		}
	}
}
