package hu.vizoli.mind4machine.neuralnetwork.lossfunction;

/**
 * Calculates the Mean squared error of the predicted value.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class MeanSquaredError extends AbstractLossFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 10L;

	@Override
	public double[] calculatePatternLoss(final double[] predictedOutput, final double[] idealOutput) {
		final double[] patternLoss = new double[idealOutput.length];

		final int n = predictedOutput.length;
		for (int i = 0; i < n; i++) {
			patternLoss[i] = predictedOutput[i] - idealOutput[i];
			totalLoss += patternLoss[i] * patternLoss[i];
		}

		patternCount++;

		return patternLoss;
	}

	@Override
	public double getTotalLoss() {
		return totalLoss / (2 * patternCount);
	}
}
