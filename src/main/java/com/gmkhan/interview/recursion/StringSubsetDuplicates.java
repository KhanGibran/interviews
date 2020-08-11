package com.gmkhan.interview.recursion;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class StringSubsetDuplicates{

	@Test
	public void run(){
		String str = "ABB";
		Set<String> result = new HashSet<>();
		printStringSubsetDuplicates(str,str.length(),0,"",result);
		System.out.println(result);
	}

	private void printStringSubsetDuplicates(String str, int length,int index,String current,Set<String> result){
		if(index==length){
			result.add(current);
			return;
		}
		printStringSubsetDuplicates(str,length,index+1,current,result);
		printStringSubsetDuplicates(str,length,index+1,current+str.charAt(index),result);
	}
}
