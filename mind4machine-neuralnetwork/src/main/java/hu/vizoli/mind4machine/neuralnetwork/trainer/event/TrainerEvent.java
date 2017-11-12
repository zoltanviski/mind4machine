package hu.vizoli.mind4machine.neuralnetwork.trainer.event;

/**
 * Trainer's events.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class TrainerEvent {

	/**
	 * The possible types of the event.
	 */
	public static enum Type {
		EPOCH_FINISHED, TRAINING_FINISHED
	}

}
