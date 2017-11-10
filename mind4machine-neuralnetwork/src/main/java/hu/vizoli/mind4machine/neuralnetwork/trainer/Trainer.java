package hu.vizoli.mind4machine.neuralnetwork.trainer;

import java.io.Serializable;

import hu.vizoli.mind4machine.neuralnetwork.dataset.DataSet;
import hu.vizoli.mind4machine.neuralnetwork.lossfunction.LossFunction;
import hu.vizoli.mind4machine.neuralnetwork.network.NeuralNetwork;
import hu.vizoli.mind4machine.neuralnetwork.trainer.configuration.TrainerConfiguration;

/**
 * Interface for the Trainer implementations.
 * 
 * @author Zoltan Viski (vizoli)
 */
public interface Trainer extends Serializable {

	/**
	 * Sets the parent Neural Network.
	 * 
	 * @param parentNeuralNetwork the parent Neural Network
	 */
	public void setParentNeuralNetwork(NeuralNetwork parentNeuralNetwork);

	/**
	 * Trains the Neural Network based on the given DataSet.
	 * 
	 * @param trainingDataSet the training DataSet
	 */
	public void train(DataSet trainingDataSet);

	/**
	 * Returns the Trainer's configuration.
	 * 
	 * @return the configuration
	 */
	public TrainerConfiguration getTrainerConfiguration();

	/**
	 * Returns the parent Neural Network.
	 * 
	 * @return the parent Neural Network
	 */
	public NeuralNetwork getParentNeuralNetwork();

	/**
	 * Returns the Loss function.
	 * 
	 * @return the Loss function
	 */
	public LossFunction getLossFunction();

	/**
	 * Returns the current epoch.
	 * 
	 * @return the current epoch
	 */
	public int getCurrentEpochCount();

	/**
	 * Returns the eta.
	 * 
	 * @return the eta
	 */
	public double getEta();

}
