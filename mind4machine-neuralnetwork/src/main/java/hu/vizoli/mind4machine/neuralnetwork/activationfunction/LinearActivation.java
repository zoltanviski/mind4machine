package hu.vizoli.mind4machine.neuralnetwork.activationfunction;

/**
 * Linear Activation function.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class LinearActivation implements ActivationFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 9L;

	@Override
	public double getOutput(final double neuronInputValue) {
		return neuronInputValue;
	}

	@Override
	public double getDerivative() {
		return 1.0;
	}
}
