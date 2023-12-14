package leet_code;

//
//Given a 2D integer array matrix, return the transpose of matrix.
//
//The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
//

class TransposeMatrix{
	public static void main(String[] args) {

	}

	public int[][] transpose(int[][] matrix) {
		int row=matrix.length;
		int col=matrix[0].length;
		int[][] arr =new int[col][row]; // new array new dimensions
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				arr[i][j]=matrix[j][i];
			}
		}
		return arr;
	}

}