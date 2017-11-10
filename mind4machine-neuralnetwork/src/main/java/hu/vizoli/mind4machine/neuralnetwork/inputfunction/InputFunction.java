package hu.vizoli.mind4machine.neuralnetwork.inputfunction;

import java.io.Serializable;
import java.util.List;

import hu.vizoli.mind4machine.neuralnetwork.connection.Connection;

/**
 * Interface for all of the Input function.
 * 
 * @author Zoltan Viski (vizoli)
 */
public interface InputFunction extends Serializable {

	/**
	 * Returns the value which will be digested by the Activation function of the Neuron.
	 * 
	 * @param inputConnections the Neuron's input Connections.
	 * @return the output to the Activation function
	 */
	public double getOutput(List<Connection> inputConnections);

}
