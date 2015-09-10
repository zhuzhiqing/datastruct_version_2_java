package com.jason.algrithm.dp;

public class DPMinPathSum {
	//https://leetcode.com/problems/minimum-path-sum/
	/*Given a m x n grid filled with non-negative numbers, 
	find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	*/	
	/*题目：一个表格中填满数字，问从左上角走到右下角，经过的空格中数字和最小的走法
	 * 递推表达式： dp[i][j]: 到达(i,j)时的最小值
	 * 			 dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid(i,j);
	 * 			从左边过来，和从右边过来两种情况
	 * 边界值：	
	*
	*/
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
                if(i!=0 && j!=0) dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                else if(i!=0 && j==0) dp[i][0] = dp[i-1][0] + grid[i][0];
                else if(i==0 && j!=0) dp[0][j] = dp[0][j-1] + grid[0][j];
                else dp[0][0] = grid[0][0];
			}
		}
		return dp[m - 1][n - 1];
	}
}
