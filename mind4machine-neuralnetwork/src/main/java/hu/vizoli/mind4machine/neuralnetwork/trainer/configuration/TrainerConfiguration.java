package hu.vizoli.mind4machine.neuralnetwork.trainer.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.lossfunction.LossFunction;
import hu.vizoli.mind4machine.neuralnetwork.stopcriteria.StopCriteria;
import hu.vizoli.mind4machine.neuralnetwork.trainingstrategy.TrainingStrategy;

/**
 * Configuration for the Trainer.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class TrainerConfiguration implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 17L;

	/**
	 * The strategy for the learning.
	 */
	private TrainingStrategy trainingStrategy;

	/**
	 * The Loss function.
	 */
	private LossFunction lossFunction;

	/**
	 * The list of the Stop criterias.
	 */
	private final List<StopCriteria> stopCriterias;

	/**
	 * The learning rate.
	 */
	private double eta;

	/**
	 * Constructor.
	 */
	public TrainerConfiguration() {
		stopCriterias = new ArrayList<StopCriteria>();
	}

	/**
	 * Returns the list of the stop criterias.
	 * 
	 * @return the list
	 */
	public List<StopCriteria> getStopCriterias() {
		return stopCriterias;
	}

	/**
	 * Adds stop criteria to the list.
	 * 
	 * @param stopCriteria the stop criteria
	 * @return the instance
	 */
	public TrainerConfiguration addStopCriteria(final StopCriteria stopCriteria) {
		stopCriterias.add(stopCriteria);

		return this;
	}

	/**
	 * Returns the Training strategy.
	 * 
	 * @return the Training strategy
	 */
	public TrainingStrategy getTrainingStrategy() {
		return trainingStrategy;
	}

	/**
	 * Sets the Training strategy.
	 * 
	 * @param trainingStrategy the value
	 * @return the instance
	 */
	public TrainerConfiguration setTrainingStrategy(final TrainingStrategy trainingStrategy) {
		this.trainingStrategy = trainingStrategy;

		return this;
	}

	/**
	 * Returns the Loss function.
	 * 
	 * @return the loss function
	 */
	public LossFunction getLossFunction() {
		return lossFunction;
	}

	/**
	 * Sets the Loss function.
	 * 
	 * @param lossFunction the value
	 * @return the instance
	 */
	public TrainerConfiguration setLossFunction(final LossFunction lossFunction) {
		this.lossFunction = lossFunction;

		return this;
	}

	/**
	 * Returns the eta value.
	 * 
	 * @return the eta
	 */
	public double getEta() {
		return eta;
	}

	/**
	 * Sets the eta.
	 * 
	 * @param eta the value
	 * @return the instance
	 */
	public TrainerConfiguration setEta(final double eta) {
		this.eta = eta;

		return this;
	}

}
