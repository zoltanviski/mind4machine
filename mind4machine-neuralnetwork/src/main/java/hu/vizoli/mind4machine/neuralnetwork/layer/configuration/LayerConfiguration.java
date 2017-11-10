package hu.vizoli.mind4machine.neuralnetwork.layer.configuration;

import java.io.Serializable;

import hu.vizoli.mind4machine.neuralnetwork.neuron.configuration.NeuronConfiguration;

/**
 * Configuration for the Layer.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class LayerConfiguration implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 14L;

	/**
	 * Neuron's configuration.
	 * The Layer will create all of it's Neurons based on 
	 * this configuration.
	 */
	private NeuronConfiguration neuronConfiguration;

	/**
	 * Count of the Neurons in the Layer.
	 */
	private int neuronCount;

	/**
	 * Flag for the Bias Neuron existence.
	 */
	private boolean hasBiasNeuron;

	/**
	 * Returns the Neuron's count.
	 * 
	 * @return the Neuron's count
	 */
	public int getNeuronCount() {
		return neuronCount;
	}

	/**
	 * Sets the Neuron's count.
	 * 
	 * @param neuronCount the value
	 * @return the instance
	 */
	public LayerConfiguration setNeuronCount(final int neuronCount) {
		this.neuronCount = neuronCount;

		return this;
	}

	/**
	 * Returns the Neuron's configuration.
	 * 
	 * @return the configuration
	 */
	public NeuronConfiguration getNeuronConfiguration() {
		return neuronConfiguration;
	}

	/**
	 * Sets the Neuron's configuration.
	 * 
	 * @param neuronConfiguration the configuration
	 * @return the instance
	 */
	public LayerConfiguration setNeuronConfiguration(final NeuronConfiguration neuronConfiguration) {
		this.neuronConfiguration = neuronConfiguration;

		return this;
	}

	/**
	 * Returns true if the Layer has Bias Neuron, false otherwise.
	 * 
	 * @return the flag
	 */
	public boolean getHasHasBiasNeuron() {
		return hasBiasNeuron;
	}

	/**
	 * Sets the Bias Neuron's existence flag.
	 * 
	 * @param hasBiasNeuron the flag's value
	 * @return the instance
	 */
	public LayerConfiguration setHasHasBiasNeuron(final boolean hasBiasNeuron) {
		this.hasBiasNeuron = hasBiasNeuron;

		return this;
	}
}
