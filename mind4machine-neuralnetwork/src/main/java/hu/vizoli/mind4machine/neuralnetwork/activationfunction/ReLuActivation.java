package hu.vizoli.mind4machine.neuralnetwork.activationfunction;

public class ReLuActivation implements ActivationFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 9L;

	private transient double neuronInputValue = 0.0;

	@Override
	public double getOutput(final double neuronInputValue) {
		this.neuronInputValue = neuronInputValue;

		return Math.max(0, neuronInputValue);
	}

	@Override
	public double getDerivative() {
		if (neuronInputValue > Double.MIN_VALUE)
			return 1;
		return 0;
	}
}
