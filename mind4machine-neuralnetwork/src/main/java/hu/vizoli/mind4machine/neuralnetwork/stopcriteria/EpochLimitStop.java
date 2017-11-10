package hu.vizoli.mind4machine.neuralnetwork.stopcriteria;

/**
 * Epoch Limit Stop criteria.
 * It fails if the current epoch reaches the iven epoch limit.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class EpochLimitStop extends AbstractStopFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 11L;

	/**
	 * The limit of the max epoch.
	 */
	private final int limit;

	/**
	 * Constructor.
	 * 
	 * @param limit the limit
	 */
	public EpochLimitStop(final int limit) {
		this.limit = limit;
	}

	@Override
	public boolean isFail() {
		if (parentTrainer.getCurrentEpochCount() >= limit) {
			return true;
		}

		return false;
	}
}
