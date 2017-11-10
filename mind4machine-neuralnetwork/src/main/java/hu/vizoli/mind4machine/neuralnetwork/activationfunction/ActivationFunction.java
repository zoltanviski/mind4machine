package hu.vizoli.mind4machine.neuralnetwork.activationfunction;

import java.io.Serializable;

/**
 * Interface of the Activation functions.
 * 
 * @author Zoltan Viski (vizoli)
 */
public interface ActivationFunction extends Serializable {

	/**
	 * Returns the output of the activation.
	 * 
	 * @param neuronInputValue the value which is the output value of the Neuron's input function
	 * @return the output of the activation
	 */
	public double getOutput(double neuronInputValue);

	/**
	 * Returns the derivative of the Neuron.
	 * 
	 * @return the derivative
	 */
	public double getDerivative();

}
