package com.gmkhan.interview.bits;

import org.junit.Test;

/**
 * Given an array in which all the numbers are repeating thrice. except one number
 * that exist only once. Find this single number;
 */
public class NumberRepeatingThrice {

	@Test
	public void run(){
		int[] arr = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		int n = arr.length;
		String result = getSingleNumber(arr,n);
		int decimalResult = convertToDecimal(result,result.length());
		System.out.println(decimalResult);
	}

	private int convertToDecimal(String string,int length){
		int decimal = 0;
		int base = 1;
		for(int i=length-1; i>=0; i--){
			if(string.charAt(i)=='1'){
				decimal += base;
			}
			base = 2*base;
		}
		return decimal;
	}

	private String getSingleNumber(int[] arr, int n){
		int aux = 1;
		String result = "";

		for(int i=0; i<32; i++){
			int countZero = 0;
			int countOne = 0;

			for(int j=0; j<n; j++){
				if((aux & arr[j])==0){
					countZero++;
				}
				else{
					countOne++;
				}
			}
			aux = aux<<1;
			if(countZero % 3 == 0){
				result = result+"1";
			}
			else if(countOne % 3 == 0){
				result = result+"0";
			}
		}
		return new StringBuffer(result).reverse().toString();
	}
}
