package hu.vizoli.mind4machine.examples.data;

import hu.vizoli.mind4machine.util.matrix.Matrix;

/**
 * Sample data for the examples.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class SampleMatrixData {

	/**
	 * Returns a Matrix with data:
	 * Column 0: x 
	 * Column 1: y
	 * 
	 * @return the matrix
	 */
	public static Matrix simpleLinearRegressionTrainingData() {
		final double[][] result = { { 2.5, 28.3 }, { 6.1, 61.5 }, { 3.2, 33.1 }, { 4.8, 42.3 }, { 2.3, 24.1 },
				{ 1.5, 12.9 }, { 9.5, 98.5 }, { 14.5, 152.3 }, { 1.5, 11.0 }, { 2.0, 22.1 }, { 6.5, 67.4 } };

		return new Matrix(result);
	}

	public static Matrix multipleLinearRegressionTrainingXData() {
		final double[][] result = { { 1, 0.18, 0.89 }, { 1, 1.0, 0.26 }, { 1, 0.92, 0.11 }, { 1, 0.07, 0.37 },
				{ 1, 0.85, 0.16 }, { 1, 0.99, 0.41 }, { 1, 0.87, 0.47 } };

		return new Matrix(result);
	}

	public static double[] multipleLinearRegressionTrainingYData() {
		final double[] result = { 109.85, 155.72, 137.66, 76.17, 139.75, 162.6, 151.77 };

		return result;
	}

	public static double[] multipleLinearRegressionSimpleTestXData() {
		final double[] result = { 0.49, 0.18 };

		return result;
	}

	public static Matrix multipleLinearRegressionMultipleTestXData() {
		final double[][] result = { { 0.49, 0.18 }, { 0.57, 0.83 }, { 0.56, 0.64 }, { 0.76, 0.18 }, };

		return new Matrix(result);
	}

}
