package hu.vizoli.mind4machine.neuralnetwork.trainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.vizoli.mind4machine.neuralnetwork.dataset.DataSet;
import hu.vizoli.mind4machine.neuralnetwork.lossfunction.LossFunction;
import hu.vizoli.mind4machine.neuralnetwork.lossfunction.MeanSquaredError;
import hu.vizoli.mind4machine.neuralnetwork.network.NeuralNetwork;
import hu.vizoli.mind4machine.neuralnetwork.stopcriteria.StopCriteria;
import hu.vizoli.mind4machine.neuralnetwork.trainer.configuration.TrainerConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.trainer.event.TrainerEvent;
import hu.vizoli.mind4machine.neuralnetwork.trainer.event.TrainerObserver;
import hu.vizoli.mind4machine.neuralnetwork.trainingstrategy.TrainingStrategy;

/**
 * Implementation of the iterative learning.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class IterativeTrainer implements Trainer {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * The Trainer's configuration.
	 */
	private final TrainerConfiguration trainerConfiguration;

	/**
	 * The learning rate.
	 */
	private final double eta;

	/**
	 * The list of the Stop criterias.
	 */
	private final List<StopCriteria> stopCriterias;

	/**
	 * The Training strategy.
	 */
	private final TrainingStrategy trainingStrategy;

	/**
	 * The Loss function.
	 */
	private LossFunction lossFunction;

	/**
	 * The parent Neural Network.
	 */
	private NeuralNetwork parentNeuralNetwork;

	/**
	 * The current epoch counter.
	 */
	private int currentEpochCount = 0;

	/**
	 * Flag to training state.
	 */
	private boolean isTraining = false;

	/**
	 * Observers who are interested in the events of the class.
	 */
	private final Map<TrainerEvent.Type, List<TrainerObserver>> subscribers;

	/**
	 * Constructor.
	 * 
	 * @param trainerConfiguration the Trainer's configuration
	 */
	public IterativeTrainer(final TrainerConfiguration trainerConfiguration) {
		this.trainerConfiguration = trainerConfiguration;

		subscribers = new HashMap<>();

		eta = trainerConfiguration.getEta();

		trainingStrategy = trainerConfiguration.getTrainingStrategy();
		trainingStrategy.setParentTrainer(this);

		stopCriterias = trainerConfiguration.getStopCriterias();
		setupStopCriterias();
	}

	@Override
	public void train(final DataSet trainingDataSet) {
		lossFunction = new MeanSquaredError();
		isTraining = true;

		while (isTraining) {
			lossFunction.reset();

			trainingStrategy.startEpoch(trainingDataSet);

			currentEpochCount++;

			trainingStrategy.finishEpoch();
			notifyObservers(TrainerEvent.Type.EPOCH_FINISHED);

			if (hasFailStopCriteria()) {
				isTraining = false;

				notifyObservers(TrainerEvent.Type.TRAINING_FINISHED);
			}
		}
	}

	@Override
	public void subscribe(final TrainerEvent.Type trainerEvent, final TrainerObserver trainerObserver) {
		if (subscribers.get(trainerEvent) == null) {
			subscribers.put(trainerEvent, new ArrayList<>());
		}

		subscribers.get(trainerEvent).add(trainerObserver);
	}

	/**
	 * Notify all the subscribers who are interested in the given event.
	 * 
	 * @param trainerEventType the event type
	 */
	private void notifyObservers(final TrainerEvent.Type trainerEventType) {
		if (subscribers.get(trainerEventType) == null)
			return;

		for (final TrainerObserver trainerObserver : subscribers.get(trainerEventType)) {
			trainerObserver.handleTrainerEvent(trainerEventType);
		}
	}

	/**
	 * Setups the stop criterias.
	 */
	private void setupStopCriterias() {
		for (final StopCriteria stopCriteria : stopCriterias) {
			stopCriteria.setParentTrainer(this);
		}
	}

	/**
	 * Returns true, if there is Stop criteria which fails, false otherwise
	 * 
	 * @return the value
	 */
	private boolean hasFailStopCriteria() {
		for (final StopCriteria stopCriteria : stopCriterias) {
			if (stopCriteria.isFail()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void setParentNeuralNetwork(final NeuralNetwork parentNeuralNetwork) {
		this.parentNeuralNetwork = parentNeuralNetwork;
	}

	@Override
	public int getCurrentEpochCount() {
		return currentEpochCount;
	}

	@Override
	public LossFunction getLossFunction() {
		return lossFunction;
	}

	@Override
	public NeuralNetwork getParentNeuralNetwork() {
		return parentNeuralNetwork;
	}

	@Override
	public double getEta() {
		return eta;
	}

	@Override
	public TrainerConfiguration getTrainerConfiguration() {
		return trainerConfiguration;
	}
}
