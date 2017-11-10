package hu.vizoli.mind4machine.regression;

import java.io.Serializable;

/**
 * Base class for all regression implementations.
 * 
 * @author Zoltan Viski (vizoli)
 */
public abstract class AbstractRegression implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The bias for the polynom.
	 */
	protected double intercept;

	/**
	 * The number of observations.
	 */
	protected int n;

	/**
	 * Returns the intercept.
	 * 
	 * @return the intercept
	 */
	public double getIntercept() {
		return intercept;
	}
}
