package com.gmkhan.interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;

public class SolveSudoku {

	@Test
	public void solveSudoku(){
		char[][] sudokuBoard = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		solveSudokuUtil(sudokuBoard);
		printBoard(sudokuBoard);
	}

	private void printBoard(char[][] sudokuBoard){
		for(int i=0;i<9; i++){
			for(int j=0; j<9; j++){
				System.out.print(sudokuBoard[i][j]+" ");
			}
			System.out.println();
		}
	}

	private boolean solveSudokuUtil(char[][] sudokuBoard){
		int row = -1;
		int col = -1;
		boolean isEmpty = true;

		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(sudokuBoard[i][j]=='.'){
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty){
				break;
			}
		}

		if(isEmpty){
			return true;
		}

		for(int num = 1; num<=9; num++){
			if(isSafe(row,col,num,sudokuBoard)){
				sudokuBoard[row][col] = (char) (num+48);
				if(solveSudokuUtil(sudokuBoard)){
					return true;
				}
				else{
					sudokuBoard[row][col] = '.';
				}
			}
		}
		return false;
	}

	private boolean isSafe(int row, int col, int num,char[][]sudokuBoard){
		for (int d = 0; d < 9; d++) {
			if (sudokuBoard[row][d]-48 == num) {
				return false;
			}
		}

		for (int r = 0; r < 9; r++) {
			if (sudokuBoard[r][col]-48 == num) {
				return false;
			}
		}

		int sqrt = (int)Math.sqrt(9);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (sudokuBoard[r][d]-48 == num) {
					return false;
				}
			}
		}
		return true;
	}
}
