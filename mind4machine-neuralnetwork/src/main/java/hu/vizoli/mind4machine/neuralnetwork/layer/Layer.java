package hu.vizoli.mind4machine.neuralnetwork.layer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.layer.configuration.LayerConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.neuron.AbstractNeuron;
import hu.vizoli.mind4machine.neuralnetwork.neuron.factory.NeuronFactory;

/**
 * Represents a Layer in the Neural Network.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class Layer implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 4L;

	/**
	 * The Layer's configuration.
	 */
	private final LayerConfiguration layerConfiguration;

	/**
	 * The list which holds all of the Neuron's reference
	 * within the Layer.
	 */
	private final List<AbstractNeuron> neurons;

	/**
	 * Constructor.
	 * 
	 * @param layerConfiguration the Layer's configuration
	 */
	public Layer(final LayerConfiguration layerConfiguration) {
		neurons = new ArrayList<AbstractNeuron>();

		this.layerConfiguration = layerConfiguration;

		addNeurons();
	}

	/**
	 * Adds a Neurons to the Layer based on the Neuron configuration of the Layer.
	 * Puts them to the neurons list.
	 */
	private void addNeurons() {
		final int n = layerConfiguration.getNeuronCount();

		for (int i = 0; i < n; i++) {
			final AbstractNeuron neuron = NeuronFactory.getNeuron(layerConfiguration.getNeuronConfiguration());
			neuron.setId(layerConfiguration.getNeuronConfiguration().getNeuronType().toString() + "_" + i);

			neurons.add(neuron);
		}

		if (layerConfiguration.getHasHasBiasNeuron()) {
			neurons.add(NeuronFactory.getBiasNeuron());
		}
	}

	/**
	 * Returns the Neuron's list.
	 * 
	 * @return the list
	 */
	public List<AbstractNeuron> getNeurons() {
		return neurons;
	}

	/**
	 * Calculates the activation value for all of the Neuron's.
	 */
	public void forward() {
		for (final AbstractNeuron neuron : neurons) {
			neuron.forward();
		}
	}
}
