package com.gmkhan.interview.backtracking;

import org.junit.Test;

public class RateMazeProblem{

	@Test
	public void run(){
		int[][] maze = { { 1, 0, 0, 0 },
				         { 1, 1, 0, 1 },
				         { 0, 1, 0, 0 },
				         { 1, 1, 1, 1 } };
		int row = 4;
		int column = 4;
		boolean[][] visited = new boolean[4][4];
		for(int i=0;i<row;i++){
			for(int j=0; j<column; j++){
				visited[i][j] = false;
			}
		}
		solveRatMaze(maze,row,column,0,0,visited);
	}

	private void solveRatMaze(int[][] maze, int row, int column, int i, int j, boolean[][] visited){
		if(i==row-1 && j==column-1){
			printVisited(visited,row,column);
			return;
		}
		visited[i][j] = true;

		if(isSafe(maze,row,column,i,j-1,visited)){
			solveRatMaze(maze,row,column,i,j-1,visited);
		}
		if(isSafe(maze,row,column,i,j+1,visited)){
			solveRatMaze(maze,row,column,i,j+1,visited);
		}
		if(isSafe(maze,row,column,i-1,j,visited)){
			solveRatMaze(maze,row,column,i-1,j,visited);
		}
		if(isSafe(maze,row,column,i+1,j,visited)){
			solveRatMaze(maze,row,column,i+1,j,visited);
		}
		visited[i][j] = false;
	}

	private void printVisited(boolean[][] visited,int row,int column){
		visited[row-1][column-1] = true;
		for(int i=0; i<row; i++){
			for(int j=0; j<column; j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}

	private boolean isSafe(int[][] maze, int row, int column, int i, int j,boolean [][]visited){
		if(i<0 || i>=row || j<0 || j>=column ){
			return false;
		}
		if(visited[i][j]){
			return false;
		}
		if(maze[i][j]==0){
			return false;
		}
		return true;
	}
}
