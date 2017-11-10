package hu.vizoli.mind4machine.neuralnetwork.lossfunction;

/**
 * Abstract class for all of the Loss functions.
 * 
 * @author Zoltan Viski (vizoli)
 */
public abstract class AbstractLossFunction implements LossFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 10L;

	/**
	 * The value which holds the total loss of the 
	 * Neural network (current epoch).
	 */
	protected transient double totalLoss;

	/**
	 * The count of the patterns.
	 */
	protected transient double patternCount;

	@Override
	public void reset() {
		totalLoss = 0.0;
		patternCount = 0;
	}

}
