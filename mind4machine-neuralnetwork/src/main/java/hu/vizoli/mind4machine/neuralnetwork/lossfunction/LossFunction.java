package hu.vizoli.mind4machine.neuralnetwork.lossfunction;

import java.io.Serializable;

/**
 * Interface for all of the Loss functions.
 * 
 * @author Zoltan Viski (vizoli)
 */
public interface LossFunction extends Serializable {

	/**
	 * Returns the total loss value.
	 * 
	 * @return the value
	 */
	public double getTotalLoss();

	/**
	 * Calculates the error of the given pattern.
	 * 
	 * @param predictedOutput the predicted value of the Neural Network
	 * @param idealOutput the expected output (Supervised learning)
	 * @return the loss value for the given pattern
	 */
	public double[] calculatePatternLoss(double[] predictedOutput, double[] idealOutput);

	/**
	 * Resets the function.
	 */
	public void reset();

}
