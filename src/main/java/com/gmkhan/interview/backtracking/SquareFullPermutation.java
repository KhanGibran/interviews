package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SquareFullPermutation{

	@Test
	public void run(){
		int[] arr = {1,17,8};
		List<Integer> current = new ArrayList<>();
		printSquareFullPermutation(arr,arr.length,0,current);
	}

	private void printSquareFullPermutation(int[] arr, int n, int index,List<Integer> current){

		if(current.size()>=2 && !isPerfectSquare(current)){
			return;
		}

		if(index==n){
			printArray(arr);
			return;
		}

		for(int i=index; i<n; i++){
			current.add(arr[i]);
			swap(arr,i,index);
			printSquareFullPermutation(arr,n,index+1,current);
			swap(arr,index,i);
			current.remove(current.size()-1);
		}
	}

	private void swap(int[] arr, int index, int i){
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
	}

	private void printArray(int[] arr){
		for(int x:arr){
			System.out.print(x+" ");
		}
		System.out.println();
	}

	boolean isPerfectSquare(List<Integer> current){
		int size = current.size();
		int n = current.get(size-1)+current.get(size-2);
		double root = Math.sqrt(n);
		return (root-Math.floor(root)==0);
	}
}
