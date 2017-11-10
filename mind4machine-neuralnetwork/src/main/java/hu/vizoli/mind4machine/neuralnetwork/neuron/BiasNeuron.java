package hu.vizoli.mind4machine.neuralnetwork.neuron;

import hu.vizoli.mind4machine.neuralnetwork.activationfunction.BinaryStepActivation;
import hu.vizoli.mind4machine.neuralnetwork.connection.Connection;
import hu.vizoli.mind4machine.neuralnetwork.neuron.configuration.NeuronConfiguration;

/**
 * Represents the Bias Neuron.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class BiasNeuron extends AbstractNeuron {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * Constructor.
	 */
	public BiasNeuron() {
		activationFunction = new BinaryStepActivation();
	}

	/**
	 * Constructor.
	 * 
	 * @param neuronConfiguration the Neuron's Configuration
	 */
	public BiasNeuron(final NeuronConfiguration neuronConfiguration) {
		super(neuronConfiguration);
	}

	@Override
	public void forward() {

	}

	@Override
	public double getOutputValue() {
		return 1;
	}

	@Override
	public void addInputConnection(final Connection connection) {

	}
}
