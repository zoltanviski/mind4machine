package hu.vizoli.mind4machine.regression;

/**
 * Simple linear regression.
 * Uses least squares approach to calculate the values.
 * y = intercept + slope * x.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class SimpleLinearRegression extends AbstractRegression {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The slopes of the parameters.
	 */
	private double coefficient;

	/**
	 * Adds training data and performs linear regression on them.
	 * Calculate the intercept and the coefficient.
	 * 
	 * @param training data
	 */
	public void addTrainingData(final double[][] trainingData) {
		double sumX = 0.0;
		double sumY = 0.0;
		double xxbar = 0.0;
		double xybar = 0.0;

		n = trainingData.length;
		for (int i = 0; i < n; i++) {
			sumX += trainingData[i][0];
			sumY += trainingData[i][1];
		}

		final double xMean = sumX / n;
		final double yMean = sumY / n;

		for (int i = 0; i < n; i++) {
			xxbar += (trainingData[i][0] - xMean) * (trainingData[i][0] - xMean);
			xybar += (trainingData[i][0] - xMean) * (trainingData[i][1] - yMean);
		}

		coefficient = xybar / xxbar;
		intercept = yMean - coefficient * xMean;
	}

	/**
	 * Returns the coefficient.
	 * 
	 * @return coefficient
	 */
	public double getCoefficient() {
		return coefficient;
	}

	/**
	 * Returns the predicted value of the given x.
	 * 
	 * @param x value to predict
	 * @return the prediction of x
	 */
	public double predict(final double x) {
		return coefficient * x + intercept;
	}

	/**
	 * Returns the predicted values of the given x values.
	 * 
	 * @param x values to predict
	 * @return the predictions of x values
	 */
	public double[] predict(final double[] xArr) {
		final int n = xArr.length;
		final double[] result = new double[n];

		for (int i = 0; i < n; i++) {
			result[i] = coefficient * xArr[i] + intercept;
		}

		return result;
	}
}
