package hu.vizoli.mind4machine.examples.regression;

import hu.vizoli.mind4machine.examples.data.SampleMatrixData;
import hu.vizoli.mind4machine.regression.SimpleLinearRegression;

/**
 * Sample use of the SimpleLinearRegression.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class SimpleLinearRegressionExample {

	public static void main(final String[] args) {
		final SimpleLinearRegression simpleLinearRegression = new SimpleLinearRegression();
		simpleLinearRegression.addTrainingData(SampleMatrixData.simpleLinearRegressionTrainingData().getArray());

		System.out.println("Intercept: " + simpleLinearRegression.getIntercept());
		System.out.println("Coefficient: " + simpleLinearRegression.getCoefficient());
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Prediction for 3.8: " + simpleLinearRegression.predict(3.8));

		final double[] testData = { 4.6, 9.2, 1.9 };
		final double[] testPredictions = simpleLinearRegression.predict(testData);

		final int n = testPredictions.length;
		for (int i = 0; i < n; i++) {
			System.out.println("Prediction for " + testData[i] + ": " + testPredictions[i]);
		}
	}

}
