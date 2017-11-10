package hu.vizoli.mind4machine.neuralnetwork.trainingstrategy;

import java.io.Serializable;

import hu.vizoli.mind4machine.neuralnetwork.dataset.DataSet;
import hu.vizoli.mind4machine.neuralnetwork.trainer.Trainer;

/**
 * Interface for all Training strategies implementations.
 * 
 * @author Zoltan Viski (vizoli)
 */
public interface TrainingStrategy extends Serializable {

	/**
	 * Sets the parent Trainer.
	 * 
	 * @param parentTrainer the parent Trainer
	 */
	public void setParentTrainer(Trainer parentTrainer);

	/**
	 * Starts the current epoch training with a given DataSet.
	 * 
	 * @param trainingDataSet the training DataSet
	 */
	public void startEpoch(DataSet trainingDataSet);

	/**
	 * Finish the epoch.
	 */
	public void finishEpoch();

}
