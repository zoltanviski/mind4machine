package hu.vizoli.mind4machine.neuralnetwork.connection;

import java.io.Serializable;

import hu.vizoli.mind4machine.neuralnetwork.connection.configuration.ConnectionConfiguration;
import hu.vizoli.mind4machine.neuralnetwork.neuron.AbstractNeuron;
import hu.vizoli.mind4machine.neuralnetwork.weight.Weight;

/**
 * The Connection between the Neurons.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class Connection implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 3L;

	/**
	 * The input Neuron.
	 */
	private final AbstractNeuron fromNeuron;

	/**
	 * The target Neuron.
	 */
	private final AbstractNeuron toNeuron;

	/**
	 * The Weight of the Connection.
	 */
	private Weight weight;

	/**
	 * Constructor.
	 * 
	 * @param connectionConfiguration the configuration
	 */
	public Connection(final ConnectionConfiguration connectionConfiguration) {
		fromNeuron = connectionConfiguration.getFromNeuron();
		toNeuron = connectionConfiguration.getToNeuron();
		weight = connectionConfiguration.getWeight();
	}

	/**
	 * Returns the Weight.
	 * 
	 * @return the weight
	 */
	public Weight getWeight() {
		return weight;
	}

	/**
	 * Sets the Weight.
	 * 
	 * @param weight the value
	 */
	public void setWeight(final Weight weight) {
		this.weight = weight;
	}

	/**
	 * Returns the output value of the input Neuron.
	 * 
	 * @return the value
	 */
	public double getInput() {
		return this.fromNeuron.getOutputValue();
	}

	/**
	 * Returns the target Neuron.
	 * 
	 * @return the Neuron
	 */
	public AbstractNeuron getToNeuron() {
		return toNeuron;
	}

	/**
	 * Returns the input Neuron.
	 * 
	 * @return the Neuron
	 */
	public AbstractNeuron getFromNeuron() {
		return fromNeuron;
	}
}
