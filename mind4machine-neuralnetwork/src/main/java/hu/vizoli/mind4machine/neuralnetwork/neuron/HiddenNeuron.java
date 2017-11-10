package hu.vizoli.mind4machine.neuralnetwork.neuron;

import hu.vizoli.mind4machine.neuralnetwork.neuron.configuration.NeuronConfiguration;

/**
 * Represents the Hidden Neuron.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class HiddenNeuron extends AbstractNeuron {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * Constructor.
	 */
	public HiddenNeuron() {

	}

	/**
	 * Constructor.
	 * 
	 * @param neuronConfiguration the Neuron's Configuration
	 */
	public HiddenNeuron(final NeuronConfiguration neuronConfiguration) {
		super(neuronConfiguration);
	}
}
