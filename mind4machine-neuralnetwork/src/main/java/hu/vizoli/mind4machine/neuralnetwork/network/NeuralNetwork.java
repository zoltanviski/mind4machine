package hu.vizoli.mind4machine.neuralnetwork.network;

import java.io.Serializable;
import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.dataset.DataSet;
import hu.vizoli.mind4machine.neuralnetwork.layer.Layer;
import hu.vizoli.mind4machine.neuralnetwork.trainer.Trainer;

/**
 * Interface for Neural Networks.
 * 
 * @author Zoltan Viski (vizoli)
 */
public interface NeuralNetwork extends Serializable {

	/**
	 * Trains the Neural Network for the given DataSet.
	 * 
	 * @param dataSet the values for the training
	 */
	public void train(final DataSet dataSet);

	/**
	 * Feed forward the values from the input Layer all the
	 * way through to the output Layer.
	 */
	public void forwardPropagation();

	/**
	 * Sets the values for the input Layer.
	 * 
	 * @param dataSetRow the values
	 */
	public void setInputs(final double[] dataSetRow);

	/**
	 * Returns the input Layer.
	 * 
	 * @return the Layer
	 */
	public Layer getInputLayer();

	/**
	 * Returns the output Layer.
	 * 
	 * @return the Layer
	 */
	public Layer getOuputLayer();

	/**
	 * Returns the hidden Layer list.
	 * 
	 * @return the list
	 */
	public List<Layer> getHiddenLayers();

	/**
	 * Returns all of the Layers within the Neural Network
	 * (input Layer, all hidden Layers and output Layer).
	 * 
	 * @return the list
	 */
	public List<Layer> getLayers();

	/**
	 * Returns the Trainer of the Neural Network.
	 * 
	 * @return the Trainer
	 */
	public Trainer getTrainer();

	/**
	 * Returns a prediction for a given values.
	 * The prediction based on the Neuron's Weights.
	 * 
	 * @param dataToPredict the input values
	 * @return the prediction for the given input values
	 */
	public double[] getPrediction(final double[] dataToPredict);

	/**
	 * Returns the output Layer values.
	 * 
	 * @return the values
	 */
	public double[] getOutputValues();

}
