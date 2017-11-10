package hu.vizoli.mind4machine.neuralnetwork.network;

import java.util.ArrayList;
import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.connection.factory.ConnectionFactory;
import hu.vizoli.mind4machine.neuralnetwork.dataset.DataSet;
import hu.vizoli.mind4machine.neuralnetwork.layer.Layer;
import hu.vizoli.mind4machine.neuralnetwork.layer.configuration.LayerConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.network.configuration.NeuralNetworkConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.trainer.Trainer;

/**
 * Universal Neural Network which is able to hold multiple hidden Layers.
 * It can be set up as Perceptron or a Multi Layer Perceptron.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class NeuralNetworkImpl implements NeuralNetwork {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The configuration of the Neural Network.
	 */
	private final NeuralNetworkConfiguration neuralNetworkConfiguration;

	/**
	 * The list of the hidden Layers.
	 */
	private final List<Layer> hiddenLayers;

	/**
	 * The list of all the Layers.
	 */
	private final List<Layer> layers;

	/**
	 * The Trainer of the Neural Network.
	 */
	private final Trainer trainer;

	/**
	 * The input Layer.
	 */
	private Layer inputLayer;

	/**
	 * The output Layer.
	 */
	private Layer outputLayer;

	/**
	 * Constructor.
	 * 
	 * @param neuralNetworkConfiguration the configuration of the Neural Network.
	 */
	public NeuralNetworkImpl(final NeuralNetworkConfiguration neuralNetworkConfiguration) {
		layers = new ArrayList<Layer>();
		hiddenLayers = new ArrayList<Layer>();

		this.neuralNetworkConfiguration = neuralNetworkConfiguration;

		trainer = neuralNetworkConfiguration.getTrainer();
		trainer.setParentNeuralNetwork(this);

		createNetwork();
	}

	@Override
	public void forwardPropagation() {
		for (final Layer layer : getHiddenLayers()) {
			layer.forward();
		}

		getOuputLayer().forward();
	}

	@Override
	public void setInputs(final double[] dataSetRow) {
		final int n = dataSetRow.length;
		for (int i = 0; i < n; i++) {
			getInputLayer().getNeurons().get(i).setTotalInputValue(dataSetRow[i]);
		}
	}

	@Override
	public void train(final DataSet trainingDataSet) {
		trainer.train(trainingDataSet);
	}

	@Override
	public double[] getPrediction(final double[] dataToPredict) {
		setInputs(dataToPredict);
		forwardPropagation();

		final double[] result = getOutputValues();

		return result;
	}

	@Override
	public double[] getOutputValues() {
		final double[] result = new double[outputLayer.getNeurons().size()];

		final int n = result.length;
		for (int i = 0; i < n; i++) {
			result[i] = outputLayer.getNeurons().get(i).getOutputValue();
		}

		return result;
	}

	/**
	 * Creates the Layers and the Connections between them.
	 */
	private void createNetwork() {
		createLayers();
		createConnections();
	}

	/**
	 * Create the Layers.
	 */
	private void createLayers() {
		inputLayer = new Layer(neuralNetworkConfiguration.getInputLayerConfiguration());
		layers.add(inputLayer);

		for (final LayerConfiguration layerConfiguration : neuralNetworkConfiguration.getHiddenLayersConfiguration()) {
			final Layer hiddenLayer = new Layer(layerConfiguration);

			hiddenLayers.add(hiddenLayer);
			layers.add(hiddenLayer);
		}

		outputLayer = new Layer(neuralNetworkConfiguration.getOutputLayerConfiguration());
		layers.add(outputLayer);
	}

	/**
	 * Create the Connections between the Layers.
	 */
	private void createConnections() {
		Layer layer = inputLayer;

		final int n = layers.size();
		for (int i = 1; i < n; i++) {
			final Layer actualLayer = layers.get(i);

			ConnectionFactory.fullConnect(layer, actualLayer);

			layer = actualLayer;
		}
	}

	@Override
	public Layer getInputLayer() {
		return inputLayer;
	}

	@Override
	public List<Layer> getHiddenLayers() {
		return hiddenLayers;
	}

	@Override
	public Layer getOuputLayer() {
		return outputLayer;
	}

	@Override
	public List<Layer> getLayers() {
		return layers;
	}

	@Override
	public Trainer getTrainer() {
		return trainer;
	}
}
