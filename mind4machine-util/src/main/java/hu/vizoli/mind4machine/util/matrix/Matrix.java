package hu.vizoli.mind4machine.util.matrix;

/**
 * Matrix representation with all of the important operations.
 * Uses double[][] for storing the data internally.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class Matrix {
	private final double[][] matrixArr;
	private final int row;
	private final int column;

	/**
	 * Returns identity matrix of the given size.
	 * 
	 * @param size of the matrix
	 * @return the identity matrix
	 */
	public static Matrix getIdentity(final int size) {
		final Matrix result = new Matrix(size);

		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				final double value = (row == column) ? 1.0 : 0.0;

				result.set(row, column, value);
			}
		}

		return result;
	}

	/**
	 * Create a Matrix instance of given size (square).
	 * 
	 * @param the size of the matrix
	 */
	public Matrix(final int size) {
		this.matrixArr = new double[size][size];
		this.row = size;
		this.column = size;
	}

	/**
	 * Create a Matrix instance of given size (row and column).
	 * 
	 * @param the row dimension of the matrix
	 * @param the column dimension of the matrix
	 */
	public Matrix(final int row, final int column) {
		this.matrixArr = new double[row][column];
		this.row = row;
		this.column = column;
	}

	/**
	 * Create a Matrix instance of given data and size (row and column).
	 * 
	 * @param the data
	 * @param the row dimension of the matrix
	 * @param the column dimension of the matrix
	 */
	public Matrix(final double[][] arr, final int row, final int column) {
		this.matrixArr = arr;
		this.row = row;
		this.column = column;
	}

	/**
	 * Create a Matrix instance of given data.
	 * 
	 * @param the data 
	 */
	public Matrix(final double[][] arr) {
		this.row = arr.length;
		this.column = arr[0].length;
		this.matrixArr = arr;
	}

	/**
	 * Create a Matrix instance of given data and size (row and column).
	 * The data is 1D array so the created Matrix will be 1D as well.
	 * 
	 * @param the data
	 * @param the row dimension of the matrix
	 * @param the column dimension of the matrix
	 */
	public Matrix(final double[] arr, final int row, final int column) {
		matrixArr = new double[row][column];
		this.row = row;
		this.column = column;

		if (row == 1) {
			for (int i = 0; i < column; i++) {
				matrixArr[0][i] = arr[i];
			}
		} else {
			for (int i = 0; i < row; i++) {
				matrixArr[i][0] = arr[i];
			}
		}
	}

	/**
	 * Returns a Matrix element of given position.
	 * 
	 * @param row position of the element
	 * @param column position of the element
	 * @return the element
	 */
	public double get(final int row, final int column) {
		return matrixArr[row][column];
	}

	/**
	 * Sets a Matrix position with a given value.
	 * 
	 * @param row position of the element
	 * @param column position of the element
	 * @param value to set
	 */
	public void set(final int row, final int column, final double value) {
		matrixArr[row][column] = value;
	}

	/**
	 * Returns internally array representation of the Matrix.
	 * 
	 * @return the array
	 */
	public double[][] getArray() {
		return matrixArr;
	}

	/**
	 * Returns the internally array representation of the Matrix with deep copy.
	 * 
	 * @return the array
	 */
	public double[][] getArrayCopy() {
		final double[][] result = new double[row][column];

		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				result[row][column] = matrixArr[row][column];
			}
		}

		return result;
	}

	/**
	 * Returns a sub matrix.
	 * 
	 * @param row values
	 * @param column where the sub matrix generated from
	 * @param column where the sub matrix generated to
	 * @return the sub matrix
	 */
	public Matrix getSubMatrix(final int[] rowValues, final int columnFrom, final int columnTo) {
		final Matrix result = new Matrix(rowValues.length, columnTo - columnFrom + 1);

		try {
			for (int row = 0; row < rowValues.length; row++) {
				for (int column = columnFrom; column <= columnTo; column++) {
					result.set(row, column - columnFrom, matrixArr[rowValues[row]][column]);
				}
			}
		} catch (final ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
			throw new ArrayIndexOutOfBoundsException("Submatrix indices!");
		}

		return result;
	}

	/**
	 * Returns the transposed Matrix.
	 * 
	 * @return the transposed Matrix
	 */
	public Matrix transpose() {
		final Matrix result = new Matrix(column, row);
		final double[][] matrixArray = result.getArray();

		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				matrixArray[column][row] = matrixArr[row][column];
			}
		}

		return result;
	}

	/**
	 * Returns the product Matrix multiplied by the given multiplicand Matrix.
	 * 
	 * @param multiplicand Matrix
	 * @return the product Matrix
	 */
	public Matrix multiply(final Matrix multiplicand) {
		final Matrix result = new Matrix(row, multiplicand.getColumn());

		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < multiplicand.getColumn(); column++) {
				double value = 0.0;

				for (int mulitplierRow = 0; mulitplierRow < multiplicand.getRow(); mulitplierRow++) {
					value += matrixArr[row][mulitplierRow] * multiplicand.get(mulitplierRow, column);
				}
				result.set(row, column, value);
			}
		}

		return result;
	}

	/**
	 * Returns the inverse Matrix.
	 * 
	 * @return the inverse Matrix
	 */
	public Matrix inverse() {
		final Matrix identity = Matrix.getIdentity(row);

		return solve(identity);
	}

	/**
	 * Returns the row dimension of the Matrix.
	 * 
	 * @return the row dimension
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Returns the column dimension of the Matrix.
	 * 
	 * @return the column dimension
	 */
	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder();

		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				stringBuilder.append(matrixArr[row][column] + " ");
			}

			stringBuilder.append(System.getProperty("line.separator"));
		}

		return stringBuilder.toString();
	}

	/**
	 * Solve the Matrix.
	 * 
	 * @param B
	 * @return the solved Matrix
	 */
	private Matrix solve(final Matrix B) {
		return (new LUDecomposition(this)).solve(B);
	}
}