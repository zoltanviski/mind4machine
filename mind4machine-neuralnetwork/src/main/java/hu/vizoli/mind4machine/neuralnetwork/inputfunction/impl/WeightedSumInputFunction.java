package hu.vizoli.mind4machine.neuralnetwork.inputfunction.impl;

import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.connection.Connection;
import hu.vizoli.mind4machine.neuralnetwork.inputfunction.InputFunction;

/**
 * The weighted sum input function.
 * It calculates the total input of the Neuron.
 * Summarize all of the input connection input (the input Neuron's outputs) multiplied by
 * the Connection's Weight.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class WeightedSumInputFunction implements InputFunction {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 8L;

	@Override
	public double getOutput(final List<Connection> inputConnections) {
		double result = 0.0;

		for (final Connection connection : inputConnections) {
			result += connection.getInput() * connection.getWeight().getValue();
		}

		return result;
	}

}
