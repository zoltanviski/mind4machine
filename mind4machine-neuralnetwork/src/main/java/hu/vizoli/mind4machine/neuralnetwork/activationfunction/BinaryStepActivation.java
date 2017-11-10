package hu.vizoli.mind4machine.neuralnetwork.activationfunction;

/**
 * Binary step activation function.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class BinaryStepActivation implements ActivationFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 9L;

	@Override
	public double getOutput(final double neuronInputValue) {
		double result = 0.0;

		if (neuronInputValue > 0.0) {
			result = 1.0;
		}

		return result;
	}

	@Override
	public double getDerivative() {
		return 1.0;
	}

}
