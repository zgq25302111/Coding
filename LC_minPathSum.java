package Coding;

public class LC_minPathSum {

	public static void main(String[] args) {
		int[][] grid = {
				  {1,2,3},
				  {4,5,6},
				  {7,8,9}
				};
		LC_minPathSum lc = new LC_minPathSum();
		System.out.println(lc.minPathSum(grid));
	}
	public int minPathSum(int[][] grid) {
		int m = grid.length;// row
		int n = grid[0].length; // column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				} else if (i != 0 && j == 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				} else if (i == 0 && j == 0) {
					grid[i][j] = grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
				}
			}
		}
		return grid[m - 1][n - 1];
	}
}
