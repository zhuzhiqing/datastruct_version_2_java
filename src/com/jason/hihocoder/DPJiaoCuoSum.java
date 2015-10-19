package com.jason.hihocoder;

import java.util.ArrayList;
import java.util.List;

public class DPJiaoCuoSum {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == 0) {
					if (j == 0) {
						dp[i][j] = grid[0][0];
					} else {
						dp[i][j] = grid[0][j - 1] + grid[0][j];
					}
				} else if(j==0) {
					dp[i][j] = dp[i-1][0] + grid[i][0];
				}else{
					dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+ grid[i][j];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
