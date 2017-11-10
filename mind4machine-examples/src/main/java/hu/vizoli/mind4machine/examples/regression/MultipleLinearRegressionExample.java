package hu.vizoli.mind4machine.examples.regression;

import hu.vizoli.mind4machine.examples.data.SampleMatrixData;
import hu.vizoli.mind4machine.regression.MultipleLinearRegression;

/**
 * Sample use of the MultipleLinearRegression.
 *
 * @author Zoltan Viski (vizoli)
 */
public class MultipleLinearRegressionExample {

	public static void main(final String[] args) {
		final hu.vizoli.mind4machine.regression.MultipleLinearRegression multipleLinearRegression = new MultipleLinearRegression();
		multipleLinearRegression.addTrainingData(SampleMatrixData.multipleLinearRegressionTrainingXData().getArray(),
				SampleMatrixData.multipleLinearRegressionTrainingYData());

		System.out.println("Intercept: " + multipleLinearRegression.getIntercept());

		System.out.println("Coefficients:");
		for (final double coefficient : multipleLinearRegression.getCoefficients()) {
			System.out.println(coefficient);
		}

		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Prediction for 0.49 0.18: "
				+ multipleLinearRegression.predict(SampleMatrixData.multipleLinearRegressionSimpleTestXData()));

		System.out.println("Predictions for multiple data: ");
		for (final double y : multipleLinearRegression
				.predict(SampleMatrixData.multipleLinearRegressionMultipleTestXData().getArray())) {
			System.out.println("Prediction: " + y);
		}
	}

}
