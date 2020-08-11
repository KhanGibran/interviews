package com.gmkhan.interview.recursion;

import org.junit.Test;

public class StringSubset
{
	@Test
	public void run(){
		String str = "ABC";
		printSubset(str,"",0);
	}

	private void printSubset(String str, String current, int index){
		if(index == str.length()){
			System.out.println(current);
			return;
		}
		printSubset(str,current,index+1);
		printSubset(str,current+str.charAt(index),index+1);
	}
}
