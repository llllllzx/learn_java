package class_08;

public class Code_07_MinPath {

	public static int minPath1(int[][] matrix) {
		return process1(matrix, matrix.length - 1, matrix[0].length - 1);
	}

	public static int process1(int[][] matrix, int i, int j) {
		int res = matrix[i][j];
		if (i == 0 && j == 0) {
			return res;
		}
		if (i == 0 && j != 0) {
			return res + process1(matrix, i, j - 1);
		}
		if (i != 0 && j == 0) {
			return res + process1(matrix, i - 1, j);
		}
		return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
	}

	public static int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(1+""+1);
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));

		m = generateRandomMatrix(6, 7);
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));


		//在LeetCode上使用递归方法会提示Time Limit Exceeded
		int[][] grid ={{5,1,0,4,0,1,1,6,7,3,9,9,4,6,8,1},{9,1,0,6,4,2,8,0,1,6,0,2,7,9,0,4},{3,2,0,3,3,3,1,3,7,3,2,1,1,2,2,0},{5,2,8,2,7,6,2,0,5,3,2,4,4,4,8,9},{7,0,5,2,4,6,7,1,1,1,2,2,6,6,4,1},{0,3,5,9,1,8,0,6,3,4,0,9,9,0,9,8},{3,4,0,7,2,8,0,4,9,4,8,5,2,5,9,4},{0,4,4,1,4,6,0,7,0,2,7,1,3,8,9,8},{2,0,7,4,0,7,0,1,1,1,9,5,6,8,9,6},{4,3,9,9,1,9,8,4,2,7,5,7,5,5,5,9},{7,4,6,9,1,8,0,4,9,9,9,7,9,8,3,4},{4,3,5,7,4,5,1,8,3,7,7,0,4,4,2,3},{8,0,2,9,8,2,5,8,4,4,7,3,5,1,9,1},{6,4,8,2,2,2,1,7,1,8,7,5,5,1,0,3},{1,2,5,0,6,0,0,0,7,7,6,4,0,5,5,8},{2,5,1,4,9,4,1,0,2,0,5,7,4,7,3,5},{9,8,7,8,8,9,8,5,9,6,9,9,2,6,0,6},{4,1,2,3,5,5,4,9,5,1,9,9,9,2,7,0},{0,6,8,0,6,9,8,7,5,7,8,9,6,8,5,0}};
		final int i = minPathSum(grid);
		System.out.println(i);
	}



	public static int minPathSum(int[][] grid) {
		return helper(grid,grid.length -1,grid[0].length-1);
	}
	private static  int helper(int[][] grid,int i,int j){
		int res = grid[i][j];
		if(i == 0 && j == 0){
			return res;
		}
		if(i ==0 && j !=0 ){
			return res += helper(grid,i,j-1);
		}
		if(i !=0 && j == 0){
			return res += helper(grid,i-1,j);
		}

		return res += Math.min(helper(grid,i-1,j),helper(grid,i,j-1));
	}
}
