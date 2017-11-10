package hu.vizoli.mind4machine.neuralnetwork.connection.configuration;

import java.io.Serializable;

import hu.vizoli.mind4machine.neuralnetwork.neuron.AbstractNeuron;
import hu.vizoli.mind4machine.neuralnetwork.weight.Weight;

/**
 * Configuration for the Neuron's Connection classes.
 * 
 * @author Zoltan Viski (vizoli)
 */
public class ConnectionConfiguration implements Serializable {

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 12L;

	/**
	 * The input Neuron's reference.
	 */
	private AbstractNeuron fromNeuron;

	/**
	 * The target Neuron's reference.
	 */
	private AbstractNeuron toNeuron;

	/**
	 * The weight of the conncetion.
	 */
	private Weight weight;

	/**
	 * Returns the input Neuron.
	 * 
	 * @return the input Neuron.
	 */
	public AbstractNeuron getFromNeuron() {
		return fromNeuron;
	}

	/**
	 * Constructor of the class.
	 * 
	 * @return the instance
	 */
	public AbstractNeuron getToNeuron() {
		return toNeuron;
	}

	/**
	 * Returns the weight.
	 * 
	 * @return the weight
	 */
	public Weight getWeight() {
		return weight;
	}

	/**
	 * Sets the input Neuron.
	 * 
	 * @param fromNeuron the input Neuron
	 */
	public void setFromNeuron(final AbstractNeuron fromNeuron) {
		this.fromNeuron = fromNeuron;
	}

	/**
	 * Sets the target Neuron.
	 * 
	 * @param toNeuron the target Neuron
	 */
	public void setToNeuron(final AbstractNeuron toNeuron) {
		this.toNeuron = toNeuron;
	}

	/**
	 * Sets the weight.
	 * 
	 * @param weight the value
	 */
	public void setWeight(final Weight weight) {
		this.weight = weight;
	}
}
