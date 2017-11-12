package hu.vizoli.mind4machine.neuralnetwork.trainer.event;

/**
 * Interface for all of the classes which would like to subscribe to Trainer's events.
 * 
 * @author Zoltan Viski (vizoli)
 */
public interface TrainerObserver {

	/**
	 * It will be called by the Trainer when it 
	 * fires an event.
	 * 
	 * @param trainerEventType the event type
	 */
	public void handleTrainerEvent(TrainerEvent.Type trainerEventType);

}
