package hu.vizoli.mind4machine.neuralnetwork.neuron;

import hu.vizoli.mind4machine.neuralnetwork.neuron.configuration.NeuronConfiguration;

/**
 * Represents the output Neuron.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class OutputNeuron extends AbstractNeuron {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * Constructor.
	 */
	public OutputNeuron() {

	}

	/**
	 * Constructor.
	 * 
	 * @param neuronConfiguration the Neuron's configuration
	 */
	public OutputNeuron(final NeuronConfiguration neuronConfiguration) {
		super(neuronConfiguration);
	}
}
