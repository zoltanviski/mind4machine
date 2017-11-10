package hu.vizoli.mind4machine.neuralnetwork.activationfunction.type;

import hu.vizoli.mind4machine.neuralnetwork.activationfunction.ActivationFunction;
import hu.vizoli.mind4machine.neuralnetwork.activationfunction.BinaryStepActivation;
import hu.vizoli.mind4machine.neuralnetwork.activationfunction.LinearActivation;
import hu.vizoli.mind4machine.neuralnetwork.activationfunction.ReLuActivation;
import hu.vizoli.mind4machine.neuralnetwork.activationfunction.SigmoidActivation;

/**
 * Contains Activation Function Types.
 * 
 * @author Zoltan Viski (vizoli)
 */
public enum ActivationFunctionType {

	SIGMOID, LINEAR, RELU, BINARY_STEP;

	/**
	 * Returns the corresponding Class to the given Type.
	 * 
	 * @return the class
	 */
	public Class<? extends ActivationFunction> getTypeClass() {
		switch (this) {
		case SIGMOID:
			return SigmoidActivation.class;

		case LINEAR:
			return LinearActivation.class;

		case RELU:
			return ReLuActivation.class;

		case BINARY_STEP:
			return BinaryStepActivation.class;
		}

		return null;
	}
}