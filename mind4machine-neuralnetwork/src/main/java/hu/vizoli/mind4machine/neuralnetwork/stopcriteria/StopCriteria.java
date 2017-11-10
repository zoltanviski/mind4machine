package hu.vizoli.mind4machine.neuralnetwork.stopcriteria;

import java.io.Serializable;

import hu.vizoli.mind4machine.neuralnetwork.trainer.Trainer;

/**
 * Interface for all of the Stop criteira implementations.
 * 
 * @author Zoltan Viski (vizoli)
 */
public interface StopCriteria extends Serializable {

	/**
	 * Returns true if the criteria fails, false otherwise.
	 * 
	 * @return the value
	 */
	public boolean isFail();

	/**
	 * Sets the parent Trainer of the Stop criteria
	 * 
	 * @param trainer the Trainer
	 */
	public void setParentTrainer(Trainer trainer);

}
