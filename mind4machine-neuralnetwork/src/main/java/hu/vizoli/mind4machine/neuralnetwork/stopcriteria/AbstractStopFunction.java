package hu.vizoli.mind4machine.neuralnetwork.stopcriteria;

import hu.vizoli.mind4machine.neuralnetwork.trainer.Trainer;

/**
 * Abstract class for all of the Stop criteria implementations.
 * 
 * @author Zoltan Viski (vizoli)
 */
public abstract class AbstractStopFunction implements StopCriteria {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 11L;

	/**
	 * The Trainer who uses the function.
	 */
	protected Trainer parentTrainer;

	/**
	 * Returns the parent Trainer.
	 * 
	 * @return the Trainer
	 */
	public Trainer getParentTrainer() {
		return parentTrainer;
	}

	@Override
	public void setParentTrainer(final Trainer parentTrainer) {
		this.parentTrainer = parentTrainer;
	}
}
