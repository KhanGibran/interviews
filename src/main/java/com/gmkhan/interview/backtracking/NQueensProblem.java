package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {

	@Test
	public void run(){
		int n=4;
		List<List<String>> answer = solveNQueens(n);
		System.out.println(answer);
	}

	private List<List<String>> solveNQueens(int n){
		char[][] board = new char[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				board[i][j]= '.';
			}
		}
		List<List<String>> result = new ArrayList<>();
		solveNQueensUtil(board,n,0,result);
		return result;
	}

	private void solveNQueensUtil(char[][] board, int n, int currentRow,List<List<String>> result){
		if(currentRow==n){
			List<String> temp = constructBoard(board,n);
			result.add(temp);
			return;
		}
		for(int currentColumn = 0; currentColumn<n; currentColumn++){
			if(isSafe(board,currentRow,currentColumn,n)){
				board[currentRow][currentColumn] = 'Q';
				solveNQueensUtil(board,n,currentRow+1,result);
				board[currentRow][currentColumn] = '.';
			}
		}
	}

	private boolean isSafe(char board[][],int currentRow, int currentColumn, int n){
		for(int i=0;i<currentRow; i++){
			if(board[i][currentColumn]=='Q'){
				return false;
			}
		}
		int i = currentRow-1;
		int j = currentColumn-1;
		while( i>=0 && j>=0){
			if(board[i][j]=='Q'){
				return false;
			}
			i--;
			j--;
		}

		i = currentRow-1;
		j = currentColumn+1;
		while(i>=0 && j<n){
			if(board[i][j]=='Q'){
				return false;
			}
			i--;
			j++;
		}
		return true;
	}

	private List<String> constructBoard(char[][] board,int n){
		List<String> brd = new ArrayList<>();
		for(int i=0; i<n; i++){
			String str = new String(board[i]);
			brd.add(str);
		}
		return brd;
	}
}
