package hu.vizoli.mind4machine.neuralnetwork.neuron.configuration;

import java.io.Serializable;

import hu.vizoli.mind4machine.neuralnetwork.activationfunction.type.ActivationFunctionType;
import hu.vizoli.mind4machine.neuralnetwork.inputfunction.type.InputFunctionType;
import hu.vizoli.mind4machine.neuralnetwork.neuron.type.NeuronType;

/**
 * Configuration for a Neuron.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class NeuronConfiguration implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 13L;

	/**
	 * The Input function type of the Neuron.
	 */
	private InputFunctionType inputFunctionType;

	/**
	 * The Activation function type of the Neuron.
	 */
	private ActivationFunctionType activationFunctionType;

	/**
	 * The Neuron's type.
	 */
	private NeuronType neuronType;

	/**
	 * Returns the Input function type.
	 * 
	 * @return the function type
	 */
	public InputFunctionType getInputFunctionType() {
		return inputFunctionType;
	}

	/**
	 * Sets the Input function type.
	 * 
	 * @param inputFunctionType the value
	 * @return the instance
	 */
	public NeuronConfiguration setInputFunctionType(final InputFunctionType inputFunctionType) {
		this.inputFunctionType = inputFunctionType;

		return this;
	}

	/**
	 * Returns the Activation function type.
	 * 
	 * @return the activation function type
	 */
	public ActivationFunctionType getActivationFunctionType() {
		return activationFunctionType;
	}

	/**
	 * Sets the Activation function type.
	 * 
	 * @param activationFunctionType the value
	 * @return the instance
	 */
	public NeuronConfiguration setActivationFunctionType(final ActivationFunctionType activationFunctionType) {
		this.activationFunctionType = activationFunctionType;

		return this;
	}

	/**
	 * Returns the Neuron's type.
	 * 
	 * @return the type
	 */
	public NeuronType getNeuronType() {
		return neuronType;
	}

	/**
	 * Sets the Neuron's type.
	 * 
	 * @param neuronType the value
	 * @return the instance
	 */
	public NeuronConfiguration setNeuronType(final NeuronType neuronType) {
		this.neuronType = neuronType;

		return this;
	}
}
