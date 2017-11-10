package hu.vizoli.mind4machine.regression;

import hu.vizoli.mind4machine.util.matrix.Matrix;

/**
 * Multiple linear regression.
 * Uses least squares approach to calculate the values.
 * y = intercept + coefficienti * xi (i = 1, 2..n).
 * 
 * @author Zoltan Viski (vizoli)
 */
public class MultipleLinearRegression extends AbstractRegression {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The slopes of the parameters.
	 */
	private double[] coefficients;

	/**
	 * Adds training data with ideal values.
	 * Compute the intercept and the coefficients.
	 * 
	 * @param training data features (X) 
	 * @param training data ideal values (Y)
	 */
	public void addTrainingData(final double[][] trainingDataX, final double[] trainingDataY) {
		n = trainingDataY.length;

		final Matrix trainingDataXMatrix = new Matrix(trainingDataX);
		final Matrix trainingDataYMatrix = new Matrix(trainingDataY, n, 1);

		final Matrix trainingXTransposed = trainingDataXMatrix.transpose();
		final Matrix transponsedXMultipiedByTrianingX = trainingXTransposed.multiply(trainingDataXMatrix);
		final Matrix transponsedXMultipiedByTrianingXInverse = transponsedXMultipiedByTrianingX.inverse();

		final Matrix transponsedXMultipiedByTrainingY = trainingXTransposed.multiply(trainingDataYMatrix);

		final Matrix transponsedXMultipiedByTrianingXInverseMultipliedByTransponsedXMultipiedByTrainingY = transponsedXMultipiedByTrianingXInverse
				.multiply(transponsedXMultipiedByTrainingY);

		final int n = transponsedXMultipiedByTrianingXInverseMultipliedByTransponsedXMultipiedByTrainingY.getRow();

		intercept = transponsedXMultipiedByTrianingXInverseMultipliedByTransponsedXMultipiedByTrainingY
				.getArray()[0][0];

		coefficients = new double[n - 1];
		for (int i = 1; i < n; i++) {
			coefficients[i - 1] = transponsedXMultipiedByTrianingXInverseMultipliedByTransponsedXMultipiedByTrainingY
					.getArray()[i][0];
		}
	}

	/**
	 * Returns prediction for the given test data.
	 * 
	 * @param data to predict
	 * @return the prediction 
	 */
	public double predict(final double[] testData) {
		double result = intercept;

		final int n = coefficients.length;
		for (int i = 0; i < n; i++) {
			result += coefficients[i] * testData[i];
		}

		return result;
	}

	/**
	 * Returns predictions for the given test data.
	 * 
	 * @param data to predict
	 * @return the predictions
	 */
	public double[] predict(final double[][] testData) {
		final int testDataCount = testData.length;
		final double[] result = new double[testDataCount];

		for (int row = 0; row < testDataCount; row++) {
			double sum = intercept;

			for (int column = 0; column < coefficients.length; column++) {
				sum += coefficients[column] * testData[row][column];
			}

			result[row] = sum;
		}

		return result;
	}

	/**
	 * Returns the coefficients.
	 * 
	 * @return the coefficients
	 */
	public double[] getCoefficients() {
		return coefficients;
	}
}
