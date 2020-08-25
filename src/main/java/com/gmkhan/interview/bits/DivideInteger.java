package com.gmkhan.interview.bits;

import org.junit.Test;

/**
 * Divide two Integer without using division, modulus and multiplication operator
 */
public class DivideInteger {

	@Test
	public void run(){
		int dividend = -2147483648;
		int divisor = 1;
		int answer = divide(dividend,divisor);
		System.out.println(answer);
	}

	private int divide(long dividend, long divisor){
		long n = dividend;
		long m = divisor;
		long sign = 1;
		if(n < 0L || m < 0L){
			if(n < 0L && m<0L){
				sign = 1L;
			}
			else{
				sign = -1L;
			}
		}
		n = Math.abs(n);
		m = Math.abs(m);
		long quotient = 0;

		while(n >= m){
			boolean executedOnce = false;
			long i = 0;
			while(true){
				long x =  (m<<i);
				if(x > n){
					executedOnce = true;
					quotient = quotient|(1L<<(i-1));
					n = n-(m<<(i-1));
				}
				if(executedOnce){
					break;
				}
				i++;
			}
		}

		if(sign < 0){
			quotient = -quotient;
		}
		if(quotient >= Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		else if(quotient <= Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		else{
			return (int) quotient;
		}
	}
}
