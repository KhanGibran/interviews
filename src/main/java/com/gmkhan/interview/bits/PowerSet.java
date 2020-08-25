package com.gmkhan.interview.bits;

import org.junit.Test;

public class PowerSet{

	@Test
	public void run(){
		String str = "abc";
		printPowerSet(str);
	}

	private void printPowerSet(String str){
		int n = str.length();
		int pow = (int)Math.pow(2,n);

		for(int counter = 0; counter < pow; counter++){
			for(int j = 0; j < n; j++){
				if((counter & (1<<j)) != 0){
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
