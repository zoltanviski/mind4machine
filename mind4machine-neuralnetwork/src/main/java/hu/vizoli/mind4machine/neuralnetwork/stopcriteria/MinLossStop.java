package hu.vizoli.mind4machine.neuralnetwork.stopcriteria;

/**
 * Min Loss Stop criteria.
 * It fails if the total loss of the Neural Network reaches the given min loss.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class MinLossStop extends AbstractStopFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 11L;

	/**
	 * The minimum value of the loss function
	 */
	private final double minLoss;

	/**
	 * Constructor.
	 * 
	 * @param minLoss the min loss value
	 */
	public MinLossStop(final double minLoss) {
		this.minLoss = minLoss;
	}

	@Override
	public boolean isFail() {
		if (parentTrainer.getLossFunction().getTotalLoss() <= minLoss) {
			return true;
		}

		return false;
	}
}
