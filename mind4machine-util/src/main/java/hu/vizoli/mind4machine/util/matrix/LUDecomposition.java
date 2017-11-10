package hu.vizoli.mind4machine.util.matrix;

/**
 * LU decomposition.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class LUDecomposition {
	private final double[][] LUMatrixArr;
	private final int row;
	private final int column;
	private final int[] pivot;

	/**
	 * Create a LUDecomposition instance of given Matrix to decompose.
	 * 
	 * @param matrix to decompose
	 */
	public LUDecomposition(final Matrix matrixToDecompose) {
		LUMatrixArr = matrixToDecompose.getArrayCopy();
		row = matrixToDecompose.getRow();
		column = matrixToDecompose.getColumn();
		pivot = new int[row];
		final double[] LUColumnj = new double[row];
		double[] LURowi;

		for (int i = 0; i < row; i++) {
			pivot[i] = i;
		}

		for (int j = 0; j < column; j++) {
			for (int i = 0; i < row; i++) {
				LUColumnj[i] = LUMatrixArr[i][j];
			}

			for (int i = 0; i < row; i++) {
				LURowi = LUMatrixArr[i];

				final int kmax = Math.min(i, j);
				double s = 0.0;
				for (int k = 0; k < kmax; k++) {
					s += LURowi[k] * LUColumnj[k];
				}

				LURowi[j] = LUColumnj[i] -= s;
			}

			int p = j;
			for (int i = j + 1; i < row; i++) {
				if (Math.abs(LUColumnj[i]) > Math.abs(LUColumnj[p])) {
					p = i;
				}
			}

			if (p != j) {
				for (int k = 0; k < row; k++) {
					final double t = LUMatrixArr[p][k];
					LUMatrixArr[p][k] = LUMatrixArr[j][k];
					LUMatrixArr[j][k] = t;
				}

				final int k = pivot[p];
				pivot[p] = pivot[j];
				pivot[j] = k;
			}

			if (j < row & LUMatrixArr[j][j] != 0.0) {
				for (int i = j + 1; i < row; i++) {
					LUMatrixArr[i][j] /= LUMatrixArr[j][j];
				}
			}
		}
	}

	/**
	 * Solve the given Matrix.
	 * 
	 * @param the Matrix to solve
	 * @return the solved Matrix
	 */
	public Matrix solve(final Matrix B) {
		final int Brow = B.getColumn();
		final Matrix result = B.getSubMatrix(pivot, 0, Brow - 1);
		final double[][] X = result.getArray();

		for (int i = 0; i < column; i++) {
			for (int j = i + 1; j < column; j++) {
				for (int k = 0; k < Brow; k++) {
					X[j][k] -= X[i][k] * LUMatrixArr[j][i];
				}
			}
		}

		for (int i = column - 1; i >= 0; i--) {
			for (int j = 0; j < Brow; j++) {
				X[i][j] /= LUMatrixArr[i][i];
			}

			for (int k = 0; k < i; k++) {
				for (int j = 0; j < Brow; j++) {
					X[k][j] -= X[i][j] * LUMatrixArr[k][i];
				}
			}
		}

		return result;
	}
}
