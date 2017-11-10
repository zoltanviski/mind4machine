package hu.vizoli.mind4machine.neuralnetwork.activationfunction;

public class SigmoidActivation implements ActivationFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 9L;

	private transient double output = 0.0;

	@Override
	public double getOutput(final double neuronInputValue) {
		if (neuronInputValue > 100) {
			return 1.0;
		} else if (neuronInputValue < -100) {
			return 0.0;
		}

		final double den = 1 + Math.exp(-1 * neuronInputValue);
		this.output = (1d / den);

		return this.output;

	}

	@Override
	public double getDerivative() {
		final double result = this.output * (1d - this.output);

		return result;
	}

}
