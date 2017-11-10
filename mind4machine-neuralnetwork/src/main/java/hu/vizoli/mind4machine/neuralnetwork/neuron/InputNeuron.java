package hu.vizoli.mind4machine.neuralnetwork.neuron;

import hu.vizoli.mind4machine.neuralnetwork.neuron.configuration.NeuronConfiguration;

/**
 * Represents the input Neuron.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class InputNeuron extends AbstractNeuron {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * Constructor.
	 */
	public InputNeuron() {

	}

	/**
	 * Constructor.
	 * 
	 * @param neuronConfiguration the Neuron's configuration
	 */
	public InputNeuron(final NeuronConfiguration neuronConfiguration) {
		super(neuronConfiguration);
	}

	@Override
	public double getOutputValue() {
		return totalInputValue;
	}

}
