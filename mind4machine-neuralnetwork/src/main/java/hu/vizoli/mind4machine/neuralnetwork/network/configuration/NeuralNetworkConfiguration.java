package hu.vizoli.mind4machine.neuralnetwork.network.configuration;

import java.io.Serializable;
import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.layer.configuration.LayerConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.trainer.Trainer;

/**
 * Configuration for the Neural Network.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class NeuralNetworkConfiguration implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 16L;

	/**
	 * Layer's configuration.
	 */
	private LayerConfiguration inputLayerConfiguration;

	/**
	 * List of hidden Layers configuration.
	 */
	private List<LayerConfiguration> hiddenLayersConfiguration;

	/**
	 * The output layer configuration.
	 */
	private LayerConfiguration outputLayerConfiguration;

	/**
	 * The Trainer of the Neural Network.
	 */
	private Trainer trainer;

	/**
	 * Returns the input Layer's configuration.
	 * 
	 * @return the configuration
	 */
	public LayerConfiguration getInputLayerConfiguration() {
		return inputLayerConfiguration;
	}

	/**
	 * Sets the input Layer's configuration.
	 * 
	 * @param inputLayerConfiguration the value
	 * @return the instance
	 */
	public NeuralNetworkConfiguration setInputLayerConfiguration(final LayerConfiguration inputLayerConfiguration) {
		this.inputLayerConfiguration = inputLayerConfiguration;

		return this;
	}

	/**
	 * Returns the hidden Layer's list.
	 * 
	 * @return the list
	 */
	public List<LayerConfiguration> getHiddenLayersConfiguration() {
		return hiddenLayersConfiguration;
	}

	/**
	 * Sets the hidden Layers's configuration.
	 * 
	 * @param hiddenLayerConfigurations the value
	 * @return the instance
	 */
	public NeuralNetworkConfiguration setHiddenLayersConfiguration(
			final List<LayerConfiguration> hiddenLayerConfigurations) {
		this.hiddenLayersConfiguration = hiddenLayerConfigurations;

		return this;
	}

	/**
	 * Returns the output Layer's configuration.
	 * 
	 * @return the configuration
	 */
	public LayerConfiguration getOutputLayerConfiguration() {
		return outputLayerConfiguration;
	}

	/**
	 * Sets the output Layer's configuration.
	 * 
	 * @param outputLayerConfiguration the value
	 * @return the instance
	 */
	public NeuralNetworkConfiguration setOutputLayerConfiguration(final LayerConfiguration outputLayerConfiguration) {
		this.outputLayerConfiguration = outputLayerConfiguration;

		return this;
	}

	/**
	 * Returns the Trainer.
	 * 
	 * @return the trainer
	 */
	public Trainer getTrainer() {
		return trainer;
	}

	/**
	 * Sets the Trainer.
	 * 
	 * @param trainer the value
	 * @return the instance
	 */
	public NeuralNetworkConfiguration setTrainer(final Trainer trainer) {
		this.trainer = trainer;

		return this;
	}
}
